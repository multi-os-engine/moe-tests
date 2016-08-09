/*
 * Copyright (C) 2015 Intel Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.moe;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;

import org.apache.harmony.jpda.tests.share.AllTests;

import org.moe.common.exec.AbstractJarExec;
import org.moe.common.exec.ExecRunner;
import org.moe.common.exec.IOutputListener;

public class HarmonyRunner {

    private static String path;

    public static void main(String[] args) throws IOException, InterruptedException {
        System.setProperty("jpda.settings.debuggeeJavaExec", "java -jar " + InstallTestSelector());
        System.setProperty("jpda.settings.transportAddress", "localhost:" + Utils.DEBUG_PORT);
        System.setProperty("jpda.settings.syncPort", "" + Utils.SYNC_PORT);

        for (boolean b : new boolean[]{false/*, true*/}) {
            path = buildApp(new File(new File(System.getProperty("user.dir")), "HarmonyRunner").getAbsolutePath(), b);
            uploadApp(path, b);

            new Thread(new Runnable() {
                @Override
                public void run() {
                    startRunnerServer(b);
                }
            }).start();

            AllTests.main(new String[]{});

            stopRunnerServer();
        }
    }

    private static String InstallTestSelector() throws IOException {
        File tmp = File.createTempFile("TestSelector", ".jar");

        JarOutputStream target = new JarOutputStream(new FileOutputStream(tmp));

        for (Class<?> cls : new Class<?>[]{TestSelector.class, Utils.class}){
            JarEntry classEntry = new JarEntry(cls.getName().replaceAll("\\.", "\\/") + ".class");
            target.putNextEntry(classEntry);

            InputStream stream = cls.getResourceAsStream(cls.getSimpleName() + ".class");

            byte[] buffer = new byte[1024];
            while (true)
            {
              int count = stream.read(buffer);
              if (count == -1)
                break;
              target.write(buffer, 0, count);
            }

            stream.close();

            target.closeEntry();
        }

        {
            JarEntry manifestEntry = new JarEntry("META-INF/MANIFEST.MF");
            target.putNextEntry(manifestEntry);

            target.write(("Manifest-Version: 1.0\nMain-Class: " + TestSelector.class.getName() + "\n").getBytes());

            target.closeEntry();
        }

        target.close();

        return tmp.getAbsolutePath();
    }

    private static ServerSocket serviceSocket = null;

    public static void stopRunnerServer() {
        if (serviceSocket != null) {
            try {
                serviceSocket.close();
            } catch (IOException e) { }
        }
    }

    public static void startRunnerServer(boolean device) {
        try {
            serviceSocket = new ServerSocket(Utils.RUNNER_PORT);

            try {
                boolean run = true;
                while (run) {
                    Socket clientSocket = serviceSocket.accept();

                    try {
                        DataInputStream is = new DataInputStream(clientSocket.getInputStream());

                        try {
                            String cmd = is.readUTF();

                            if (cmd.equals("#")) {
                                run = false;
                            } else {
                                ArrayList<String> vmArgs = new ArrayList<>();
                                while (!cmd.startsWith("#")) {
                                    vmArgs.add(cmd);
                                    cmd = is.readUTF();
                                }
                                String name = cmd.substring(1);

                                final Object[] statusRef = new Object[1];
                                Thread exitThread = new Thread(new Runnable() {
                                    @Override
                                    public void run() {
                                        statusRef[0] = waitForExitStatus();
                                    }
                                });
                                exitThread.start();

                                runApp(path, device, vmArgs, name);

                                try {
                                    exitThread.join();
                                } catch (InterruptedException e) {}

                                DataOutputStream os = new DataOutputStream(clientSocket.getOutputStream());

                                try {
                                    os.writeInt((int)statusRef[0]);
                                    os.flush();
                                } finally {
                                    os.close();
                                }
                            }
                        } finally {
                            is.close();
                        }
                    } finally {
                        clientSocket.close();
                    }
                }
            } finally {
                serviceSocket.close();
            }
        } catch (IOException e) {
           return;
        }
    }

    public static int waitForExitStatus() {
        try {
            ServerSocket serviceSocket = new ServerSocket(Utils.EXIT_PORT);

            try {
                Socket clientSocket = serviceSocket.accept();

                try {
                    DataInputStream is = new DataInputStream(clientSocket.getInputStream());

                    try {
                        return is.readInt();
                    } finally {
                        is.close();
                    }
                } finally {
                    clientSocket.close();
                }
            } finally {
                serviceSocket.close();
            }
        } catch (IOException e) {
           return 0;
        }
    }

    public static String buildApp(String path, boolean device) throws IOException, InterruptedException {
        File buildDir = new File(path);
        String suffix = device ? "os" : "simulator";

        ProcessBuilder pb = new ProcessBuilder("../gradlew", "moeMainReleaseIphone" + suffix + "XcodeBuild");
        pb.directory(buildDir);
        pb.inheritIO();
        Process p = pb.start();
        int ret = p.waitFor();

        if (ret != 0) {
            throw new RuntimeException("Building application returned with "+ ret);
        }

        return new File(buildDir, "build/moe/xcodebuild/sym/Release-iphone" + suffix + "/HarmonyRunner.app").getAbsolutePath();
    }

    public static void uploadApp(String appPatch, boolean device) {
        if (device) {
            DeviceLauncherExec exec = new DeviceLauncherExec();

            //exec.getArguments().add(getDeviceArg() + "=" + target)

            exec.getArguments().add("--app-path=" + appPatch);

            exec.getArguments().add("--install-mode=installonly");

            ExecRunner runner;
            try {
                runner = exec.getRunner();
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
                return;
            }
            runner.setListener(new IOutputListener() {
                @Override
                public void output(String line) {
                    System.out.println(line);
                }
            });

            try {
                if (runner.run(null) != 0) {
                    new RuntimeException("failed to install application").printStackTrace();
                    System.exit(1);
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
    }

    public static void runApp(String appPatch, boolean device, List<String> vmArgs, String test) {
        Process lldb = null;
        Thread lldbThread = null;

        AbstractJarExec exec = device ? new DeviceLauncherExec() : new SimulatorLauncherExec();

        //exec.getArguments().add(getDeviceArg() + "=" + target)

        exec.getArguments().add("--app-path=" + appPatch);

        if (device) {
            exec.getArguments().add("--proxy-port=" + Utils.RUNNER_PORT);
            exec.getArguments().add("--proxy-port=" + Utils.DEBUG_PORT);
            exec.getArguments().add("--proxy-port=" + Utils.SYNC_PORT);
            exec.getArguments().add("--proxy-port=" + Utils.EXIT_PORT);
            exec.getArguments().add("-m=runonly");
        } else {
            try {
                ProcessBuilder pb = new ProcessBuilder("lldb", "attach", "-o", "c", "-w", "-n", "HarmonyRunner");
                pb.redirectErrorStream(true);
                lldb = pb.start();
                lldbThread = new Thread(new Runnable() {
                    Process proc;

                    @Override
                    public void run() {
                        System.out.println(" -- LLDB: thread has started");
                        BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
                        String line;
                        try {
                            while ((line = reader.readLine()) != null)
                                System.out.println(" -- LLDB: " + line);
                        } catch (IOException e) { }
                        System.out.println(" -- LLDB: thread has ended");
                    }

                    Runnable withProcess(Process proc) {
                        this.proc = proc;
                        return this;
                    }
                }.withProcess(lldb));
                lldbThread.start();
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            }

            exec.getArguments().add("--wait-for-debugger");
            exec.getArguments().add("--dont-activate");
        }

        exec.getArguments().add("-x=-mainClass");
        exec.getArguments().add("-x=" + test);

        for (String arg : vmArgs) {
            exec.getArguments().add("-x=" + arg);
        }

        exec.getArguments().add("-x=" + Utils.EXIT_PORT);

        exec.getArguments().add("-e=DYLD_FORCE_FLAT_NAMESPACE=1");

        ExecRunner runner;
        try {
            runner = exec.getRunner();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
            return;
        }
        runner.setListener(new IOutputListener() {
            @Override
            public void output(String line) {
                System.out.println(line);
            }
        });

        try {
            runner.run(null);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        if (!device) {
            lldb.destroyForcibly();
            try {
                lldb.waitFor();
            } catch (InterruptedException e) { }
            try {
                lldbThread.join();
            } catch (InterruptedException e) { }
        }
    }
}

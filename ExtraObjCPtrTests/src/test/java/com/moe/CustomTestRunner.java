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
import java.util.ArrayList;

import org.junit.runner.Description;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

import org.moe.mdt.junit.MoeRemoteTestRunner.MessageIds;


public class CustomTestRunner {
	public static void main(String[] args) {
		ArrayList<Class<?>> classList = new ArrayList<Class<?>>();
        for (String arg : args) {
            String[] subs = arg.split("[,]");
            for (String sub : subs) {
                if (sub.length() == 0) {
                    continue;
                }
                Class<?> cls = null;
                try {
                    cls = Class.forName(sub);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                if (cls != null) {
                    classList.add(cls);
                }
            }
        }
        if (classList.size() == 0) {
            for (String sub : new String[] {
            	"org.moe.UninitializedRuntime"
            }) {
                if (sub.length() == 0) {
                    continue;
                }
                Class<?> cls = null;
                try {
                    cls = Class.forName(sub);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                if (cls != null) {
                    classList.add(cls);
                }
            }
        }
        if (classList.size() > 0) {
            Class<?>[] classArray = new Class<?>[classList.size()];
            runTests(classList.toArray(classArray));
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}
	
	private static void runTests(Class<?>[] testsClasses) {

        JUnitCore junit = new JUnitCore();
        junit.addListener(new RunListener() {
            /**
             * Called before any tests have been run.
             */
            public void testRunStarted(Description description) throws java.lang.Exception {
                for (Description child : description.getChildren()) {
                    defineTest(child);
                }
                sendMessage(MessageIds.TEST_RUN_START + ":" + description.testCount());
            }

            /**
             * Called internally for defining tests.
             */
            private void defineTest(Description description) {
                if (description.isTest()) {
                    sendMessage(MessageIds.TEST_DEFINE + ":" + description.getClassName() + "-"
                            + description.getMethodName());
                    return;
                }
                if (description.getChildren() == null || description.getChildren().size() == 0) {
                    return;
                }
                for (Description child : description.getChildren()) {
                    defineTest(child);
                }
            }

            /**
             *  Called when all tests have finished.
             */
            public void testRunFinished(Result result) throws java.lang.Exception {
                sendMessage(MessageIds.TEST_RUN_END + ":" + result.getRunTime());
            }

            /**
             *  Called when an atomic test is about to be started.
             */
            public void testStarted(Description description) throws java.lang.Exception {
                sendMessage(MessageIds.TEST_START + ":" + description.getClassName() + "-"
                        + description.getMethodName());
            }

            /**
             *  Called when an atomic test has finished, whether the test succeeds or fails.
             */
            public void testFinished(Description description) throws java.lang.Exception {
                sendMessage(MessageIds.TEST_END + ":" + description.getClassName() + "-"
                        + description.getMethodName());
            }

            /**
             *  Called when an atomic test fails.
             */
            public void testFailure(Failure failure) throws java.lang.Exception {
                sendMessage(MessageIds.TEST_FAILED + ":" + failure.getTestHeader() + ":"
                        + failure.getTrace());
            }

            /**
             * Called when a test will not be run, generally because a test method is
             * annotated with Ignore.
             */
            public void testIgnored(Description description) throws java.lang.Exception {
                sendMessage(MessageIds.TEST_IGNORED + ":" + description.getClassName() + "-"
                        + description.getMethodName());
            }
        });
        junit.run(testsClasses);
    }
	
	private static void sendMessage(String message) {
        System.out.println(message);
        System.out.flush();
    }
}

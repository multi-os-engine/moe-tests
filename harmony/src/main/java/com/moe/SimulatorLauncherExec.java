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

import org.moe.common.exec.AbstractJarExec;

import java.io.File;
import java.io.IOException;

public class SimulatorLauncherExec extends AbstractJarExec {

    static final File LAUNCHER_FILE;

    static {
        try {
            LAUNCHER_FILE = AbstractJarExec.copyToTmpFromResource(
                    "/org/moe/launchers/moe.ios.simulator.launcher-1.0.0.final-2.jar",
                    "moe.ios.simulator.launcher");
        } catch (IOException e) {
            throw new RuntimeException("Failed to load simulator launcher jar");
        }
    }

    public SimulatorLauncherExec() {
        super(LAUNCHER_FILE);
        getVmArguments().add("-XstartOnFirstThread");
    }
}

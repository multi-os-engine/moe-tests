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

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TestSelector {
	private static final String JDWP_USUAL_PREFIX = "-agentlib:jdwp=";
	private static final String JDWP_ART_PREFIX = "-Xrunjdwp:";
	
	public static void main(String[] args) throws IOException {		
		ArrayList<String> forwardedArgs = new ArrayList<>(args.length);
		
		for (String arg : args) {
			if (arg.startsWith("-D")) {
				forwardedArgs.add(arg);
			} else if (arg.startsWith(JDWP_USUAL_PREFIX)) {
				forwardedArgs.add(JDWP_ART_PREFIX + arg.substring(JDWP_USUAL_PREFIX.length()));
			}			
		}
		
		forwardedArgs.add("#" + args[args.length-1]);

		System.exit(startDebugee(forwardedArgs));
	}
	
	private static int startDebugee(List<String> args) {
		try {
			Socket clientSocket = new Socket("localhost", Utils.RUNNER_PORT);
			
			try {
				DataOutputStream os = new DataOutputStream(clientSocket.getOutputStream());
				
				try {			
					for (String arg : args) {						
						os.writeUTF(arg);
						os.flush();
					}

					DataInputStream is = new DataInputStream(clientSocket.getInputStream());
					
					try {		
						return is.readInt();
					} finally {
						is.close();
					}
				} finally {
					os.close();
				}
			} finally {
				clientSocket.close();
			}	    
		} catch (IOException e) {
			return 0;
		}
	}
}

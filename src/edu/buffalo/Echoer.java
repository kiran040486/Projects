package edu.buffalo;

import java.util.Scanner;

import edu.buffalo.util.Listener;

public class Echoer {

	/**
	 * Main entry point for args
	 */
	public static void main(String[] args) {

		String[] inputs = args;
		if (inputs.length == 2) {
			System.out.println("tcp port:" + inputs[0]);
			System.out.println("udp port:" + inputs[1]);

			// start the server with 7 threads now
			System.out.println("---Server started----");

			// listen for commands
			Listener listen = new Listener();
			System.out.print(" >>");
			Scanner in = new Scanner(System.in);
			String line = null;
			String response = null;

			while ((line = in.nextLine()).length() > 0) {
				
				if ("quit".equalsIgnoreCase(line)) {
					break;
				}

				response = listen.doWork(line);
				System.out.println("\t" + response);

				// take in next input
				System.out.print(" >>");
				in = new Scanner(System.in);
			}

			// System.out.println(inputs[2]);
		} else {
			System.out.println(inputs.length + " Arguments not valid");
		}
		
		System.out.println("System quit!!");

	}

}

package edu.buffalo;

import java.util.Scanner;

import edu.buffalo.util.Listener;
import edu.buffalo.util.Server;

public class Echoer {

	/**
	 * Main entry point for args
	 */
	public static void main(String[] args) {
		int tcp = 8989; // Default value
		int udp;

		String[] inputs = args;
		if (inputs.length == 2) {
			//System.out.println("tcp port:" + inputs[0]);
			//System.out.println("udp port:" + inputs[1]);

			// start the server
			startServer(tcp);

			// listen for commands
			System.out.println("------------------------------------------");
			System.out.println("shell window starting. enter 'quit' to exit");
			System.out.println("------------------------------------------");
			startShell();

			// System.out.println(inputs[2]);
		} else {
			System.out.println(inputs.length + " Arguments not valid");
		}

		System.out.println("System quit!!");

	}
	
	/**
	 * start server thread
	 * @param tcp
	 */
	public static void startServer(int tcp){
		System.out.println("---Starting server at port:" + tcp + "----");
		try {
			Server server = new Server(tcp);
			Thread thread = new Thread(server);
			thread.start();
			System.out.println("---Started server at port:" + tcp + "----");
		} catch (Exception ex) {
			ex.printStackTrace(); // error creating server hence quit
			return;
		}
	}
	
	/**
	 * shell command window
	 */
	public static void startShell(){
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
	}

}

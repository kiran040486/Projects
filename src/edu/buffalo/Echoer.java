package edu.buffalo;

import java.util.Scanner;

import edu.buffalo.util.Listener;
import edu.buffalo.util.Server;
import edu.buffalo.util.ServerConnections;

public class Echoer {
	
	public static String INFO = "info";

	/**
	 * Main entry point for args
	 */
	public static void main(String[] args) {
		int tcp = 8989; // Default value
		//int udp;

		String[] inputs = args;
		if (inputs.length == 2) {
			//System.out.println("tcp port:" + inputs[0]);
			//System.out.println("udp port:" + inputs[1]);
			ServerConnections.TCP_PORT = Integer.valueOf(inputs[0]);
			ServerConnections.UDP_PORT = Integer.valueOf(inputs[1]);

			// start the server
			startServer(ServerConnections.TCP_PORT);

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
			System.exit(1);
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
			
			if(INFO.equalsIgnoreCase(line)){
				response = info();
			}else{
				response = listen.doWork(line);
			}

			
			System.out.println("" + response);

			// take in next input
			System.out.print(" >>");
			in = new Scanner(System.in);
		}
	}
	
	/**
	 * returns info command output
	 * @return
	 */
	public static String info(){
		StringBuffer info = new StringBuffer();
		info.append("IP Address     | Host Name     | UDP Port    | TCP Port\n");
		info.append("-------------------------------------------------------\n");
		info.append(ServerConnections.IP_ADDRESS + "  |  " + ServerConnections.HOST_NAME + "  |  " + ServerConnections.UDP_PORT + "  |  " + ServerConnections.TCP_PORT);
		
		return info.toString();
	}

}

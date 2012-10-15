package edu.buffalo.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Maintains a list of active connections
 * @author bhatt
 *
 */

public class ServerConnections {
	
	//make this synchronized
	public static List<Connection> activeConnection = new ArrayList<Connection>();
	public static int connectionCounter; //Do we need to recycle this
	
	//initialized on first run
	public static int TCP_PORT = 8989;
	public static int UDP_PORT = 0;
	public static String IP_ADDRESS = "127.0.0.1";
	public static String HOST_NAME = "sol.cse.buffalo.edu";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

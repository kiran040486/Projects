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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

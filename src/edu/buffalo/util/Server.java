package edu.buffalo.util;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.net.ServerSocketFactory;

/**
 * 
 * Server thread listening on particular port numbers.
 *
 */
public class Server implements Runnable {
	
	private ServerSocket socket;
	
	public Server(int port)throws IOException{
		this.socket = ServerSocketFactory.getDefault().createServerSocket(port);
	}
	

	@Override
	public void run() {
		while(true){
			Socket client = null;
			try{
				
				//all ugly stuff here
				
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

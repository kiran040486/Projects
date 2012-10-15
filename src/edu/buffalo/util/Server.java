package edu.buffalo.util;

import java.io.IOException;
import java.net.InetAddress;
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
		ServerConnections.IP_ADDRESS = InetAddress.getLocalHost().getHostAddress();
		ServerConnections.HOST_NAME = InetAddress.getLocalHost().getHostName();
	}
	

	@Override
	public void run() {
		while(true){
			Socket client = null;
			try{
				client = socket.accept();
				//TODO: do the book keeping here. store in a list or something
				
				Connection connection = new Connection();
				connection.localPort = client.getLocalPort();
				connection.remotePort = client.getPort();
				connection.ip = client.getInetAddress().getHostAddress();
				connection.hostname = client.getInetAddress().getHostName();
				connection.connectionId = ServerConnections.connectionCounter++;
				
				ServerConnections.activeConnection.add(connection);
				
				
				Runnable connectionHandler = new ConnectionHandler(client);
				new Thread(connectionHandler).start();
				
				connection.handler = (ConnectionHandler)connectionHandler;
				
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String input = "send 10.20.390.0 hello how are you doing";
		String[] params = input.split(" ");
		System.out.println(params.length);

	}

}

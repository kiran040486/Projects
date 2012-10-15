package edu.buffalo.util;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
	private Socket socket;
	private String host; //because we can connect to any host
	
	public Client(String host){
		this.host = host;
	}
	
	public void sendTcp(String text, int port){
		String response = null;
		try{
			
			socket = new Socket(host, port);
			socket.setSoTimeout(500);
			ObjectOutputStream os = new ObjectOutputStream(
					socket.getOutputStream());
			os.writeObject(text);
			
			ObjectInputStream inpstr = new ObjectInputStream(
					socket.getInputStream());
			response = (String) inpstr.readObject();
			
		}catch (ClassNotFoundException cx) {
			cx.printStackTrace();
			// why this kolaveri?
			

		} catch (InterruptedIOException timeout) {
			timeout.printStackTrace();
			
		} catch (IOException ex) {
			// there can be so many reasons why this error coming up.
			// let treat this as timeout
			ex.printStackTrace();
			
		} finally {
			System.out.println("RESPONSE:" + response);
			
		}
	}
	
	public void sendUdp(String ipAddress, int udpPort, String message){
		
		
		
		
		
	}

}

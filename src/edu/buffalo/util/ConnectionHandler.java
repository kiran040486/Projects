package edu.buffalo.util;

import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * Handles socket connection so frees main thread of doing all the work thus,
 * making it multithreaded
 * 
 * @author bhatt
 * 
 */
public class ConnectionHandler implements Runnable {
	Socket socket = null;

	public ConnectionHandler(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {

		// do the work with socket here
		if (socket != null) {
			try{
			ObjectInputStream inpstr = new ObjectInputStream(
					socket.getInputStream());
			String req = (String) inpstr.readObject(); // input if any
			
			
			//send response if seeking one
			}catch(Exception ex){
				ex.printStackTrace();
			}

		}

	}

}

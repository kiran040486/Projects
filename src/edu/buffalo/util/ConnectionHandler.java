package edu.buffalo.util;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
			try {
				ObjectInputStream inpstr = new ObjectInputStream(
						socket.getInputStream());
				String req = (String) inpstr.readObject(); // input if any

				// send response if seeking one

				// remove from active connections list
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}

	}

	/**
	 * 
	 * @param message
	 */
	public String send(String message) {
		if (socket != null) {
			try {

				ObjectOutputStream os = new ObjectOutputStream(
						socket.getOutputStream());
				os.writeObject(message);
				os.flush();
				os.close();
				return "message sent";
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			return "error sending";

		}
		return "socket error";
	}

	/**
	 * 
	 * @return
	 */
	public String disconnect() {
		if (this.socket.isConnected()) {

			try {
				this.socket.close();

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		return null;
	}

}

package edu.buffalo.util;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer implements Runnable {

	// UDP port
	int port = 50000;

	public UDPServer(int port) {
		this.port = port;
	}

	@Override
	public void run() {

		try {
			DatagramSocket serverSocket = new DatagramSocket(this.port);
			byte[] receiveData = new byte[1024];
			while (true) {
				DatagramPacket receivePacket = new DatagramPacket(receiveData,
						receiveData.length);
				serverSocket.receive(receivePacket);
				String sentence = new String(receivePacket.getData());
				System.out.println("RECEIVED: " + sentence);
				InetAddress IPAddress = receivePacket.getAddress();
				System.out.println("echoing " + sentence);
				System.out.println("to: IP = " + IPAddress);

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}

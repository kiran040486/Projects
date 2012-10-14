package edu.buffalo.util;

/**
 * Connection info
 * 
 *
 */
public class Connection {
	public int connectionId;
	public String ip;
	public String hostname;
	public int localPort;
	public int remotePort;
	
	public Connection(){
		
	}

	public Connection(int connectionId, String ip, String hostname,
			int localPort, int remotePort) {
		super();
		this.connectionId = connectionId;
		this.ip = ip;
		this.hostname = hostname;
		this.localPort = localPort;
		this.remotePort = remotePort;
	}
	
	

}
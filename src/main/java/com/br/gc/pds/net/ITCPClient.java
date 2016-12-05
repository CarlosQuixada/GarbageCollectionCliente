package com.br.gc.pds.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public interface ITCPClient {

	public void sendRequest(String request);
	public Object getResponse();
	public void close();
	public void setServerHost(String serverHost);
	public void setServerPort(int serverPort);
	public String getServerHost();
	public int getServerPort();
	public void setIn(DataInputStream in);
	public void setOut(DataOutputStream out);
	public void setSocket(Socket socket);
	
}

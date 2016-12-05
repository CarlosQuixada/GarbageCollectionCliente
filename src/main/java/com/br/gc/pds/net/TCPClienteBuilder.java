package com.br.gc.pds.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.br.gc.pds.model.Lixeiras.Lixeira;

public class TCPClienteBuilder {
	private ITCPClient cliente;
	
	public TCPClienteBuilder(){
		this.cliente = new GarbageCollectorCliente();
	}
	
	public TCPClienteBuilder serverHost(String serverHost){
		this.cliente.setServerHost(serverHost);
		return this;
	}
	
	public TCPClienteBuilder serverPort(int serverPort){
		this.cliente.setServerPort(serverPort);
		return this;
	}
	
	public ITCPClient build() throws UnknownHostException, IOException{
		Socket socket = new Socket(
				this.cliente.getServerHost(),
				this.cliente.getServerPort());
		
		DataInputStream in = new DataInputStream(socket.getInputStream());
		DataOutputStream out = new DataOutputStream(socket.getOutputStream());
		
		cliente.setIn(in);
		cliente.setOut(out);
		cliente.setSocket(socket);
		
		return this.cliente;
	}
}

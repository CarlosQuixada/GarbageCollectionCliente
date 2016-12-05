package com.br.gc.pds.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import com.br.gc.pds.model.Lixeiras.ListaLixeira;
import com.br.gc.pds.model.Rotas.ListaRota;

public class GarbageCollectorCliente implements ITCPClient {
	private String serverHost;
	private int serverPort;
	private Socket socket;
	private DataInputStream in;
	private DataOutputStream out;

	public String getServerHost() {
		return serverHost;
	}

	public void setServerHost(String serverHost) {
		this.serverHost = serverHost;
	}

	public int getServerPort() {
		return serverPort;
	}

	public void setServerPort(int serverPort) {
		this.serverPort = serverPort;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public void setIn(DataInputStream in) {
		this.in = in;
	}

	public void setOut(DataOutputStream out) {
		this.out = out;
	}

	public static TCPClienteBuilder Builder() {
		return new TCPClienteBuilder();
	}

	@Override
	public void sendRequest(String request) {
		try {
			this.out.writeUTF(request);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Object getResponse() {

		try {
			ListaRota listaRota = ListaRota.parseFrom(socket.getInputStream());
			return listaRota;
		} catch (Exception e) {
			try {
				ListaLixeira listaLixeira = ListaLixeira.parseFrom(socket.getInputStream());
				return listaLixeira;
			} catch (Exception e2) {
				String response;
				try {
					response = this.in.readUTF();
					return response;
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		}

		return null;
	}

	@Override
	public void close() {
		try {
			this.socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

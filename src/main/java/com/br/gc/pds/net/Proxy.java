package com.br.gc.pds.net;

import java.io.IOException;

public class Proxy {
	TCPCliente cliente;

	public Proxy() {
		try {
			cliente = TCPCliente.Builder().serverHost("192.168.1.9").serverPort(2008).build();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void enviarMensagem(String mensagem) {
		cliente.sendRequest(mensagem);
	}

	public String receberMensagem() {
		return cliente.getResponse();
	}
}

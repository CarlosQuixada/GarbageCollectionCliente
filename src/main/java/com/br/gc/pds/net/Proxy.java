package com.br.gc.pds.net;

import java.io.IOException;

public class Proxy {
	ITCPClient cliente;

	public Proxy() {
		try {
			cliente = GarbageCollectorCliente.Builder().serverHost("127.0.0.1").serverPort(9090).build();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void enviarMensagem(String mensagem) {
		cliente.sendRequest(mensagem);
	}

	public Object receberMensagem() {
		return cliente.getResponse();
	}
}

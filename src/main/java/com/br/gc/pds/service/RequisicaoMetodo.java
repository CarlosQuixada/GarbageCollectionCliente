package com.br.gc.pds.service;

import java.util.Random;

import com.br.gc.pds.model.Mensagem;
import com.br.gc.pds.net.Cliente;

public class RequisicaoMetodo {
	private Mensagem mensagem;
	private Random requestId;
	private Cliente cliente;

	public RequisicaoMetodo(Mensagem mensagem) {
		this.mensagem = mensagem;
		requestId = new Random();
	}

	public String doOperations(String objectReference, String methodId) {
		cliente = new Cliente();
		mensagem.setMethodId(methodId);
		mensagem.setObjectReference(objectReference);
		mensagem.setMessageType(0);
		mensagem.setRequestId(requestId.nextInt(1000) + 1);
		cliente.enviarRequest(mensagem.toString());
		return mensagem.toString();
	}

	public String doOperations(String objectReference, String methodId, String arguments) {
		cliente = new Cliente();
		mensagem.setArguments(arguments);
		mensagem.setMethodId(methodId);
		mensagem.setObjectReference(objectReference);
		mensagem.setRequestId(1);
		mensagem.setMessageType(0);
		cliente.enviarRequest(mensagem.toString());
		System.out.println(cliente.receberResposta());
		return mensagem.toString();
	}
}

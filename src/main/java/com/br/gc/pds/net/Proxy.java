package com.br.gc.pds.net;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.br.gc.pds.model.Lixeiras.ListaLixeira;
import com.br.gc.pds.model.Lixeiras.Lixeira;
import com.br.gc.pds.model.Mensagem;
import com.br.gc.pds.model.Rotas.ListaRota;
import com.br.gc.pds.model.Rotas.Rota;
import com.google.protobuf.InvalidProtocolBufferException;

public class Proxy {
	GarbageCollectorCliente cliente;
	private Mensagem mensagem;
	
	
	
	public List<Lixeira> buscarLixeira() {
		mensagem = empacotar("Lixeira", "getLixeiras",new ArrayList<String>());
		List<Lixeira> listaLixeira;
		try {
			listaLixeira = ListaLixeira.parseFrom(doOperations(mensagem)).getLixeiraList();
			return listaLixeira;
		} catch (InvalidProtocolBufferException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public List<Rota> calcularRota(){
		List<Lixeira> lixeiras = buscarLixeira();
		List<String> pontosLixeira = new ArrayList<>();
		pontosLixeira.add("-3.765529,-38.637767");
		pontosLixeira.add("-3.720905,-38.510949");

		for(Lixeira lixeira : lixeiras){
			if(lixeira.getStatusCapacidade().equals(Lixeira.StatusCapacidade.CHEIA)){
				pontosLixeira.add(lixeira.getLocalizacao());
			}
		}
		
		
		mensagem = empacotar("Rota","calcularRota", pontosLixeira);
		List<Rota> listaRota;
		try {
			listaRota = ListaRota.parseFrom(doOperations(mensagem)).getRotaList();
			return listaRota;
		} catch (InvalidProtocolBufferException e) {
			e.printStackTrace();
		}
		 
		return null;
	}
	
	public byte[] doOperations(Mensagem mensagem){
		try {
			cliente.Builder().serverHost("127.0.0.1").serverPort(9090).build();
			cliente.sendRequest(mensagem.toString());
			
			return cliente.getResponse();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public Mensagem empacotar(String objectReference, String methodId,List<String> arguments){
		mensagem =new Mensagem();
		mensagem.setArguments(arguments);
		mensagem.setMethodId(methodId);
		mensagem.setObjectReference(objectReference);
		mensagem.setRequestId(1);
		mensagem.setMessageType(0);
		
		return mensagem;
	}
}

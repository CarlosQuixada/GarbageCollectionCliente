package com.br.gc.pds.service;

import org.springframework.stereotype.Service;

import com.br.gc.pds.model.Lixeiras.ListaLixeira;
import com.br.gc.pds.model.Mensagem;

@Service
public class ApiService {
	
	private Mensagem mensagem;
	private RequisicaoMetodo requisicao;
	
	public ListaLixeira listarLixeiras(){
		mensagem = new Mensagem();
		requisicao = new RequisicaoMetodo(mensagem);
		String pacote = requisicao.doOperations("ListaLixeiras","getLixeiras");
		System.out.println(pacote);
		return null;
	}
	
	public void tracarRota(){
		mensagem = new Mensagem();
		requisicao = new RequisicaoMetodo(mensagem);
		String posicaoA = "-3.765529,-38.637767";
		String posicaoB = "-3.720905,-38.510949";
		String arguments =posicaoA+"**"+posicaoB;
		String pacote = requisicao.doOperations("Distancia", "calcularDistancia", arguments);
	}
}

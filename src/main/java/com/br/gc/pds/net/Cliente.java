package com.br.gc.pds.net;

public class Cliente {
	
	private Proxy proxy;
	
	public Cliente(){
		proxy = new Proxy();
	}
	
	public void enviarRequest(String mensagem){
		proxy.enviarMensagem(mensagem);
	}
	
	public Object receberResposta(){
		return proxy.receberMensagem();
	}
}

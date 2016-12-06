package com.br.gc.pds.model;

import com.br.gc.pds.model.Lixeiras.Lixeira.StatusCapacidade;
import com.br.gc.pds.model.Lixeiras.Lixeira.StatusColeta;

public class Lixeira {
	
	private Long id;
	private String localizacao;
	private Float peso;
	private StatusColeta statusColeta;
	private StatusCapacidade statusCapacidade;
	
}

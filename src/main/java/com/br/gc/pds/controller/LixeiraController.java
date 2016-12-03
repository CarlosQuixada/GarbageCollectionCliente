package com.br.gc.pds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.br.gc.pds.model.Lixeiras.ListaLixeira;
import com.br.gc.pds.service.ApiService;

@Controller
public class LixeiraController {
	
	@Autowired
	private ApiService apiService;
	
	@RequestMapping("/listarLixeiras")
	public String listarLixeiras(Model model){
		ListaLixeira lixeiras = apiService.listarLixeiras();
		model.addAttribute("lixeiras",lixeiras);
		return "lixeira/listarLixeiras";
	}
	
	@RequestMapping("/teste")
	public String teste(){
		apiService.tracarRota();
		
		return"";
	}
}

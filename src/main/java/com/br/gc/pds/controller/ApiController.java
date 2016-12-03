package com.br.gc.pds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.br.gc.pds.service.ApiService;

@Controller
public class ApiController {
	
	@Autowired
	private ApiService apiService;
	
	
}

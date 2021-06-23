package com.Atividade2.Atividade2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/atividade2")
public class Atividade2Controller {
	
	@GetMapping("/Mensagem1")
	public String Mensagem() {
		return "Objetivos para essa semana:\n1-Estudar bastante esses conceitos novos para um melhor entendimento.\n"
				+ "2-Ficar sempre atento as detales";
	}
}

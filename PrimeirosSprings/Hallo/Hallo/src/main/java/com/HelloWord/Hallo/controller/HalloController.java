package com.HelloWord.Hallo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Haloo")

public class HalloController {
	
	@GetMapping
	public String mensagem() {
		return ("Habilidades e mentalidades: \n1-Conserteza persistencia porque esse conteudo novo é muito dificil"
				+ "\n2-Tenho que estudar muito ele.");
	}
}

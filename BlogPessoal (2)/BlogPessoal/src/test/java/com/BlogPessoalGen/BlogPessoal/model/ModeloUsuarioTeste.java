package com.BlogPessoalGen.BlogPessoal.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ModeloUsuarioTeste {
	
	public UsuarioModel usuario;
	
	@Autowired
	private final Validator validator = Validation .buildDefaultValidatorFactory().getValidator();
	
	@BeforeEach
	public void start() {
		usuario = new UsuarioModel("Guilherme", "Gui@gmail.com", "12345");
	}

	@Test
	public void  TesteUsuarioModel() {
		usuario.setNome("gui");
		usuario.setEmail("Gui@gmail.com");
		usuario.setSenha("12345");
		
		Set<ConstraintViolation<UsuarioModel>> violations = validator
				.validate(usuario);
				assertTrue(violations.isEmpty());		
	}

}

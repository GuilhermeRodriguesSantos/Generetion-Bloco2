package com.BlogPessoalGen.BlogPessoal.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.BlogPessoalGen.BlogPessoal.model.UsuarioModel;
import com.BlogPessoalGen.BlogPessoal.repository.UsuarioRepository;

@Service
public class UserDatailIServiceImplements implements UserDetailsService{
	
	private @Autowired UsuarioRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<UsuarioModel> usuario = repository.findByEmail(username);
		
		if(usuario.isPresent()) {
			return new UserDatailsImplements(usuario.get());
		}else {
			throw new UsernameNotFoundException(username + "Não Existe");
		}
	}

}

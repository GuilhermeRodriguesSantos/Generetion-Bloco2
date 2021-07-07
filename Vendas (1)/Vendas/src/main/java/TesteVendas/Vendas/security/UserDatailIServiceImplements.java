package TesteVendas.Vendas.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import TesteVendas.Vendas.model.Usuario;
import TesteVendas.Vendas.repository.UsuarioRepository;

@Service
public class UserDatailIServiceImplements implements UserDetailsService{
	
	private @Autowired UsuarioRepository repositoryUsuario;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<Usuario> usuarioExistente = repositoryUsuario.findByEmail(username);
		
		if(usuarioExistente.isPresent()) {
			return new UserDatailImplements(usuarioExistente.get());
		}else {
			throw new UsernameNotFoundException(username + "Não existe");
		}
	}

}

package TesteVendas.Vendas.services;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import TesteVendas.Vendas.dto.UsuarioDTO;
import TesteVendas.Vendas.dto.UsuarioLoginDTO;
import TesteVendas.Vendas.model.Usuario;
import TesteVendas.Vendas.repository.UsuarioRepository;

@Service
public class UsuarioServices {

	private @Autowired UsuarioRepository repositoryUsuario;

	/**
	 * Fazendo a regra de negocio que não deixa cadastra um usuario com um email
	 * existente
	 * 
	 * @param novoUuario
	 * @return um optional vazio ou um usuarioCriado
	 * @since 1.0
	 * @author Guilherme Rodrigues
	 */
	public Optional<Object> CadastrarUsuario(Usuario novoUuario) {
		return repositoryUsuario.findByEmail(novoUuario.getEmail()).map(UsuarioExistente -> {
			return Optional.empty();
		}).orElseGet(() -> {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String senhaCriptografada = encoder.encode(novoUuario.getSenha());
			novoUuario.setSenha(senhaCriptografada);
			return Optional.ofNullable(repositoryUsuario.save(novoUuario));
		});
	}

	/**
	 * Fazendo a regra de negocio que pelo usuario DtO consegue trocar e alterar o
	 * campo para depois salvalo
	 * 
	 * @param @idUsuario, usuarioDto
	 * @return um optional vazio ou um UsuarioCriado
	 * @since 1.0
	 * @author Guilherme Rodrigues
	 */

	public Optional<Usuario> AlterarUsuario(long idUsuario, UsuarioDTO novoUsuario) {
		return repositoryUsuario.findById(idUsuario).map(UsuarioAlterado -> {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String senhaCriptografada = encoder.encode(novoUsuario.getSenha());
			UsuarioAlterado.setNome(novoUsuario.getNome());
			UsuarioAlterado.setSenha(senhaCriptografada);
			return Optional.ofNullable(repositoryUsuario.save(UsuarioAlterado));
		}).orElseGet(() -> {
			return Optional.empty();
		});
	}

	public Optional<?> Credenciais(UsuarioLoginDTO dadosLogin) {
		return repositoryUsuario.findByEmail(dadosLogin.getEmail()).map(UsuarioExistente -> {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

			if (encoder.matches(dadosLogin.getSenha(), UsuarioExistente.getSenha())) {
				String basic = dadosLogin.getEmail() + ":" + dadosLogin.getSenha();
				byte[] autorizacao = Base64.encodeBase64(basic.getBytes(Charset.forName("US-ASCII")));
				String autorizacaoHeader = "Basic " + new String(autorizacao);

				dadosLogin.setToken(autorizacaoHeader);
				dadosLogin.setId(UsuarioExistente.getIdUsuario());
				dadosLogin.setNome(UsuarioExistente.getNome());
				dadosLogin.setSenha(UsuarioExistente.getSenha());

				return Optional.ofNullable(dadosLogin);
			} else {
				return Optional.empty();
			}

		}).orElseGet(() -> {
			return Optional.empty();
		});
	}

}

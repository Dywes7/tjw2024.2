package br.edu.br.meuprimeirospringboot.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.edu.br.meuprimeirospringboot.entity.Role;
import br.edu.br.meuprimeirospringboot.entity.Usuario;
import br.edu.br.meuprimeirospringboot.repository.UsuarioRepository;
import br.edu.br.meuprimeirospringboot.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService{
	
	@Autowired
	private final UsuarioRepository usuarioRepository;
	
	// private final PasswordEncoder passwordEncoder;

	public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
	    this.usuarioRepository = usuarioRepository;
	}

	//@Override
	/*public Usuario findByUsername(String username) {
		return usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + username));
    }*/
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
    }
	
	@Override
    public void save(Usuario usuario) {
        usuarioRepository.save(usuario);  // Salva o usuário no banco de dados
    }

	/*@Override
	public void criarUsuario(String username, String password, Role role) {
		
		if (usuarioRepository.findByUsername(username).isEmpty()) {
			Usuario usuario = new Usuario();
			
			String senhaCriptografada = passwordEncoder.encode(password);
			usuario.setPassword(senhaCriptografada);
			
			usuario.setRole(role);
			
			usuarioRepository.save(usuario);
			System.out.println("Usuário " + username + " com a role " + role + " criado com sucesso.");
			
		} else {
			System.out.println("Usuário " + username + " já existe.");
		}
		
	}*/

	@Override
	public Usuario findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void criarUsuario(String username, String password, Role role) {
		
		Optional<Usuario> usuarioExistente = usuarioRepository.findByUsername(username);
		
		if (usuarioExistente.isEmpty()) {
			PasswordEncoder encoder = new BCryptPasswordEncoder();
			String senhaCriptografada = encoder.encode(password);
			
			Usuario usuario = new Usuario();
			usuario.setUsername(username);
	        usuario.setPassword(senhaCriptografada);
	        usuario.setRole(role);
	        
	        usuarioRepository.save(usuario);
		}
	}
}

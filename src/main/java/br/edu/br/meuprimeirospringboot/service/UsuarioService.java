package br.edu.br.meuprimeirospringboot.service;

import br.edu.br.meuprimeirospringboot.entity.Role;
import br.edu.br.meuprimeirospringboot.entity.Usuario;

public interface UsuarioService {
	Usuario findByUsername(String username);
	
	void save(Usuario usuario);
	
	public void criarUsuario(String username, String password, Role role);

}

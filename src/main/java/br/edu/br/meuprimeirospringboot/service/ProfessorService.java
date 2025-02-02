package br.edu.br.meuprimeirospringboot.service;

import java.util.List;

import br.edu.br.meuprimeirospringboot.entity.Professor;

public interface ProfessorService {
	
	List<Professor> buscarTodos();
	
	Professor buscarPorId(Long id);
	
	void excluirPorId(Long id);
	
	Professor cadastrar(Professor a);
	
	Professor editar(Professor a);
	
	void salvarSeNaoExistir(String n);

}

package br.edu.br.meuprimeirospringboot.service;

import java.util.List;

import br.edu.br.meuprimeirospringboot.entity.Turma;

public interface TurmaService {
	
	List<Turma> buscarTodos();
	
	Turma buscarPorId(Long id);
	
	void excluirPorId(Long id);
	
	Turma cadastrar(Turma d);
	
	Turma editar(Turma d);

}

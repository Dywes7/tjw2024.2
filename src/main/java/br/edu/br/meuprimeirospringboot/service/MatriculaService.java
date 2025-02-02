package br.edu.br.meuprimeirospringboot.service;

import java.util.List;

import br.edu.br.meuprimeirospringboot.entity.Matricula;

public interface MatriculaService {
	
	List<Matricula> buscarTodos();
	
	Matricula buscarPorId(Long id);
	
	void excluirPorId(Long id);
	
	Matricula cadastrar(Matricula a);
	
	Matricula editar(Matricula a);

}

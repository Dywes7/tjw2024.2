package br.edu.br.meuprimeirospringboot.service;

import java.util.List;

import br.edu.br.meuprimeirospringboot.entity.Semestre;

public interface SemestreService {
	
	List<Semestre> buscarTodos();
	
	Semestre buscarPorId(Long id);
	
	void excluirPorId(Long id);
	
	Semestre cadastrar(Semestre s);
	
	Semestre editar(Semestre s);

}

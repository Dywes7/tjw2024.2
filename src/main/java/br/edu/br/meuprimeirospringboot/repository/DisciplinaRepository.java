package br.edu.br.meuprimeirospringboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.br.meuprimeirospringboot.entity.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {

	
	@Query("select d from Disciplina d")
	List<Disciplina> findAllDisciplinas();
	
	boolean existsByNome(String nome);
}

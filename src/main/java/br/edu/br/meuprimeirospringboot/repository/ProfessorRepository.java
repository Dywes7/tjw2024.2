package br.edu.br.meuprimeirospringboot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.br.meuprimeirospringboot.entity.Professor;

public interface ProfessorRepository extends JpaRepository<Professor,Long> {
	
	@Query("select p from Professor p")
	List<Professor> findAllProfessores();
	
	Optional<Professor> findByNome(String nome);
}

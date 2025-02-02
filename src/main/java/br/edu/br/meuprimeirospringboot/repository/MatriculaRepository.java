package br.edu.br.meuprimeirospringboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import br.edu.br.meuprimeirospringboot.entity.Matricula;

public interface MatriculaRepository extends JpaRepository<Matricula, Long>{
	
	@Query("select m from Matricula m")
	List<Matricula> findAllMatriculas();
	
	@Transactional
	@Modifying
	@Query("DELETE FROM Matricula m WHERE m.id = :id")
	void deleteMatriculaById(@Param("id") Long id);
	
	boolean existsByAlunoIdAndTurmaId(Long alunoId, Long turmaId);
}

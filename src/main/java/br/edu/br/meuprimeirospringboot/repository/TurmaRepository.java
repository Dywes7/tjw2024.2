package br.edu.br.meuprimeirospringboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import br.edu.br.meuprimeirospringboot.entity.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Long>{
	
	@Query("select t from Turma t")
	List<Turma> findAllTurmas();
	
	
	@Transactional
	@Modifying
	@Query("DELETE FROM Turma t WHERE t.id = :id")
	void deleteTurmaById(@Param("id") Long id);
	
	
	boolean existsByProfessorIdAndHorario(Long professorId, Long horario);
	
}

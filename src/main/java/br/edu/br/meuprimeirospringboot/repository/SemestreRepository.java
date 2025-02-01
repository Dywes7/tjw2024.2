package br.edu.br.meuprimeirospringboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.br.meuprimeirospringboot.entity.Semestre;

public interface SemestreRepository extends JpaRepository<Semestre,Long> {
	
	@Query("select s from Semestre s")
	List<Semestre> findAllSemestres();
}

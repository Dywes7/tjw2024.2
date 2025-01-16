package br.edu.br.meuprimeirospringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.br.meuprimeirospringboot.entity.Professor;

public interface ProfessorRepository extends JpaRepository<Professor,Long> {

}

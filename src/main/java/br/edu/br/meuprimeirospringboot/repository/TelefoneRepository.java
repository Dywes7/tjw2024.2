package br.edu.br.meuprimeirospringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.br.meuprimeirospringboot.entity.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone,Long> {

}

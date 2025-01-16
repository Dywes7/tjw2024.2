package br.edu.br.meuprimeirospringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import br.edu.br.meuprimeirospringboot.entity.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco,Long> {

}

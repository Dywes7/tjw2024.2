package br.edu.br.meuprimeirospringboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.br.meuprimeirospringboot.entity.Aluno;
import br.edu.br.meuprimeirospringboot.serviceImpl.AlunoServiceImpl;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
	@Autowired
	private AlunoServiceImpl aluno;
	
	@GetMapping("/buscar")
	List<Aluno> list(){
		return aluno.buscarTodos();
	}
}

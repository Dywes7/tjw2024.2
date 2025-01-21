package br.edu.br.meuprimeirospringboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.br.meuprimeirospringboot.entity.Aluno;
import br.edu.br.meuprimeirospringboot.serviceImpl.AlunoServiceImpl;

@Controller
@RequestMapping("/alunos")
public class AlunoController {
	@Autowired
	private AlunoServiceImpl aluno;
	
	@GetMapping("/listar")
	String list(){
		return "/aluno/lista";
	}
	
	@GetMapping("/excluir/{id}") 
	void excluir(@PathVariable("id") Long id) {
		aluno.excluirPorId(id);
	}
	
	
	
	@GetMapping("/cadastrar")
	String cadastrarAluno(Aluno a) {
		return "/aluno/cadastro";
		
	}

	
	
	
}

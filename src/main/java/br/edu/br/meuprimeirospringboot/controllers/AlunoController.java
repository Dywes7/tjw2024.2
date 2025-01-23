package br.edu.br.meuprimeirospringboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.br.meuprimeirospringboot.entity.Aluno;
import br.edu.br.meuprimeirospringboot.serviceImpl.AlunoServiceImpl;

@Controller
@RequestMapping("/alunos")
public class AlunoController {
	@Autowired
	private AlunoServiceImpl aluno;
	
	@GetMapping("/listar")
	String ListarAlunos(ModelMap model){
		model.addAttribute("alunos", aluno.buscarTodos());
		return "/aluno/lista";
	}	
	
	@GetMapping("/cadastrar")
	String CadastrarAlunos(ModelMap model){
		model.addAttribute("aluno",new Aluno());
		return "/aluno/cadastro";
	}
	
	@PostMapping("/salvar")
	String Salvar(Aluno a) {
		aluno.cadastrar(a);
		return "redirect:/alunos/listar";
	}
	
	@GetMapping("/excluir/{id}")
	String excluir(@PathVariable("id") Long id) {
		aluno.excluirPorId(id);
		return "redirect:/alunos/listar";	
	}
	
	
	@GetMapping("/editar/{id}")
	String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("aluno",aluno.buscarPorId(id));
		return "/aluno/cadastro";
	}
	
	@PostMapping("/editar")
	String editar(Aluno a) {
		aluno.editar(a);
		return "redirect:/alunos/listar";	
	}
}

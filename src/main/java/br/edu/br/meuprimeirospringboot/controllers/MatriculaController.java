package br.edu.br.meuprimeirospringboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.br.meuprimeirospringboot.entity.Matricula;
import br.edu.br.meuprimeirospringboot.serviceImpl.AlunoServiceImpl;
import br.edu.br.meuprimeirospringboot.serviceImpl.MatriculaServiceImpl;
import br.edu.br.meuprimeirospringboot.serviceImpl.TurmaServiceImpl;

@Controller
@RequestMapping("/matriculas")
public class MatriculaController {
	
	@Autowired
	private MatriculaServiceImpl matricula;
	@Autowired
	private AlunoServiceImpl aluno;
	@Autowired
	private TurmaServiceImpl turma;
	
	@GetMapping("/listar")
	String ListarMatriculas(ModelMap model) {
		model.addAttribute("matriculas", matricula.buscarTodos());
		return "/matricula/lista";
	}
	
	@GetMapping("/cadastrar")
	String CadastrarMatricula(ModelMap model) {
		model.addAttribute("matricula", new Matricula());
		model.addAttribute("alunos", aluno.buscarTodos());
		model.addAttribute("turmas", turma.buscarTodos());
		return "/matricula/cadastro";
	}
	
	@PostMapping("/salvar")
	String Salvar(Matricula s) {
		matricula.cadastrar(s);
		return "redirect:/matriculas/listar";
	}
	
	@GetMapping("/excluir/{id}")
	String Excluir(@PathVariable("id") Long id) {
		matricula.excluirPorId(id);
		return "redirect:/matriculas/listar";
	}
	
	
	@GetMapping("/editar/{id}")
	String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("matricula", matricula.buscarPorId(id));
		model.addAttribute("alunos", aluno.buscarTodos());
		model.addAttribute("turmas", turma.buscarTodos());
		return "/matricula/cadastro";
	}
	
	@PostMapping("/editar")
	String Editar(Matricula s) {
		matricula.editar(s);
		return "redirect:/matriculas/listar";
	}
}

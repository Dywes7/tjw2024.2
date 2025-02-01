package br.edu.br.meuprimeirospringboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.br.meuprimeirospringboot.entity.Disciplina;
import br.edu.br.meuprimeirospringboot.serviceImpl.DisciplinaServiceImpl;

@Controller
@RequestMapping("/disciplinas")
public class DisciplinaController {
	
	@Autowired
	private DisciplinaServiceImpl disciplina;
	
	@GetMapping("/listar")
	String ListarDisciplinas(ModelMap model) {
		/* o método está adicionando um atributo chamado "disciplinas" ao objeto model.
		   ModelMap é usado para passar dados do controlador para a view do Thymeleaf. */
		model.addAttribute("disciplinas", disciplina.buscarTodos());
		return "/disciplina/lista";
	}
	
	@GetMapping("/cadastrar")
	String CadastrarDisciplinas(ModelMap model) {
		model.addAttribute("disciplina", new Disciplina());
		return "/disciplina/cadastro";
	}
	
	@PostMapping("/salvar")
	String Salvar(Disciplina d) {
		disciplina.cadastrar(d);
		return "redirect:/disciplinas/listar";
	}
	
	@GetMapping("/excluir/{id}")
	String Excluir(@PathVariable("id") Long id) {
		disciplina.excluirPorId(id);
		return "redirect:/disciplinas/listar";
	}
	
	
	@GetMapping("/editar/{id}")
	String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("disciplina", disciplina.buscarPorId(id));
		return "/disciplina/cadastro";
	}
	
	@PostMapping("/editar")
	String Editar(Disciplina d) {
		disciplina.editar(d);
		return "redirect:/disciplinas/listar";
	}

}

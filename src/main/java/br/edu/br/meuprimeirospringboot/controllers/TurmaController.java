package br.edu.br.meuprimeirospringboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import br.edu.br.meuprimeirospringboot.entity.Turma;
import br.edu.br.meuprimeirospringboot.serviceImpl.DisciplinaServiceImpl;
import br.edu.br.meuprimeirospringboot.serviceImpl.SemestreServiceImpl;
import br.edu.br.meuprimeirospringboot.serviceImpl.TurmaServiceImpl;

@Controller
@RequestMapping("/turmas")
public class TurmaController {
	
	@Autowired
	private TurmaServiceImpl turma;
	@Autowired
	private SemestreServiceImpl semestre;
	@Autowired
	private DisciplinaServiceImpl disciplina;
	
	@GetMapping("/listar")
	String ListarTurmas(ModelMap model) {
		model.addAttribute("turmas", turma.buscarTodos());
		return "/turma/lista";
	}
	
	@GetMapping("/cadastrar")
	String CadastrarTurmas(ModelMap model) {
		model.addAttribute("turma", new Turma());
		model.addAttribute("semestres", semestre.buscarTodos());
		model.addAttribute("disciplinas", disciplina.buscarTodos());
		return "/turma/cadastro";
	}
	
	@PostMapping("/salvar")
	String Salvar(Turma t) {
		turma.cadastrar(t);
		return "redirect:/turmas/listar";
	}
	
	@GetMapping("/excluir/{id}")
	String Excluir(@PathVariable("id") Long id) {
		turma.excluirPorId(id);
		return "redirect:/turmas/listar";
	}
	
	
	@GetMapping("/editar/{id}")
	String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("turma", turma.buscarPorId(id));
		model.addAttribute("semestres", semestre.buscarTodos());
		model.addAttribute("disciplinas", disciplina.buscarTodos());
		return "/turma/cadastro";
	}
	
	@PostMapping("/editar")
	String Editar(Turma d) {
		turma.editar(d);
		return "redirect:/turmas/listar";
	}

}

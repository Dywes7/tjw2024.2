package br.edu.br.meuprimeirospringboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.br.meuprimeirospringboot.entity.Semestre;
import br.edu.br.meuprimeirospringboot.serviceImpl.SemestreServiceImpl;

@Controller
@RequestMapping("/semestres")
public class SemestreController {
	
	@Autowired
	private SemestreServiceImpl semestre;
	
	@GetMapping("/listar")
	String ListarSemestres(ModelMap model) {
		model.addAttribute("semestres", semestre.buscarTodos());
		return "/semestre/lista";
	}
	
	@GetMapping("/cadastrar")
	String CadastrarSemestre(ModelMap model) {
		model.addAttribute("semestre", new Semestre());
		return "/semestre/cadastro";
	}
	
	@PostMapping("/salvar")
	String Salvar(Semestre s, RedirectAttributes redirectAttributes) {
		try {
			semestre.cadastrar(s);
			redirectAttributes.addFlashAttribute("sucesso", "Semestre cadastrado com sucesso!");
			return "redirect:/semestres/listar";
		} catch (RuntimeException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
			return "redirect:/semestres/cadastrar";
		}
		
		
	}
	
	@GetMapping("/excluir/{id}")
	String Excluir(@PathVariable("id") Long id) {
		semestre.excluirPorId(id);
		return "redirect:/semestres/listar";
	}
	
	
	@GetMapping("/editar/{id}")
	String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("semestre", semestre.buscarPorId(id));
		return "/semestre/cadastro";
	}
	
	@PostMapping("/editar")
	String Editar(Semestre s) {
		semestre.editar(s);
		return "redirect:/semestres/listar";
	}
}

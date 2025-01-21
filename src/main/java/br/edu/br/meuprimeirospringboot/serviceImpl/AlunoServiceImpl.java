package br.edu.br.meuprimeirospringboot.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.br.meuprimeirospringboot.entity.Aluno;
import br.edu.br.meuprimeirospringboot.entity.Telefone;
import br.edu.br.meuprimeirospringboot.repository.AlunoRepository;
import br.edu.br.meuprimeirospringboot.service.AlunoService;


@Service
public class AlunoServiceImpl  implements AlunoService{
	@Autowired
	private AlunoRepository aluno;
	
	@Override
	public List<Aluno> buscarTodos() {
		return aluno.findAllAlunos();
	}

	@Override
	public Aluno buscarPorId(Long id) {
		return aluno.findById(id).orElseThrow(() -> new IllegalArgumentException("Aluno " + id + " não encontrado"));
	}

	@Override
	public void excluirPorId(Long id) {
		aluno.deleteById(id);
	}

	@Override
	public Aluno cadastrar(Aluno a) {
		return aluno.save(a);
	}
	
	
}

package br.edu.br.meuprimeirospringboot.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.br.meuprimeirospringboot.entity.Aluno;
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
	
	private boolean isCpfValido(String cpf) {
		return cpf != null && cpf.length() == 14;
	}

	@Override
	@Transactional
	public Aluno cadastrar(Aluno a) {
		
		if (!isCpfValido(a.getCpf())) {
			throw new RuntimeException("CPF deve conter 11 caracteres.");
		}
		
		if (aluno.existsByCpf(a.getCpf())) {
	        throw new RuntimeException("CPF já cadastrado!");
	    }
		 
		return aluno.save(a);
	}

	@Override
	public Aluno editar(Aluno a) {
		Aluno al = this.buscarPorId(a.getId());
		al.setNome(a.getNome());
		al.setEmail(a.getEmail());
		al.setMatricula(a.getMatricula());
		al.setCpf(a.getCpf());
		al.setDtNascimento(a.getDtNascimento());
		return aluno.save(al);
	}

}

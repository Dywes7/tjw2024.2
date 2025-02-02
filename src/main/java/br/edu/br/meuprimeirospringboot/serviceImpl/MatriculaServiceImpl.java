package br.edu.br.meuprimeirospringboot.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.br.meuprimeirospringboot.entity.Matricula;
import br.edu.br.meuprimeirospringboot.repository.MatriculaRepository;
import br.edu.br.meuprimeirospringboot.service.MatriculaService;

@Service
public class MatriculaServiceImpl implements MatriculaService {
	
	@Autowired
	private MatriculaRepository matricula;

	@Override
	public List<Matricula> buscarTodos() {
		return matricula.findAllMatriculas();
	}

	@Override
	public Matricula buscarPorId(Long id) {
		return matricula.findById(id).orElseThrow(() -> new IllegalArgumentException("Matricula " + id + " não encontrada"));
	}

	@Override
	public void excluirPorId(Long id) {
		matricula.deleteMatriculaById(id);
		
	}

	@Override
	@Transactional
	public Matricula cadastrar(Matricula m) {
		if (matricula.existsByAlunoIdAndTurmaId(m.getAluno().getId(), m.getTurma().getId())) {
			throw new RuntimeException("O aluno já está matriculado nesta turma!");
		}
		
		return matricula.save(m);
	}

	@Override
	public Matricula editar(Matricula s) {
		Matricula m1 = this.buscarPorId(s.getId());
		
		m1.setDataMatricula(s.getDataMatricula());
		m1.setAluno(s.getAluno());
		m1.setTurma(s.getTurma());
		
		return matricula.save(m1);
	}

}

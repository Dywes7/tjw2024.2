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
	public Matricula editar(Matricula m) {
		Matricula m1 = this.buscarPorId(m.getId());
		
		if (!(m1.getAluno().getId().equals(m.getAluno().getId()) && m1.getTurma().getId().equals(m.getTurma().getId()))) {
		    if (matricula.existsByAlunoIdAndTurmaId(m.getAluno().getId(), m.getTurma().getId())) {
		        throw new RuntimeException("O aluno já está matriculado nesta turma!");
		    }
		}
		
		
		m1.setDataMatricula(m.getDataMatricula());
		m1.setAluno(m.getAluno());
		m1.setTurma(m.getTurma());
		
		return matricula.save(m1);
	}

}

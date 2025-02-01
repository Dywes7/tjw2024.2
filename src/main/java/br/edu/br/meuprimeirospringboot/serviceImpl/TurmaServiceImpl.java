package br.edu.br.meuprimeirospringboot.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.br.meuprimeirospringboot.entity.Disciplina;
import br.edu.br.meuprimeirospringboot.entity.Turma;
import br.edu.br.meuprimeirospringboot.repository.TurmaRepository;
import br.edu.br.meuprimeirospringboot.service.TurmaService;

@Service
public class TurmaServiceImpl implements TurmaService {
	
	@Autowired
	private TurmaRepository turma;

	@Override
	public List<Turma> buscarTodos() {
		return turma.findAllTurmas();
	}

	@Override
	public Turma buscarPorId(Long id) {
		return turma.findById(id).orElseThrow(() -> new IllegalArgumentException("Turma " + id + " não encontrada"));
	}

	@Override
	public void excluirPorId(Long id) {
	    Turma turmabusc = buscarPorId(id); // Busca a turma pelo ID
	    System.out.println("id: " + id);
	    // Remove as associações com as disciplinas
	    turmabusc.getDisciplinas().clear();
	    turma.save(turmabusc);

	    // turma.delete(turmabusc);;
	    turma.deleteTurmaById(id);
	}

	@Override
	public Turma cadastrar(Turma d) {
		return turma.save(d);
	}

	@Override
	public Turma editar(Turma t) {
		Turma t1 = this.buscarPorId(t.getId());
		
		t1.setDisciplinas(t.getDisciplinas());
		t1.setSemestre(t.getSemestre());
		
		return turma.save(t1);
	}

}

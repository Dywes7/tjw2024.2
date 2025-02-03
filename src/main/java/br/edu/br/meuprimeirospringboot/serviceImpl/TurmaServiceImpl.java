package br.edu.br.meuprimeirospringboot.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
		/*
	    Turma turmabusc = buscarPorId(id); // Busca a turma pelo ID
	    System.out.println("id: " + id);
	    // Remove as associações com as disciplinas
	    turmabusc.getDisciplinas().clear();
	    turma.save(turmabusc);

	    // turma.delete(turmabusc);;
	    turma.deleteTurmaById(id);
	    */
		// turma.deleteById(id);
		turma.deleteTurmaById(id);
	}

	@Override
	public Turma cadastrar(Turma t) {
		
		if (turma.existsByProfessorIdAndHorario(t.getProfessor().getId(), t.getHorario())) {
			throw new RuntimeException("O professor já leciona neste horário!");
		}
		
		return turma.save(t);
	}

	@Override
	public Turma editar(Turma t) {
		Turma t1 = this.buscarPorId(t.getId());
		
		if (!(t1.getProfessor().getId().equals(t.getProfessor().getId()) && t1.getHorario().equals(t.getHorario()))) {
			if (turma.existsByProfessorIdAndHorario(t.getProfessor().getId(), t.getHorario())) {
				throw new RuntimeException("O professor já leciona neste horário!");
			}
		}
		
		
		t1.setDisciplina(t.getDisciplina());
		t1.setSemestre(t.getSemestre());
		t1.setHorario(t.getHorario());
		t1.setProfessor(t.getProfessor());
		
		return turma.save(t1);
	}

}

package br.edu.br.meuprimeirospringboot.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.br.meuprimeirospringboot.entity.Disciplina;
import br.edu.br.meuprimeirospringboot.repository.DisciplinaRepository;
import br.edu.br.meuprimeirospringboot.service.DisciplinaService;

@Service
public class DisciplinaServiceImpl implements DisciplinaService{
	
	@Autowired
	private DisciplinaRepository disciplina;

	@Override
	public List<Disciplina> buscarTodos() {
		return disciplina.findAllDisciplinas();
	}

	@Override
	public Disciplina buscarPorId(Long id) {
		return disciplina.findById(id).orElseThrow(() -> new IllegalArgumentException("Disciplina " + id + " não encontrada"));
	}

	@Override
	public void excluirPorId(Long id) {
		disciplina.deleteById(id);
		
	}

	@Override
	@Transactional
	public Disciplina cadastrar(Disciplina d) {
		if (disciplina.existsByNome(d.getNome())) {
			throw new RuntimeException("Disciplina já existe!");
		}
		return disciplina.save(d);
	}

	@Override
	public Disciplina editar(Disciplina d) {
		Disciplina d1 = this.buscarPorId(d.getId());
		
		d1.setNome(d.getNome());
		d1.setEmenta(d.getEmenta());
		d1.setCargaHorariaHoras(d.getCargaHorariaHoras());
		
		return disciplina.save(d1);
	}

	
}

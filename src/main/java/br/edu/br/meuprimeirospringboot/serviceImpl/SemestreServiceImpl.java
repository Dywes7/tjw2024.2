package br.edu.br.meuprimeirospringboot.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.br.meuprimeirospringboot.entity.Semestre;
import br.edu.br.meuprimeirospringboot.repository.SemestreRepository;
import br.edu.br.meuprimeirospringboot.service.SemestreService;

@Service
public class SemestreServiceImpl implements SemestreService {
	
	@Autowired
	private SemestreRepository semestre;

	@Override
	public List<Semestre> buscarTodos() {
		return semestre.findAllSemestres();
	}

	@Override
	public Semestre buscarPorId(Long id) {
		return semestre.findById(id).orElseThrow(() -> new IllegalArgumentException("Semestre " + id + " não encontrado"));
	}

	@Override
	public void excluirPorId(Long id) {
		semestre.deleteById(id);
		
	}
	
	public boolean isAnoValido(int ano) {
		return ano >= 2000 && ano <= 2050;
	}
	
	@Override
	@Transactional
	public Semestre cadastrar(Semestre s) {
		
		if (!isAnoValido(s.getAno())) {
			throw new RuntimeException("O ano deve estar entre 2000 e 2050.");
		}
		
		if (semestre.existsByAnoAndEtapa(s.getAno(), s.getEtapa())) {
			throw new RuntimeException("Semestre " + s.getCode() + " já existe!");
		}
		
		return semestre.save(s);
	}

	@Override
	public Semestre editar(Semestre s) {
		Semestre s1 = this.buscarPorId(s.getId());
		
		if (!isAnoValido(s.getAno())) {
			throw new RuntimeException("O ano deve estar entre 2000 e 2050.");
		}
		
		if (!s.getCode().equals(s1.getCode()) && semestre.existsByAnoAndEtapa(s.getAno(), s.getEtapa())) {
			throw new RuntimeException("Semestre " + s.getCode() + " já existe!");
		}
		
		s1.setAno(s.getAno());
		s1.setEtapa(s.getEtapa());
		s1.setDataInicio(s.getDataInicio());
		s1.setDataFim(s.getDataFim());
		
		return semestre.save(s1);
	}

}

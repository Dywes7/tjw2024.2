package br.edu.br.meuprimeirospringboot.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.br.meuprimeirospringboot.entity.Professor;
import br.edu.br.meuprimeirospringboot.repository.ProfessorRepository;
import br.edu.br.meuprimeirospringboot.service.ProfessorService;

@Service
public class ProfessorServiceImpl implements ProfessorService{
	
	@Autowired
	private ProfessorRepository professor;

	@Override
	public List<Professor> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Professor buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluirPorId(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Professor cadastrar(Professor a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Professor editar(Professor a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void salvarSeNaoExistir(String nome) {
		Optional<Professor> professorExistente = professor.findByNome(nome);
        if (professorExistente.isEmpty()) {
            Professor p = new Professor();
            p.setNome(nome);
            professor.save(p);
        }
		
	}

}

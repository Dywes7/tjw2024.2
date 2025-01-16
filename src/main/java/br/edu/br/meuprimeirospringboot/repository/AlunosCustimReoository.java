package br.edu.br.meuprimeirospringboot.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import br.edu.br.meuprimeirospringboot.entity.Aluno;

@Repository
public class AlunosCustimReoository {
	
	private EntityManager em;

	public AlunosCustimReoository(EntityManager em) {
		super();
		this.em = em;
	}
	
	public List<Aluno> findAllCustom(Long id, String nome, String email){
		String query = "select a from Aluno a ";
		String condicao = "where ";
		
		if (id != null) {
			query += condicao + "a.id = :id";
			condicao = " and ";
		}
		
		if (nome != null) {
			query += condicao + "a.nome = :nome";
			condicao = " and ";
		}
		
		if (email != null) {
			query += condicao + "a.email = :email";
		}
		
		var q = em.createQuery(query,Aluno.class);
		
		if (id != null) {
			q.setParameter("id",id);
		}
		
		if (nome != null) {
			q.setParameter("nome", nome);
		}
		
		if (email != null) {
			q.setParameter("email", email);
		}
		
		
		return q.getResultList();
	}
	
	

}

package br.edu.br.meuprimeirospringboot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Disciplina {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private int cargaHorariaHoras;
	@Column(columnDefinition = "TEXT")
	private String ementa;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCargaHorariaHoras() {
		return cargaHorariaHoras;
	}
	public void setCargaHorariaHoras(int cargaHorariaHoras) {
		this.cargaHorariaHoras = cargaHorariaHoras;
	}
	public String getEmenta() {
		return ementa;
	}
	public void setEmenta(String ementa) {
		this.ementa = ementa;
	}
	

}

package br.edu.br.meuprimeirospringboot.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Semestre {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private int ano;
	private int etapa;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataInicio;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFim; 
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "semestre", cascade = CascadeType.ALL)
	private List<Turma> turmas = new ArrayList<Turma>();
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public int getEtapa() {
		return etapa;
	}
	public void setEtapa(int etapa) {
		this.etapa = etapa;
	}
	
	public String getCode() {
		return ano + "." + etapa;
	}
	
	public LocalDate getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}
	public LocalDate getDataFim() {
		return dataFim;
	}
	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

}

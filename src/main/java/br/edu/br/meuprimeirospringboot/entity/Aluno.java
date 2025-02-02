package br.edu.br.meuprimeirospringboot.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.hibernate.annotations.processing.Pattern;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "tbl_aluno")
public class Aluno {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "nomeAluno")
	private String nome;
	private String matricula;
	private String email;
	@Column(name = "cpf", unique = true, nullable = false)
	private String cpf;
	@OneToOne(cascade = CascadeType.ALL)
	private Endereco e;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "aluno", cascade = CascadeType.ALL)
	private List<Telefone> telefones = new ArrayList<Telefone>();
	
	/*
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<Professor> professores;
	*/
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dtNascimento;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "aluno", cascade = CascadeType.ALL)
	private List<Matricula> matriculas = new ArrayList<Matricula>();

	
	@Transient
	private int idade;
	
	public Aluno() {
		this.matricula = gerarMatricula();
	}
	
	private String gerarMatricula() {
		String prefixo = "cc";
        int ano = LocalDate.now().getYear();
        int semestre = (LocalDate.now().getMonthValue() <= 6) ? 1 : 2; // Até junho = 1º semestre, depois = 2º semestre

        // Gerar um identificador aleatório (4 dígitos numéricos)
        int numeroAleatorio = new Random().nextInt(9000) + 1000; // Gera um número entre 1000 e 9999

        return String.format("%s-%d.%d-%d", prefixo, ano, semestre, numeroAleatorio);
	}
	
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
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(LocalDate dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public Endereco getE() {
		return e;
	}
	public void setE(Endereco e) {
		this.e = e;
	}
	public List<Telefone> getTelefones() {
		return telefones;
	}
	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
	public List<Matricula> getMatriculas() {
		return matriculas;
	}
	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}
	
}

package br.edu.br.meuprimeirospringboot;



import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.br.meuprimeirospringboot.entity.Aluno;
import br.edu.br.meuprimeirospringboot.repository.AlunoRepository;
import br.edu.br.meuprimeirospringboot.repository.AlunosCustimReoository;
import br.edu.br.meuprimeirospringboot.repository.ProfessorRepository;
import br.edu.br.meuprimeirospringboot.repository.TelefoneRepository;
import br.edu.br.meuprimeirospringboot.serviceImpl.AlunoServiceImpl;

@SpringBootApplication
public class MeuprimeirospringbootApplication  implements CommandLineRunner {
	@Autowired
	private AlunoServiceImpl aluno;
	
	
	public static void main(String[] args) {
		SpringApplication.run(MeuprimeirospringbootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		 * Endereco e = new Endereco(); e.setBairro("Timbó"); e.setCep("60.000-00");
		 * e.setLogradouro("Rua 1");
		 * 
		 * Aluno a = new Aluno(); a.setNome("Fulano de tal");
		 * a.setEmail("fulano@gmail.com"); a.setMatricula("cc-2024.2-00001212");
		 * a.setDtNascimento(new Date()); a.setE(e); // aluno.save(a);
		 * 
		 * Telefone t1 = new Telefone(); t1.setNumero("9999-9999"); t1.setIsWpp(false);
		 * t1.setAluno(a);
		 * 
		 * 
		 * Telefone t2 = new Telefone(); t2.setNumero("8888-8888"); t2.setIsWpp(true);
		 * t2.setAluno(a);
		 * 
		 * 
		 * 
		 * List<Telefone> telefones = a.getTelefones(); telefones.add(t1);
		 * telefones.add(t2);
		 * 
		 * a.setTelefones(telefones);
		 * 
		 * 
		 * aluno.save(a);
		 * 
		 * System.out.println("Recuperar telefones de um aluno:");
		 * 
		 * Aluno af = aluno.findById(1L).get(); List<Telefone> telefonesf =
		 * af.getTelefones(); for (Iterator iterator = telefonesf.iterator();
		 * iterator.hasNext();) { Telefone telefone = (Telefone) iterator.next();
		 * System.out.println(telefone.getNumero()); }
		 */
		
		//Professor p1 = new Professor();
		//p1.setNome("Corneli Gomes");
		//professor.save(p1);
		
		//Professor p2 = new Professor();
		//p2.setNome("Otávio Alcantara");
		//professor.save(p2);
		
		/*
		 * Aluno a = aluno.findById(1L).get();
		 * 
		 * Professor p1 = professor.findById(1L).get(); Professor p2 =
		 * professor.findById(2L).get();
		 * 
		 * List<Professor> lp = a.getProfessores(); lp.add(p1); lp.add(p2);
		 * 
		 * a.setProfessores(lp); aluno.save(a);
		 */
		
		/*
		 * List<Aluno> alunos = aluno.findAllAlunos(); for (Iterator iterator =
		 * alunos.iterator(); iterator.hasNext();) { Aluno aluno = (Aluno)
		 * iterator.next(); System.out.println(aluno.getNome()); } int numAlunos =
		 * aluno.countAllAlunos(); System.out.println("Numero de alunos cadastrados: " +
		 * numAlunos);
		 * 
		 * Optional<Aluno> a = aluno.findAlunoByEmailOptional("fulano@gmail");
		 * 
		 * 
		 * 
		 * a.ifPresentOrElse(x-> System.out.println(x.getNome()) ,()->
		 * System.err.println("Aluno não encontrado."));
		 * 
		 * 
		 */
		/*
		 * List<Aluno> a = alunoc.findAllCustom(null ,"Fulano de tal",
		 * "cfulano@gmail.com");
		 * 
		 * for (Iterator iterator = a.iterator(); iterator.hasNext();) { Aluno aluno =
		 * (Aluno) iterator.next(); System.out.println(aluno.getId() + " " +
		 * aluno.getNome() + " " + aluno.getEmail()); }
		 */
		
		//Aluno a = aluno.buscarPorId(1L);
		//System.out.println(a.getNome());
		
		
	}

}

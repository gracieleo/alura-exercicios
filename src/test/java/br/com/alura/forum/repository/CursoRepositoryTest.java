package br.com.alura.forum.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.alura.forum.modelo.Curso;



@RunWith(SpringRunner.class)
@DataJpaTest                     //para teste de Repository, simplifica a escrita de testes
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)  //caso vá usar outro BD para o Spring não substituir seu BD pelo H2 em memória
@ActiveProfiles("test")
public class CursoRepositoryTest {
	
	@Autowired
	private CursoRepository repository;
	
	@Autowired
	private TestEntityManager entityManager;
	

	@Test
	public void deveriaCarregarUmCursoAoBuscarPeloSeuNome() {
		String nomeCurso = "HTML 5";
		
		////caso use um banco vazio, deve popular antes 
		Curso html5 = new Curso();
		html5.setNome(nomeCurso);
		html5.setCategoria("Programação");
		entityManager.persist(html5);
		////
		
		Curso curso = repository.findByNome(nomeCurso);	
		//Assert.assertNotNull(curso);
		Assert.assertNotNull(curso);       
		//Assert.assertEquals(nomeCurso, curso.getNome());
		Assert.assertEquals(nomeCurso, curso.getNome());		      //verifica se o nome desse é igual ao do banco
	}
	
	
	@Test
	public void naoDeveriaCarregarUmCursoCujoNomeNaoEstejaCadastrado() {
		String nomeCurso = "JPA";
		Curso curso = repository.findByNome(nomeCurso);	
		//Assert.assertNull(curso);
		Assert.assertNull(curso);       		     
	}

}

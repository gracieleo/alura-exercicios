package br.com.alura.forum.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.forum.modelo.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

	//comunicação com o banco de dados
	
	Page<Topico> findByCursoNome(String nomeCurso, Pageable paginacao); //Na entidade Topico não tem atributo nome, mas na relação Curso curso existe um campo "nome"
	
	//List<Topico> findByCurso_Nome(String nomeCurso); //Uma forma de tirar ambiguidade caso em Topico tenha um atributo cursoNome


}

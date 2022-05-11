package br.com.alura.forum.controller;

import java.net.URI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import ch.qos.logback.core.status.Status;

@RunWith(SpringRunner.class)
//@WebMvcTest          				//para teste da camada MCV -> Controller, RestController
@SpringBootTest						//testa o controller e tudo o que ele chama
@AutoConfigureMockMvc				//faz a injeção de controlle do MockMvc
@ActiveProfiles("test")
public class AutenticacaoControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@Test   
	public void deveriaDevolverBadRequestCasoDadosdeAutenticacaoEstejamIncorretos() throws Exception {
		
		URI uri = new URI("/auth");
		String json = "{\"email\":\"invalido@email.com\",\"senha\":\"123456}\"";
		
		mockMvc
		.perform(MockMvcRequestBuilders
				.post(uri)										//tipo da requisição para um login
				.content(json)									//conteúdo do body para enviar
				.contentType(MediaType.APPLICATION_JSON))		//tipo de midia
		.andExpect(MockMvcResultMatchers
				.status()
				.is(400));		 		
	
	}
	
	
	@Test   
	public void deveriaDevolverOkCasoDadosdeAutenticacaoEstejamCorretos() throws Exception {
		
		URI uri = new URI("/auth");
		String json = "{\"email\":\"aluno@email.com\",\"senha\":\"123456}\"";
		
		mockMvc
		.perform(MockMvcRequestBuilders
				.post(uri)										
				.content(json)									
				.contentType(MediaType.APPLICATION_JSON));		 		
	
	}


}

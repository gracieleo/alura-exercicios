package br.com.alura.forum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSpringDataWebSupport    //habilita o módulo SpringDataWebSupport para receber parametros de ordenação e paginação no controller
@EnableCaching
@EnableSwagger2
public class ForumApplication  {  

//	public class ForumApplication extends SpringBootServletInitializer {   //deve extender dessa classe para gerar o .war

	public static void main(String[] args) {
		SpringApplication.run(ForumApplication.class, args);
	}
	
	
	//para gerar arquivo .war deve sobrescrever esse metodo
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//	
//		return builder.sources(ForumApplication.class);
//	}

}




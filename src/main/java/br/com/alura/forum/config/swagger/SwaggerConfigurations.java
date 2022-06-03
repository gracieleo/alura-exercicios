package br.com.alura.forum.config.swagger;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.alura.forum.modelo.Usuario;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfigurations {
	
	@Bean
	public Docket forumApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.alura.forum"))
				.paths(PathSelectors.ant("/**")) //pode ler todos os endereços da API
				.build()
				.apiInfo(apiInfo())
				.ignoredParameterTypes(Usuario.class) //ignora usuários que trabalham com URL de usuário
				.globalOperationParameters(Arrays.asList(
						new ParameterBuilder()
						.name("Authorization")
						.description("Header para Token JWT")
						.modelRef(new ModelRef("string")) //tipo do parametro
						.parameterType("header") 
						.required(false)
						.build()));
		
	}
	
	
	private ApiInfo apiInfo() {
		
		return new ApiInfoBuilder()
				.title("API Forum Alura")
				.description("API simula o forum de dúvidas da comunidade Alura. <br> Para deletar e "
						+ " atualizar é necessário que o usuário esteja cadastrado na base de dados"
						+ " e em <b>autenticacao-controller</b> deve informar seus dados para receber "
						+ " um `Bearer token` e acessar esses métodos.")
				.version("1.0.0")
				.build();
	}
}

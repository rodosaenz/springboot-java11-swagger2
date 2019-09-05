package pa.bgeneral.payroll.starter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {   
    
	  @Value("${bg.endpoint.base}")
    private String apiBaseUrl;
	
	  @Value("${bg.swagger.enabled}")
    private Boolean swaggerEnabled;
	
    private static final String HTTPURL= "https://github.com/BancoGeneral";

    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()
          .apis(RequestHandlerSelectors.any())
          .paths(PathSelectors.regex(apiBaseUrl+".*"))
          .build()
          .apiInfo(metaData())
          .enable(swaggerEnabled);                                          
    }

    private ApiInfo metaData() {
      Contact contact = new Contact("BGX - Banco General", HTTPURL, "admin@bggeneral.com");

      return new ApiInfoBuilder()
          .title("Payroll Account REST API")
          .description("API Rest de servicio Payroll Backend")
          .version("1.0.0")
          .license("Apache License Version 2.0")
          .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
          .contact(contact)
          .build();
	}
}
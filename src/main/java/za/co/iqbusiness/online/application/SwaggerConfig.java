/**
 * 10 Apr 2020
 */
package za.co.iqbusiness.online.application;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * @author luckyboyrapudi
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket profileApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("person").apiInfo(metadata()).select().paths(regex("/person.*")).build();
	}

	@SuppressWarnings("deprecation")
	private ApiInfo metadata() {
		return new ApiInfoBuilder().title("Software Developer Case Study API").description("API reference guide for developers").termsOfServiceUrl("https://www.iqbusiness.co.za/").contact("Lucky, Rapudi").version("1.0").build();	

}
}

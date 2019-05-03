package org.cnu.realcoding.riotapi.config;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

// 어노테이션기반 환경구성을 도움
// 이 어노테이션을 구현함으로써 클래스가 하나 이상의 @Bean 메소드를 제공
// 스프링 컨테이너가 Bean정의를 생성하고 런타임시 그 Bean들이 요청들을 처리할 것을 선언
@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {
    // 새로운 빈 객체를 제공
    // 각 빈간의 의존 관계는 메서드를 호출 함으로써 의존 관계를 설정 - @Bean(name="hello")
    // 어노테이션의 autowire 속성을 이용하여 연관 자동 설정 - @Bean(autowire = Autowire.BY_NAME)
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(paths())
                .build();
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/", "/swagger-ui.html");
    }

    private Predicate<String> paths() {
        return Predicates.or(
                regex("/.*"),
                regex("/health"),
                regex("/info")
        );
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("riot-api")
                .version("1.0")
                .build();
    }

}

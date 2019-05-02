package org.cnu.realcoding.riotapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

// 어노테이션기반 환경구성을 도움
// 이 어노테이션을 구현함으로써 클래스가 하나 이상의 @Bean 메소드를 제공
// 스프링 컨테이너가 Bean정의를 생성하고 런타임시 그 Bean들이 요청들을 처리할 것을 선언
@Configuration
public class HttpConfig {

    // 새로운 빈 객체를 제공
    // 각 빈간의 의존 관계는 메서드를 호출 함으로써 의존 관계를 설정 - @Bean(name="hello")
    // 어노테이션의 autowire 속성을 이용하여 연관 자동 설정 - @Bean(autowire = Autowire.BY_NAME)
    @Bean
    public RestTemplate createRestTemplate() {
        return new RestTemplate();
    }
}

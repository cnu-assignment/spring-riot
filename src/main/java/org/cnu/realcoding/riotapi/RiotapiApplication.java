// 실행될 때 세부적인 것 포함
package org.cnu.realcoding.riotapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @Configuration + @EvableAutoConfiguration + @ComponentScan 이거 세가지를 한번에 묶어놓은
@SpringBootApplication
public class RiotapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RiotapiApplication.class, args);
	}

}

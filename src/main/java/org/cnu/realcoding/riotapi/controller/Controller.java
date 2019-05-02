// 클라이언트와 request / response(로직 전까지 준비물)
package org.cnu.realcoding.riotapi.controller;

import org.cnu.realcoding.riotapi.api.RiotApi;
import org.springframework.web.bind.annotation.RequestMapping;

public class Controller {


    RiotApi api = new RiotApi();
    // @RequestMapping - 요청 URL을 어떤 메서드가 처리할지 mapping해주는 애노테이션
    // @GetMapping - @@RequestMapping(Method=RequestMethod.GET)과 같음

}

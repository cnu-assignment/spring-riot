// 클라이언트와 request / response(로직 전까지 준비물)
package org.cnu.realcoding.riotapi.controller;

import org.cnu.realcoding.riotapi.api.RiotApi;
import org.cnu.realcoding.riotapi.domain.EncryptedSummonerId;
import org.cnu.realcoding.riotapi.domain.SummonerName;
import org.cnu.realcoding.riotapi.repository.DataRepository;
import org.cnu.realcoding.riotapi.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

// @Controller 어노테이션과 @ResponseBody 어노테이션을 합쳐놓음
// Spring MVC @Controller는 일반적으로 View Page 이름을 리턴해주어 사용자에게 뷰페이지를 출력
// @RestController 에서 return 되는 값은 View Page를 통해 출력되는 것이 아니라 HTTP ResponseBody에 직접 쓰여지게 됨
// @Controller 는 View Page를 반환하지만, @RestController는 객체(VO,DTO)를 반환하기만 하면, 객체데이터는 application/json 형식의 HTTP ResponseBody에 직접 작성
@RestController
public class Controller {

    // 의존관계를 자동설정할 때 사용하며 타입을 이용하여 의존하는 객체를 삽입
    @Autowired
    private RiotApi riotApi;

    @Autowired
    private DataRepository dataRepository;

    @Autowired
    private Service service;

    @Autowired
    RestTemplate restTemplate;

    // @RequestMapping - 요청 URL을 어떤 메서드가 처리할지 mapping해주는 애노테이션
    // @GetMapping - @@RequestMapping(Method=RequestMethod.GET)과 같음
    @RequestMapping("/api")
    public EncryptedSummonerId getLeagueInfoByName(@RequestParam(value="name", defaultValue="false") String name) throws IOException {
        this.insertDataToDB(name);
//        String idOfSummoner = riotApi.getEncryptedId(name);
        return riotApi.getLeagueInformation(name);
    }

    private void insertDataToDB(String name) throws IOException {
        this.service.insertinMongoDB(name);
    }




}

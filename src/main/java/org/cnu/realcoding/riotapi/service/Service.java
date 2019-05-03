// 비즈니스 로직 처리(domain 객체 조합 후 결과만들어 반환)
package org.cnu.realcoding.riotapi.service;


import org.cnu.realcoding.riotapi.api.RiotApi;
import org.cnu.realcoding.riotapi.domain.EncryptedSummonerId;
import org.cnu.realcoding.riotapi.domain.SummonerName;
import org.cnu.realcoding.riotapi.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

@org.springframework.stereotype.Service
public class Service {
    // 의존관계를 자동설정할 때 사용하며 타입을 이용하여 의존하는 객체를 삽입
    @Autowired
    // DataRepository 클래스에서 가져옴
    private DataRepository dataRepository;

    // 의존관계를 자동설정할 때 사용하며 타입을 이용하여 의존하는 객체를 삽입
    @Autowired
    // RiotApi 클래스에서 가져옴
    private RiotApi riotApi;


    public void insertinMongoDB(String name) throws IOException {
        // idOfRiot이라는 문자열 변수 선언하고 riotApi 클래스의 getEncryptedId 메서드 실행
        // .getId()는 받은객체에서 id를 가져오는 것
        String idOfRiot = riotApi.getEncryptedId(name).getId();
        // 사용자 정의 데이터 타입으로 league 변수를 선언하고 riotApi 클래스의 getLeagueInformation 메서드를 실행
        EncryptedSummonerId league = this.riotApi.getLeagueInformation(idOfRiot);
        // DataRepository에 정의되어있는 메서드 실행
        dataRepository.getAndInsertDB(league);
    }
}

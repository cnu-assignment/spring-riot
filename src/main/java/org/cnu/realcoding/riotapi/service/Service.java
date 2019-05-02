// 비즈니스 로직 처리(domain 객체 조합 후 결과만들어 반환)
package org.cnu.realcoding.riotapi.service;


import org.cnu.realcoding.riotapi.api.RiotApi;
import org.cnu.realcoding.riotapi.domain.EncryptedSummonerId;
import org.cnu.realcoding.riotapi.domain.SummonerName;
import org.cnu.realcoding.riotapi.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class Service {

    @Autowired
    private DataRepository dataRepository;

    @Autowired
    private RiotApi riotApi;

    public void insertinMongoDB(String name) throws IOException {
        String idOfRiot = riotApi.getEncryptedId(name).getId();
        EncryptedSummonerId league = this.riotApi.getLeagueInformation(idOfRiot);
        dataRepository.getAndInsertDB(league);
    }

}

// 비즈니스 로직 처리(domain 객체 조합 후 결과만들어 반환)
package org.cnu.realcoding.riotapi.service;


import org.cnu.realcoding.riotapi.api.RiotApi;
import org.cnu.realcoding.riotapi.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;


public class Service {

    @Autowired
    private DataRepository dataRepository;

    @Autowired
    private RiotApi riotApi;




}

package org.cnu.realcoding.riotapi.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.cnu.realcoding.riotapi.domain.EncryptedSummonerId;
import org.cnu.realcoding.riotapi.domain.SummonerName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

// 비즈니스로직이 들어가는 Service 빈 등록
@Service
public class RiotApi {
    // 의존관계를 자동설정할 때 사용하며 타입을 이용하여 의존하는 객체를 삽입
    @Autowired
    private RestTemplate restTemplate;

    private String apiKey = "RGAPI-07358c6f-7e22-4150-b468-a981d93d2509";

    private String requestSummonerNameUrl = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/{summonerName}?api_key={apiKey}";
    private String requestEncryptedSummonerIdUrl="https://kr.api.riotgames.com/lol/league/v4/positions/by-summoner/{encryptedSummonerId}?api_key={apiKey}";

    public SummonerName getEncryptedId(String userName) {
        // restTemplate.exchange() : Http Header 를 수정할 수 있고 결과를 Http ResponseEntity로 반환 받는다.
        // .getBody() : body값을 넘겨받음
        // RequestEntity를 사용해서 요청 파라미터로 받을 수 있음
        return restTemplate.exchange(requestSummonerNameUrl, HttpMethod.GET, null, SummonerName.class, userName, apiKey).getBody();
    }
    // IOException은 입출력 예외
    public EncryptedSummonerId getLeagueInformation(String encryptedId) throws IOException {
        // ObjectMapper를 통해 java object를 json 문자열로 변환할 수 있다.
        ObjectMapper mapper = new ObjectMapper();
        // Http ResponseEntity로 반환 받아 String 형 변수인 jsonInString에 넣음
        String jsonInString = restTemplate.exchange(requestEncryptedSummonerIdUrl, HttpMethod.GET, null, String.class, encryptedId, apiKey).getBody();
        // String의 replace 메서드를 이용하여 '['와 ']'를 공백으로 치환
        jsonInString = jsonInString.replace("[", "");
        jsonInString = jsonInString.replace("]", "");
        // jackson 라이브러리의 mapper.readValue 매서드로 JSON 문자열을 자바 객체로 변환함
        EncryptedSummonerId encryptedSummonerId = mapper.readValue(jsonInString,EncryptedSummonerId.class);
        return encryptedSummonerId;


    }
}

package org.cnu.realcoding.riotapi.api;

import org.cnu.realcoding.riotapi.domain.EncryptedSummonerId;
import org.cnu.realcoding.riotapi.domain.SummonerName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RiotApi {
    @Autowired
    private RestTemplate restTemplate;

    private String requestSummonerNameUrl = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/{summonerName}?api_key={apiKey}";
    private String requestEncryptedSummonerIdUrl="https://kr.api.riotgames.com/lol/league/v4/positions/by-summoner/{encryptedSummonerId}?api_key={apiKey}";

    public SummonerName getEncryptedId(String userName) {
        return restTemplate.exchange(requestSummonerNameUrl, HttpMethod.GET, null, SummonerName.class, userName, "RGAPI-733e4766-5acf-4583-8c9f-9cba2ba6e9f5").getBody();
    }
    public EncryptedSummonerId getLeagueInformation(String encryptedId){
        return restTemplate.exchange(requestEncryptedSummonerIdUrl, HttpMethod.GET, null, EncryptedSummonerId.class, encryptedId, "RGAPI-733e4766-5acf-4583-8c9f-9cba2ba6e9f5").getBody();
    }
}

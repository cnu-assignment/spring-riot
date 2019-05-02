package org.cnu.realcoding.riotapi.domain;

// 어노테이션을 붙여 자동으로 생성된 접근자와 설정자 메소드를 사용할 수 있게끔 해줌
import lombok.Data;

// @Getter, @Setter, @RequiredArgsConstructor, @ToString, @EqualsAndHashCode을 한꺼번에 설정
@Data
public class SummonerName {
    private int profileIconId;
    private String name;
    private String puuid;
    private long summonerLevel;
    private long revisionDate;
    private String id;
    private String accountId;

}

/* SummonerDTO - represents a summoner
profileIconId	int	ID of the summoner icon associated with the summoner.
name	string	Summoner name.
puuid	string	Encrypted PUUID. Exact length of 78 characters.
summonerLevel	long	Summoner level associated with the summoner.
revisionDate	long	Date summoner was last modified specified as epoch milliseconds. The following events will update this timestamp: profile icon change, playing the tutorial or advanced tutorial, finishing a game, summoner name change
id	string	Encrypted summoner ID. Max length 63 characters.
accountId	string	Encrypted account ID. Max length 56 characters.
 */
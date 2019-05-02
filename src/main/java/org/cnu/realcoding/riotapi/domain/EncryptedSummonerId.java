package org.cnu.realcoding.riotapi.domain;

// 어노테이션을 붙여 자동으로 생성된 접근자와 설정자 메소드를 사용할 수 있게끔 해줌
import lombok.Data;

// @Getter, @Setter, @RequiredArgsConstructor, @ToString, @EqualsAndHashCode을 한꺼번에 설정
@Data
public class EncryptedSummonerId {
    private String queueType;
    private String summonerName;
    private boolean hotStreak;
    private MiniSeriesDTO miniSeries;
    private int wins;
    private boolean veteran;
    private int losses;
    private String rank;
    private String leagueId;
    private boolean inactive;
    private boolean freshBlood;
    private String tier;
    private String summonerId;
    private int leaguePoints;


    // private String leagueName;
    // private String position;


    public static class MiniSeriesDTO {
        public String progress;
        public int losses;
        public int target;
        public int wins;
    }
}

/* LeagueEntryDTO
queueType	string
summonerName	string
hotStreak	boolean
miniSeries	MiniSeriesDTO
wins	int
veteran	boolean
losses	int
rank	string
leagueId	string
inactive	boolean
freshBlood	boolean
tier	string
summonerId	string	Player's summonerId (Encrypted)
leaguePoints	int
 */

/* MiniSeriesDTO
progress	string
losses	int
target	int
wins	int
 */
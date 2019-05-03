package org.cnu.realcoding.riotapi.domain;

// 어노테이션을 붙여 자동으로 생성된 접근자와 설정자 메소드를 사용할 수 있게끔 해줌
import lombok.Data;

// @Getter, @Setter, @RequiredArgsConstructor, @ToString, @EqualsAndHashCode을 한꺼번에 설정




//"Unrecognized field \"leagueName\"
// (class org.cnu.realcoding.riotapi.domain.EncryptedSummonerId),
// not marked as ignorable
// (14 known properties: \"tier\", \"summonerId\", \"leagueId\", \"queueType\",
// \"rank\", \"miniSeries\", \"losses\", \"leaguePoints\", \"wins\", \"summonerName\",
// \"veteran\", \"hotStreak\", \"freshBlood\", \"inactive\"])\n
// at [Source: (String)\"{\"leagueId\":\"ba73b86b-97c9-3dfc-856e-88777fec7e56\",
// \"leagueName\":\"Nautilus's Outriders\",\"queueType\":\"RANKED_SOLO_5x5\",
// \"position\":\"NONE\",\"tier\":\"CHALLENGER\",\"rank\":\"I\",
// \"summonerId\":\"KSIWQtN2_cnKwQY-Tf1hvmL0vSICRQxCoBKdnr813ns_vg\",
// \"summonerName\":\"Hide on bush\",\"leaguePoints\":787,\"wins\":192,
// \"losses\":192,\"veteran\":false,\"inactive\":false,\"freshBlood\":false,\"hotStreak\":true}\";
// line: 1, column: 66]
// (through reference chain: org.cnu.realcoding.riotapi.domain.EncryptedSummonerId[\"leagueName\"])",
  //      "path": "/api"
@Data
public class EncryptedSummonerId {
    private String leagueName;
    private String queueType;
    private String position;
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


    //
    //


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
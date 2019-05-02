package org.cnu.realcoding.riotapi.domain;

import lombok.Data;

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
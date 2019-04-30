# 실전코딩 6주차 과제 - 9조
> 201704147 이용재

> 201702063 이지현

> 201702019 박채연
src
main
java
org
cnu
realcoding
riotapi
RiotapiApplication.java
resources
test## <structure>
- API // 외부 api를 호출하는 녀석들
- CONFIG // 설정을 해야한다면 여기에
  - httpconfig
  - swaggerconfig
  - mongoconfig
- CONTROLLER // 클라이언트와 request / response(로직 전까지 준비물)
  - controller
- DOMAIN // VO(DTO) 오브젝트 getter, setter 나누어줌 - 정보은닉
  - summonerName
  - encryptedSummonerId
- REPOSITORY // DB쪽 호출하는 녀석들
  - repository
- SERVICE // 비즈니스 로직 처리(domain 객체 조합 후 결과만들어 반환)
  - service
- spring-api.java // 실행될 때 세부적인 것 포함
## <과제 목표>
-  Riot Games API 호출하고 결과를 DB에 저장
  - https://developer.riotgames.com 방문
  - 자신만의 API Key 생성
  - API DOCUMENTATION으로 이동(Swagger page 제공됨)
  - 좌측의 SUMMONER-V4 선택
  - `/lol/summoner/v4/summoners/by-name/{summonerName}`
    - 프로게이머 소환사 이름(hide on bush)로 request
      - 팁: Query Param(RequestParam) 방식으로 API KEY를 INCLUDE 하세요! 이때 Response Body에 존재하는 “id” 값이 encryptedSummonerId 입니다.
  - 계속해서 좌측 LEAGUE-V4 선택
    - 아까 응답받은 encryptedSummonerId 를 사용하여 /lol/league/v4/positions/by-summoner/{encryptedSummonerId}
      request 해보기
  - **중요**
    - 우리 Spring boot application에 "소환사이름"을 파라미터로 request 할 수 있는 GET방식의 endpoint(API)를 하나 구현
      - 이 API는 Request를 받으면, 소환사의 league position(소환사의 게임 성적 정보)을 response
    - 구현방법
      - SUMMONER-V4 의 /lol/summoner/v4/summoners/by-name/{summonerName} API 를 호출하여 encryptedSummonerId 를 얻으세요.
        - encryptedSummonerId는 호출한 결과의 “id”에 들어있습니다.
      - SUMMONER-V4 의 /lol/league/v4/positions/by-summoner/{encryptedSummonerId} API 를 호출하여 결과를 DB에 저장하고, 결과를 response 하세요.
    - 가산점
      - (0점) DB에 이미 소환사의 게임 성적 정보가 들어있던지 말던지 새로 얻은 결과를 삽입
      - (1점) DB에 이미 소환사의 게임 성적 정보가 들어있다면, 지워버리고 새로 얻은 결과를 삽입
        - 힌트: mongoTemplate에 delete() 메소드가 있음
      - (2점) DB에 이미 소환사의 게임 성적 정보가 들어있다면, 이를 업데이트하세요
        - 힌트: mongoTemplate에 update() 메소드가 있음
      - (1점~2점) git 에 작업 과정을 남길 것 (중간 중간 커밋을 하셔야겠죠?)
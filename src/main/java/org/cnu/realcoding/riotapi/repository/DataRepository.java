// DB쪽 호출하는 녀석들
package org.cnu.realcoding.riotapi.repository;

import org.cnu.realcoding.riotapi.domain.EncryptedSummonerId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

// 클래스가 데이터베이스에 접근하는 클래스임을 명시
@Repository
public class DataRepository {
    // 의존관계를 자동설정할 때 사용하며 타입을 이용하여 의존하는 객체를 삽입
    @Autowired
    // MongoTemplate : MongoDB에 대한 CRUD, 쿼리 메소드,
    // domain object와 MongoDB document의 매핑 기능 제공
    private MongoTemplate mongoTemplate;

    public void getAndInsertDB(EncryptedSummonerId encryptedSummonerId) {
        // this : 멤버 메소드내에서 존재한다는 그 객체에 대한 레퍼런스
        // 필드(전역변수)와 메소드 또는 생성자의 매개변수가 동일할 때 인스턴스 필드임을 명확히 하기 위해 사용
        // 소스코드가 복잡해지고 변수가 많아지면 관리하기가 힘들기 때문에 필드와 매개변수를 동일하게 정의하고 this.로 구분하는 것이 편리
        this.mongoTemplate.insert(encryptedSummonerId);
    }

}

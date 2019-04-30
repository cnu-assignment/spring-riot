// DB쪽 호출하는 녀석들
package org.cnu.realcoding.riotapi.repository;

import org.cnu.realcoding.riotapi.domain.EncryptedSummonerId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DataRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    public void getAndInsertDB(EncryptedSummonerId encryptedSummonerId) {
        this.mongoTemplate.insert(encryptedSummonerId);
    }

}

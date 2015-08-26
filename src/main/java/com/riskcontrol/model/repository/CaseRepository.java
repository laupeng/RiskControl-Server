package com.riskcontrol.model.repository;

import com.riskcontrol.model.entity.LawCase;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * Created by Killua on 8/11/15.
 */
public interface CaseRepository extends MongoRepository<LawCase, String> {

//    @Override
//    @RestResource(exported = false)
//    LawCase save(LawCase entity);

    @Override
    @RestResource(exported = false)
    void delete(String id);

    @Override
    @RestResource(exported = false)
    void delete(LawCase entity);
}

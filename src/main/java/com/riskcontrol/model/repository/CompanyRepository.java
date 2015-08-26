package com.riskcontrol.model.repository;

import com.riskcontrol.model.entity.Company;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * Created by Killua on 8/23/15.
 */
public interface CompanyRepository extends MongoRepository<Company, String> {

    @Override
    @RestResource(exported = false)
    void delete(String id);

    @Override
    @RestResource(exported = false)
    void delete(Company entity);
}

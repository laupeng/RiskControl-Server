package com.riskcontrol.model.repository;

import com.riskcontrol.model.entity.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * Created by Killua on 7/11/15.
 */

@RepositoryRestResource(path = "smsCodes", collectionResourceRel = "smsCodes")
public interface SMSCodeRepository extends CrudRepository<SMSCode, String> {

    @Override
    @RestResource(exported = false)
    SMSCode save(SMSCode entity);

    @Override
    @RestResource(exported = false)
    void delete(String id);

    @Override
    @RestResource(exported = false)
    void delete(SMSCode entity);
}

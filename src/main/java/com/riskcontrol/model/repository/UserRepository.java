package com.riskcontrol.model.repository;

import com.riskcontrol.model.entity.*;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * Created by Killua on 8/22/15.
 */
public interface UserRepository extends MongoRepository<User, String> {

    User findByMobile(String mobile);

    @Override
    @RestResource(exported = false)
    void delete(String id);

    @Override
    @RestResource(exported = false)
    void delete(User entity);
}

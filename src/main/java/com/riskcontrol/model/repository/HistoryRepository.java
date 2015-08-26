package com.riskcontrol.model.repository;

import com.riskcontrol.model.entity.History;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Killua on 8/23/15.
 */
public interface HistoryRepository extends MongoRepository<History, String> {
}

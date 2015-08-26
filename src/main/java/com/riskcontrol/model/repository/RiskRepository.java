package com.riskcontrol.model.repository;

import com.riskcontrol.model.entity.Risk;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Killua on 8/23/15.
 */
public interface RiskRepository extends CrudRepository<Risk, String> {
}

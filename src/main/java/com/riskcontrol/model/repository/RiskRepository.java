package com.riskcontrol.model.repository;

import com.riskcontrol.model.entity.Risk;
import com.riskcontrol.model.entity.Subprocess;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Killua on 8/23/15.
 */
public interface RiskRepository extends CrudRepository<Risk, String> {

    List<Risk> findBySubprocess(Subprocess subprocess);
}

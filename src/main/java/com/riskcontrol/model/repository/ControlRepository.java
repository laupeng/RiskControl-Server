package com.riskcontrol.model.repository;

import com.riskcontrol.model.entity.Control;
import com.riskcontrol.model.entity.Risk;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Killua on 8/23/15.
 */
public interface ControlRepository extends CrudRepository<Control, String> {

    List<Control> findByRisk(Risk risk);
}

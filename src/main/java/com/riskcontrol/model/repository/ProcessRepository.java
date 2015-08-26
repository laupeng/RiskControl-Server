package com.riskcontrol.model.repository;

import com.riskcontrol.model.entity.Process;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Killua on 8/22/15.
 */
public interface ProcessRepository extends CrudRepository<Process, String> {
}

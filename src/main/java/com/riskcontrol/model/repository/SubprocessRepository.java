package com.riskcontrol.model.repository;

import com.riskcontrol.model.entity.*;
import com.riskcontrol.model.entity.Process;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Killua on 8/23/15.
 */
public interface SubprocessRepository extends CrudRepository<Subprocess, String> {

    List<Subprocess> findByProcess(Process process);
}

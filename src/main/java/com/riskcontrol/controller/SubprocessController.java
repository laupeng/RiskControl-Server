package com.riskcontrol.controller;

import com.riskcontrol.model.entity.Risk;
import com.riskcontrol.model.entity.Subprocess;
import com.riskcontrol.model.repository.RiskRepository;
import com.riskcontrol.model.repository.SubprocessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Killua on 8/27/15.
 */

@RestController
@RequestMapping("/api/subprocesses")
public class SubprocessController {

    private final SubprocessRepository subprocessRepository;
    private final RiskRepository riskRepository;

    @Autowired
    public SubprocessController(SubprocessRepository subprocessRepository, RiskRepository riskRepository) {
        this.subprocessRepository = subprocessRepository;
        this.riskRepository = riskRepository;
    }

    @RequestMapping(value = "/{id}/risks", method = RequestMethod.GET)
    public List<Risk> getRisksById(@PathVariable String id) {
        Subprocess subprocess = subprocessRepository.findOne(id);
        return riskRepository.findBySubprocess(subprocess);
    }
}

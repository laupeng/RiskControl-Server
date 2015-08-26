package com.riskcontrol.controller;

import com.riskcontrol.model.entity.Process;
import com.riskcontrol.model.entity.Subprocess;
import com.riskcontrol.model.repository.ProcessRepository;
import com.riskcontrol.model.repository.SubprocessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Killua on 8/24/15.
 */

@RestController
@RequestMapping("/api/processes")
public class ProcessController {

    private final ProcessRepository processRepository;
    private final SubprocessRepository subprocessRepository;

    @Autowired
    public ProcessController(ProcessRepository processRepository, SubprocessRepository subprocessRepository) {
        this.processRepository = processRepository;
        this.subprocessRepository = subprocessRepository;
    }

    @RequestMapping(value = "/{id}/subprocesses", method = RequestMethod.GET)
    public List<Subprocess> findOne(@PathVariable String id) {
        Process process = processRepository.findOne(id);
        return subprocessRepository.findByProcess(process);
    }
}
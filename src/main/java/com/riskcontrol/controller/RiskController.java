package com.riskcontrol.controller;

import com.riskcontrol.model.entity.Control;
import com.riskcontrol.model.entity.Risk;
import com.riskcontrol.model.repository.ControlRepository;
import com.riskcontrol.model.repository.RiskRepository;
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
@RequestMapping("/api/risks")
public class RiskController {

    private final RiskRepository riskRepository;
    private final ControlRepository controlRepository;

    @Autowired
    public RiskController(RiskRepository riskRepository, ControlRepository controlRepository) {
        this.riskRepository = riskRepository;
        this.controlRepository = controlRepository;
    }

    @RequestMapping(value = "/{id}/controls", method = RequestMethod.GET)
    public List<Control> findControlsById(@PathVariable String id) {
        Risk risk = riskRepository.findOne(id);
        return controlRepository.findByRisk(risk);
    }
}

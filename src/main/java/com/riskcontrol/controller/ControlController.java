package com.riskcontrol.controller;

import com.riskcontrol.model.entity.Control;
import com.riskcontrol.model.entity.LawCase;
import com.riskcontrol.model.repository.ControlRepository;
import com.riskcontrol.model.service.CaseService;
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
@RequestMapping("/api/controls")
public class ControlController {

    private final ControlRepository controlRepository;
    private final CaseService caseService;

    @Autowired
    public ControlController(ControlRepository controlRepository, CaseService caseService) {
        this.controlRepository = controlRepository;
        this.caseService = caseService;
    }

    @RequestMapping(value = "/{id}/cases", method = RequestMethod.GET)
    public List<LawCase> findCasesById(@PathVariable String id) {
        Control control = controlRepository.findOne(id);
        return caseService.searchByControl(control);
    }
}

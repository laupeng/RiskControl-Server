package com.riskcontrol.model.entity;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

/**
 * Created by Killua on 8/23/15.
 */

@Component
public class UserNameAuditor implements AuditorAware<String> {

    @Override
    public String getCurrentAuditor() {
        return "Killua";
    }
}

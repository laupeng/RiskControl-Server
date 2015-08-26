package com.riskcontrol.model.service;

import com.riskcontrol.model.entity.SMSCode;
import com.riskcontrol.model.repository.SMSCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Killua on 7/11/15.
 */

@Service
public class SMSCodeService {

    private final SMSCodeRepository smsCodeRepository;

    @Autowired
    public SMSCodeService(SMSCodeRepository smsCodeRepository) {
        this.smsCodeRepository = smsCodeRepository;
    }

    public void save(SMSCode smsCode) {
        smsCodeRepository.save(smsCode);
    }

    public void delete(SMSCode smsCode) {
        smsCodeRepository.delete(smsCode);
    }
}

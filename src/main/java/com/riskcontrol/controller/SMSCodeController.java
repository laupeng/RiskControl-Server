package com.riskcontrol.controller;

import com.riskcontrol.model.entity.SMSCode;
import com.riskcontrol.model.service.SMSCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.Random;

import static com.riskcontrol.common.CustomProperties.propertiesInstance;

/**
 * Created by Killua on 7/11/15.
 */

@RestController
@RequestMapping("/api/smsCodes")
public class SMSCodeController {

    private final SMSCodeService smsCodeService;
    private final ThreadPoolTaskScheduler taskScheduler;

    @Autowired
    public SMSCodeController(SMSCodeService smsCodeService, ThreadPoolTaskScheduler taskScheduler) {
        this.smsCodeService = smsCodeService;
        this.taskScheduler = taskScheduler;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void sendSMS(@RequestBody final SMSCode smsCode) {
        Integer code = new Random(System.currentTimeMillis()).nextInt((int) Math.pow(10, 6));
        smsCode.setCode(code.toString());
        String text = propertiesInstance().getSmsText().replaceFirst("&", code.toString());

//      Send SMS code and save it
        MultiValueMap requestParams = new LinkedMultiValueMap();
        requestParams.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE);
        requestParams.add("apikey", propertiesInstance().getSmsApikey());
        requestParams.add("mobile", smsCode.getMobile());
        requestParams.add("text", text);

        String url = propertiesInstance().getSmsSendUrl();
        SMSCode result = new RestTemplate().postForObject(url, requestParams, SMSCode.class);

//      Remove SMS code after invalid since timeout
        if (0 == result.getReturnCode()) {
            smsCodeService.save(smsCode);

            taskScheduler.schedule(new Runnable() {
                @Override
                public void run() {
                    smsCodeService.delete(smsCode);
                }
            }, new Date(System.currentTimeMillis() + 10*60*1000));
        }
    }
}

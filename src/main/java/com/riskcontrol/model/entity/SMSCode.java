package com.riskcontrol.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Killua on 8/22/15.
 */

@Getter
@Setter
@Document
public class SMSCode {

    @Id
    private String mobile;

    private String code;

    @Transient
    private short returnCode;
}

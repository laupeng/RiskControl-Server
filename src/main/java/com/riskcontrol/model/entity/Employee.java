package com.riskcontrol.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.riskcontrol.common.Util;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Killua on 8/23/15.
 */

@Getter
@Setter
@Document
public class Employee {

    @Id
    private String id;

    private String password;

    private String fullName;

    private String mobile;

    private String email;

    private boolean obsolete;

    @Transient
    private boolean wrongPassword;


    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @JsonProperty
    public void setPassword(String password) {
        this.password = Util.generateHashedPassword(password);
    }
}

package com.riskcontrol.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.riskcontrol.common.Util;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.hateoas.Identifiable;

import java.util.Date;
import java.util.List;

/**
 * Created by Killua on 8/22/15.
 */

@Getter
@Setter
@Document
public class User implements Identifiable<String> {

    @Override
    public String getId() {
        return id;
    }

    @Id
    private String id;

    @Indexed
    private String mobile;

    private String password;

    private String fullName;

    private String department;

    private String position;

    private String avatarName;

    private boolean obsolete;

    @CreatedDate
    private Date createdDate;

    @DBRef
    private List<LawCase> favoriteCases;

    @DBRef(lazy = true)
    private Company company;

    @Transient
    private boolean notFound;

    @Transient
    private boolean mobileTaken;

    @Transient
    private boolean wrongPassword;

    @Transient
    private boolean wrongSMSCode;


    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @JsonProperty
    public void setPassword(String password) {
        this.password = Util.generateHashedPassword(password);
    }
}

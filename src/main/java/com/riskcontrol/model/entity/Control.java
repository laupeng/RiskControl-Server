package com.riskcontrol.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * Created by Killua on 8/22/15.
 */

@Getter
@Setter
@Document
public class Control extends BaseEntity {

    private String content;

    private List<String> keywords;

    @RestResource(exported = false)
    @DBRef
    private Risk risk;

    @DBRef
    private List<LawCase> lawCases;


    @JsonIgnore
    public List<String> getKeywords() {
        return keywords;
    }

    @JsonProperty
    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }
}

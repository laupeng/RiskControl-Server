package com.riskcontrol.model.entity;

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
public class Risk extends BaseEntity {

    private String content;

    @RestResource(exported = false)
    @DBRef
    private Subprocess subprocess;

    @DBRef
    private List<Control> controls;
}

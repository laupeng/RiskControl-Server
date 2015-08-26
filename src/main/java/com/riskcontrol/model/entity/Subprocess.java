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
public class Subprocess extends BaseEntity {

    private String name;

    private String remark;

    @RestResource(exported = false)
    @DBRef
    private Process process;

    @DBRef
    private List<Risk> risks;
}

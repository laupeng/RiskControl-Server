package com.riskcontrol.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by Killua on 8/22/15.
 */

@Getter
@Setter
@Document
public class Process extends BaseEntity {

    private String name;

    private List<String> positions;

    @DBRef
    private List<Subprocess> subprocesses;
}

package com.riskcontrol.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Created by Killua on 8/23/15.
 */

@Getter
@Setter
@Document
public class History {

    @Id
    private String id;

    @DBRef
    private User user;

    @DBRef
    private Subprocess subprocess;

    @DBRef
    private Risk risk;

    @DBRef
    private Control control;

    @DBRef
    private LawCase lawCase;

    @CreatedDate
    private Date createdDate;
}

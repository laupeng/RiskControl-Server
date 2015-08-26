package com.riskcontrol.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.*;
import org.springframework.hateoas.Identifiable;

import java.util.Date;

/**
 * Created by Killua on 8/23/15.
 */

@Getter
@Setter
public abstract class BaseEntity implements Identifiable<String> {

    @Id
    private String id;

    @CreatedBy
    private String createdBy;

    @CreatedDate
    private Date createdDate;

    @LastModifiedBy
    private String updatedBy;

    @LastModifiedDate
    private Date updatedDate;

//    @Version
//    private Long version;
}

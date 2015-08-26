package com.riskcontrol.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Killua on 8/23/15.
 */

@Getter
@Setter
@Document
public class Product {

    @Id
    private String id;

    private String name;

    private String remark;

    private double price;

    private int month;

    private int userCapacity;
}

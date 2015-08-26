package com.riskcontrol.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

/**
 * Created by Killua on 8/23/15.
 */

@Getter
@Setter
@Document
public class Company {

    @Id
    private String id;

    private String name;

    private String slogan;

    private String logoName;

    private String businessLicence;

    private List<Address> addresses;

    private String invoiceTitle;

    private int userCount;

    private int userCapacity;

    private Date productValidDate;

    @CreatedDate
    private Date createdDate;

    @LastModifiedBy
    @DBRef
    private User user;

    @LastModifiedDate
    private Date lastModifiedDate;


    @Getter
    @Setter
    public static class Address {
        private String contact;

        private String mobile;

        private String phone;

        private String email;

        private String detail;
    }
}

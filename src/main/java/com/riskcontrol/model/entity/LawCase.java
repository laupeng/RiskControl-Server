package com.riskcontrol.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.TextScore;

import java.util.Date;

/**
 * Created by Killua on 8/11/15.
 */

@Getter
@Setter
@Document(collection = "lawCase")
public class LawCase {

    @Id
    private String id;

    @Indexed(unique = true)
    private String number;

    private String category;

    private String section;

    private String judgeName;

    private String judgeLevel;

    @Indexed
    private Date settleDate;

    @TextIndexed
    private String content;

    @TextScore
    private Float score;

    @CreatedDate
    private Date createdDate;
}
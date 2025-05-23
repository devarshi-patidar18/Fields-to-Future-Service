package com.apis.Fields_To_Future_Services.Entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Contribution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long group_id;
    private Long member_id;
    private Double amount;
    private String type;
    private String comments;

}

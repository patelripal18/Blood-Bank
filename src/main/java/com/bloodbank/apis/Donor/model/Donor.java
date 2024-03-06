package com.bloodbank.apis.Donor.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Donor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //private Long id;
    private int donorId;
    private String userId;
    private String Quantity;
    private String unit;
    private String HId;
    private String bloodcollectDate;

    public void setId(Long donorId) {
    }
}

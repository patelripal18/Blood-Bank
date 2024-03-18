package com.bloodbank.apis.donor.model;

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

    private Long donorId;
    private String userId;
    private String quantity;
    private String unit;
    private String hId;
    private String bloodcollectDate;

    public void setId(int donorId) {
    }
}

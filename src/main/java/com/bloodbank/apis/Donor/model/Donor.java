package com.bloodbank.apis.Donor.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Donor {
    @Id
    private Long id;
    private int donorId;
    private int userId;
    private int Qunatity;
    private String unit;
    private int HId;
    private int bloodcollectDate;
}

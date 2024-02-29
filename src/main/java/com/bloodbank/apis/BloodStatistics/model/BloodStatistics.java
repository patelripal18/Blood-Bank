package com.bloodbank.apis.BloodStatistics.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class BloodStatistics {
    @Id
    private int Id;
    private String Bloodtype;
    private int Quantity;


}

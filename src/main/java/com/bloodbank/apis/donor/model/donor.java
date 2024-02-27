package com.bloodbank.apis.donor.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class donor {
    private int donorId;
    private int userId;
    private int Qunatity;
    private String unit;
    private int HId;
    private int bloodcollectDate;
}

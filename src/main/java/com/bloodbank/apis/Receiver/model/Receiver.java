package com.bloodbank.apis.Receiver.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Receiver {
    @Id
    private int RId;
    private int UId;
    private int Quantity;
    private int HId;
    private String Bloodgroup;
    private int receivedate;
    private int receiverNo;
    private String unit;
}

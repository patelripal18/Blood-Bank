package com.bloodbank.apis.receiver.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Receiver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rId;
    private String uId;
    private String quantity;
    private String hId;
    private String bloodgroup;
    private String receivedate;
    private String receiverNo;
    private String unit;

   
}

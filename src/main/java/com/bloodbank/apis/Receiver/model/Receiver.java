package com.bloodbank.apis.Receiver.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;

@Getter
@Setter
@Entity
public class Receiver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int RId;
    private String UId;
    private String Quantity;
    private String HId;
    private String Bloodgroup;
    private String receivedate;
    private String receiverNo;
    private String unit;

   
}

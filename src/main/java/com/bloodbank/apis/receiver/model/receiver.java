package com.bloodbank.apis.receiver.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class receiver {

    private int RId;
    private int UId;
    private int Quantity;
    private int HId;
    private String Bloodgroup;
    private int receivedate;
    private int receiverNo;
    private String unit;
}

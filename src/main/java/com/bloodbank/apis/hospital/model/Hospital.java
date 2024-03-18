package com.bloodbank.apis.hospital.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hospitalId;
    private String hospitalName;
    private String hAdress;

//    public Hospital(int hospitalId, String hospitalName, String HAdress) {
//        this.hospitalId = hospitalId;
//        hospitalName = hospitalName;
//        this.hAdress = HAdress;
//    }

//    public Hospital() {
//
//    }
}

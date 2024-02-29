package com.bloodbank.apis.Hospital.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Hospital {
    @Id
    private int hospitalId;
    private String HospitalName;
    private String HAdress;

    public Hospital(int hospitalId, String hospitalName, String HAdress) {
        this.hospitalId = hospitalId;
        HospitalName = hospitalName;
        this.HAdress = HAdress;
    }

    public Hospital(){

    }

//    public int getHospitalId() {
//        return hospitalId;
//    }
//
//    public void setHospitalId(int hospitalId) {
//        this.hospitalId = hospitalId;
//    }
//
//    public String getHospitalName() {
//        return HospitalName;
//    }
//
//    public void setHospitalName(String hospitalName) {
//        HospitalName = hospitalName;
//    }
//
//    public String getHAdress() {
//        return HAdress;
//    }
//
//    public void setHAdress(String HAdress) {
//        this.HAdress = HAdress;
//    }
}
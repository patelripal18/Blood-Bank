package com.bloodbank.apis.hospital.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class hospital {
    private int hospitalId;
    private String HospitalName;
    private String HAdress;

    public hospital(int hospitalId, String hospitalName, String HAdress) {
        this.hospitalId = hospitalId;
        HospitalName = hospitalName;
        this.HAdress = HAdress;
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

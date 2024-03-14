package com.bloodbank.apis.user.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Table(name = "blood_bank")
@Entity


public class BloodUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private String address;
    private String contactnumber;
    private String email;
    private String bloodGroup;
    private String disease;
    private String gender;
    private String age;
    private String weight;
    private String height;

    public BloodUser() {

    }

    public BloodUser(Long id, String firstname, String lastname, String address, String contactnumber, String email, String bloodGroup, String disease, String gender, String age, String weight, String height) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.contactnumber = contactnumber;
        this.email = email;
        this.bloodGroup = bloodGroup;
        this.disease = disease;
        this.gender = gender;
        this.age = age;
        this.weight = weight;
        this.height = height;


    }

}
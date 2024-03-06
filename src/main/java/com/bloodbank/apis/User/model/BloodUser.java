package com.bloodbank.apis.User.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "blood_bank")
@Entity
public class BloodUser {
    @Getter
    @Setter

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String FirstName;
    private String LastName;
    private String Address;
    private String ContactNumber;
    private String Email;
    private String BloodGroup;
    private String Disease;
    private String Gender;
    private String Age;
    private String Weight;
    private String Height;

    public BloodUser() {

    }

    public BloodUser(Long id, String firstName, String lastName, String address, String contactNumber, String email, String bloodGroup, String disease, String gender, String age, String weight, String height) {
        Id = id;
        FirstName = firstName;
        LastName = lastName;
        Address = address;
        ContactNumber = contactNumber;
        Email = email;
        BloodGroup = bloodGroup;
        Disease = disease;
        Gender = gender;
        Age = age;
        Weight = weight;
        Height = String.valueOf(height);
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(String contactNumber) {
        ContactNumber = contactNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getBloodGroup() {
        return BloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        BloodGroup = bloodGroup;
    }

    public String getDisease() {
        return Disease;
    }

    public void setDisease(String disease) {
        Disease = disease;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getWeight() {
        return Weight;
    }

    public void setWeight(String weight) {
        Weight = weight;
    }

    public String getHeight() {
        return Height;
    }

    public void setHeight(String height) {
        Height = String.valueOf(height);
    }




}

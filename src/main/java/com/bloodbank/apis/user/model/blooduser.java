package com.bloodbank.apis.user.model;

public class blooduser {

    private int Id;
    private String FirstName;
    private String LastName;
    private String Address;
    private int ContactNumber;
    private String Email;
    private String BloodGroup;
    private String Disease;
    private String Gender;
    private int Age;
    private int Weight;
    private int Height;
    public int getId() {
        return Id;
    }

    public blooduser(int id, String firstName, String lastName, String address, int contactNumber, String email, String bloodGroup, String disease, String gender, int age, int weight, int height) {
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
        Height = height;
    }

    public void setId(int id) {
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

    public int getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(int contactNumber) {
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

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public int getWeight() {
        return Weight;
    }

    public void setWeight(int weight) {
        Weight = weight;
    }

    public int getHeight() {
        return Height;
    }

    public void setHeight(int height) {
        Height = height;
    }




}

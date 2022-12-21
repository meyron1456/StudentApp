package com.example.exercise2.model;

public class Student {
    private String name = "";
    private String id = "";
    private boolean isChecked = false;
    private String phoneNumber = "";
    private String address = "";

    public Student(String name, String id, boolean flag,String phoneNumber, String address) {
        this.name = name;
        this.id = id;
        this.isChecked = flag;
        this.phoneNumber=phoneNumber;
        this.address=address;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setIsChecked(boolean checked) {
        this.isChecked = checked;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getAddress() {
        return address;
    }
    public String getName() {
        return name;
    }
    public String getId() {
        return id;
    }
    public boolean getIsChecked() {
        return isChecked;
    }
}

package com.medclinic.dto;

public class CreateClientDTO {
    private String login;
    private String password;
    private String fullName;
    private String familyName;
    private int age;
    private String about;
    private String actualAddress;
    private String phoneNumber;
    private String birthDay;

    public CreateClientDTO(String login, String password, String fullName, String familyName, int age,
                           String about, String actualAddress, String phoneNumber, String birthDay) {
        this.login = login;
        this.password = password;
        this.fullName = fullName;
        this.familyName = familyName;
        this.age = age;
        this.about = about;
        this.actualAddress = actualAddress;
        this.phoneNumber = phoneNumber;
        this.birthDay = birthDay;
    }

    public CreateClientDTO() {}

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getActualAddress() {
        return actualAddress;
    }

    public void setActualAddress(String actualAddress) {
        this.actualAddress = actualAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }
}

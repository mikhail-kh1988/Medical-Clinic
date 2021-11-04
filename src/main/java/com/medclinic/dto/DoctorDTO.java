package com.medclinic.dto;

public class DoctorDTO {
    private String login;
    private String password;
    private String email;
    private Integer age;
    private String fullName;
    private String familyName;
    private String whereStudy;
    private String specializationName;
    private String certificateNumber;

    public DoctorDTO(String login, String password, String email, Integer age, String fullName,
                     String familyName, String whereStudy, String specializationName, String certificateNumber) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.age = age;
        this.fullName = fullName;
        this.familyName = familyName;
        this.whereStudy = whereStudy;
        this.specializationName = specializationName;
        this.certificateNumber = certificateNumber;
    }

    public DoctorDTO() {}

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    public String getWhereStudy() {
        return whereStudy;
    }

    public void setWhereStudy(String whereStudy) {
        this.whereStudy = whereStudy;
    }

    public String getSpecializationName() {
        return specializationName;
    }

    public void setSpecializationName(String specializationName) {
        this.specializationName = specializationName;
    }

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }
}

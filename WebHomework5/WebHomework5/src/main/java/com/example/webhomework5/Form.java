package com.example.webhomework5;
import java.io.Serializable;

public class Form implements Serializable {
    private String name;
    private String email;
    private String phone;
    private String moto;
    private String culi;
    private int count;
    private String nameMember1;
    private String surnameMember1;
    private String emailMember1;
    private String linkedin1;

    private String nameMember2;
    private String surnameMember2;
    private String emailMember2;
    private String linkedin2;


    public Form () {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMoto() {
        return moto;
    }

    public void setMoto(String moto) {
        this.moto = moto;
    }

    public String getCuli() {
        return culi;
    }

    public void setCuli(String culi) {
        this.culi = culi;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNameMember1() {
        return nameMember1;
    }

    public void setNameMember1(String nameMember1) {
        this.nameMember1 = nameMember1;
    }

    public String getSurnameMember1() {
        return surnameMember1;
    }

    public void setSurnameMember1(String surnameMember1) {
        this.surnameMember1 = surnameMember1;
    }

    public String getEmailMember1() {
        return emailMember1;
    }

    public void setEmailMember1(String emailMember1) {
        this.emailMember1 = emailMember1;
    }


    public String getLinkedin1() {
        return linkedin1;
    }

    public void setLinkedin1(String linkedin1) {
        this.linkedin1 = linkedin1;
    }

    public String getNameMember2() {
        return nameMember2;
    }

    public void setNameMember2(String nameMember2) {
        this.nameMember2 = nameMember2;
    }

    public String getSurnameMember2() {
        return surnameMember2;
    }

    public void setSurnameMember2(String surnameMember2) {
        this.surnameMember2 = surnameMember2;
    }

    public String getEmailMember2() {
        return emailMember2;
    }

    public void setEmailMember2(String emailMember2) {
        this.emailMember2 = emailMember2;
    }

    public String getLinkedin2() {
        return linkedin2;
    }

    public void setLinkedin2(String linkedin2) {
        this.linkedin2 = linkedin2;
    }

}


package com.rekom.CureCompanion;

public class UserProfileModel {

    public String username,userUID;
    public String email;
    public String number;
    public String domicile;

    public UserProfileModel(String name, String uid) {
    }

    public UserProfileModel(String username, String userUID, String email, String number, String domicile) {
        this.username = username;
        this.userUID = userUID;
        this.email = email;
        this.number = number;
        this.domicile = domicile;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserUID() {
        return userUID;
    }

    public void setUserUID(String userUID) {
        this.userUID = userUID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDomicile() {
        return domicile;
    }

    public void setDomicile(String domicile) {
        this.domicile = domicile;
    }
}

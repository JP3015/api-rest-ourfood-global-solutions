package com.uorfood.ddd;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Users {
    private int id;
    private String name;
    private String email;
    private String password;
    private int punctuation = 0;
    private int donation = 0;
    private String photo;


    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getDonation() {
        return donation;
    }

    public void setDonation(int donation) {
        this.donation = donation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPunctuation() {
        return punctuation;
    }

    public void setPunctuation(int punctuation) {
        this.punctuation = punctuation;
    }


}


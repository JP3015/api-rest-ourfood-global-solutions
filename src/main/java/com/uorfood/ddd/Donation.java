package com.uorfood.ddd;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Donation {
    private Integer id;
    private String  title;
    private String photo;
    private Integer totalDonation;
    private Integer valueDonation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getTotalDonation() {
        return totalDonation;
    }

    public void setTotalDonation(Integer totalDonation) {
        this.totalDonation = totalDonation;
    }

    public Integer getValueDonation() {
        return valueDonation;
    }

    public void setValueDonation(Integer valueDonation) {
        this.valueDonation = valueDonation;
    }
}

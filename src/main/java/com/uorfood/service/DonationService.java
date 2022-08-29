package com.uorfood.service;

import com.uorfood.dao.implementation.DonationImplementation;
import com.uorfood.ddd.Donation;

import java.sql.SQLException;
import java.util.List;


public class DonationService {
    private DonationImplementation donationDao = new DonationImplementation();

    public DonationService() throws SQLException {
    }

    public List<Donation> getAllDonation() {
        return donationDao.getAllDonation();
    }


    public void updatedDonation(Donation donation, Integer id) {
        donationDao.updateDonation(donation, id);
    }

    public List<Donation> getDonationById(Integer id) {
        return donationDao.getById(id);
    }
}

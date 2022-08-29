package com.uorfood.dao;

import com.uorfood.ddd.Donation;

import java.util.List;

public interface DonationDao {
    /*@return  Todos os dados referentes a lista de doações  */
    List<Donation> getAllDonation();

    void updateDonation(Donation donation,Integer id);

    List<Donation>  getById(Integer id);

}

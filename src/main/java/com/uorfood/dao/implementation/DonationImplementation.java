package com.uorfood.dao.implementation;

import com.uorfood.Config;
import com.uorfood.dao.DonationDao;
import com.uorfood.ddd.Donation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DonationImplementation implements DonationDao {
    private Config config = new Config();
    private static List<Donation> donations;

    public DonationImplementation() throws SQLException {
    }


    @Override
    public List<Donation> getAllDonation() {
        String query = "SELECT * FROM DONATION";
        donations = null;
        try (Connection coon = config.getConnection();
             Statement stm = coon.createStatement();
             ResultSet rest = stm.executeQuery(query);
        ) {

            if (donations == null) {
                donations = new ArrayList<Donation>();
                while (rest.next()) {
                    Donation donation = new Donation();
                    donation.setId(rest.getInt("donation_id"));
                    donation.setPhoto(rest.getString("donation_link"));
                    donation.setTotalDonation(rest.getInt("donation_max"));
                    donation.setValueDonation(rest.getInt("donation_value"));
                    donation.setTitle(rest.getString("donation_title"));
                    donations.add(donation);
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return donations;
    }

    @Override
    public void updateDonation(Donation donation, Integer id) {
        String query = "UPDATE DONATION SET donation_value=? WHERE donation_id=?";
        try(Connection coon = config.getConnection();
            PreparedStatement ps = coon.prepareStatement(query);
        ) {

            ps.setInt(1, donation.getValueDonation());
            ps.setInt(2, id);
            ps.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Donation> getById(Integer id) {
        String query = "SELECT * FROM DONATION";
        donations = null;
        try(Connection coon = config.getConnection();
            Statement stm = coon.createStatement();
            ResultSet rst = stm.executeQuery(query);
        ) {

            if (donations == null) {
                donations = new ArrayList<Donation>();
                while (rst.next()) {
                    Donation donation = new Donation();
                    if (id.equals(rst.getInt("donation_id"))) {
                        donation.setId(rst.getInt("donation_id"));
                        donation.setTotalDonation(rst.getInt("donation_max"));
                        donation.setValueDonation(rst.getInt("donation_value"));
                        donation.setPhoto(rst.getString("donation_link"));
                        donation.setTitle(rst.getString("donation_title"));
                        donations.add(donation);

                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return donations;
    }


}

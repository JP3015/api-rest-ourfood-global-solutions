package com.uorfood.dao.implementation;

import com.uorfood.Config;
import com.uorfood.dao.CompanyDao;
import com.uorfood.ddd.Company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompanyImplementation implements CompanyDao {
    private Config config = new Config();
    private static List<Company> companies;

    public CompanyImplementation() throws SQLException {
    }


    @Override
    public List<Company> getAllCompany() {
        String query = "SELECT * FROM  COMPANY";
        companies = null;
        try (Connection conn = config.getConnection();
             Statement stm = conn.createStatement();
             ResultSet rst = stm.executeQuery(query)
        ) {

            if (companies == null) {
                companies = new ArrayList<Company>();
                while (rst.next()) {
                    Company company = new Company();
                    company.setName(rst.getString("company_name"));
                    company.setEmail(rst.getString("company_email"));
                    company.setDonation(rst.getInt("company_donation"));
                    company.setPhoto(rst.getString("company_link"));
                    company.setId(rst.getInt("company_id"));
                    company.setShow(rst.getInt("company_show"));
                    company.setPunctuation(rst.getInt("company_punctuation"));
                    company.setUserId(rst.getInt("user_id"));
                    companies.add(company);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return companies;
    }

    @Override
    public List<Company> getCompanyByEmail(String email) {
        String query = "SELECT * FROM COMPANY";
        companies = null;
        try(Connection conn = config.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rst = stm.executeQuery(query);
        ) {

            if (companies == null) {
                companies = new ArrayList<Company>();
                while (rst.next()) {
                    Company company = new Company();
                    if (email.equals(rst.getString("company_email"))) {
                        company.setUserId(rst.getInt("user_id"));
                        company.setDonation(rst.getInt("company_donation"));
                        company.setId(rst.getInt("company_id"));
                        company.setName(rst.getString("company_name"));
                        company.setPhoto(rst.getString("company_link"));
                        company.setPunctuation(rst.getInt("company_punctuation"));
                        company.setShow(rst.getInt("company_show"));
                        company.setEmail(rst.getString("company_email"));
                        companies.add(company);

                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return companies;
    }

    @Override
    public void insertCompany(Company company) {
        String query = "INSERT INTO COMPANY (company_name,company_donation,company_link,company_email,company_punctuation,company_show,user_id) VALUES(?,?,?,?,?,?,?)";
        try(Connection conn = config.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
        ) {

            ps.setString(1, company.getName());
            ps.setInt(2, company.getDonation());
            ps.setString(3, company.getPhoto());
            ps.setString(4, company.getEmail());
            ps.setInt(5, company.getPunctuation());
            ps.setInt(6, company.getShow());
            ps.setInt(7, company.getUserId());
            ps.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editCompany(Company company, Integer id) {
        String query = "UPDATE company SET company_name=?,company_email=?,company_link=?,company_donation=?,company_punctuation=?,company_show=? WHERE user_id=? AND company_id=?";
        try(Connection conn = config.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
        ) {

            ps.setString(1, company.getName());
            ps.setString(2, company.getEmail());
            ps.setString(3, company.getPhoto());
            ps.setInt(4, company.getDonation());
            ps.setInt(5, company.getPunctuation());
            ps.setInt(6, company.getShow());
            ps.setInt(7, company.getUserId());
            ps.setInt(8, id);
            ps.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCompany(Integer id) {
        String query = "DELETE FROM company WHERE company_id=?";
        try(Connection conn = config.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
        ) {
            ps.setInt(1, id);
            ps.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}

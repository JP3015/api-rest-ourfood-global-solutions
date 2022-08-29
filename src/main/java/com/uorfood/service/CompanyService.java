package com.uorfood.service;

import com.uorfood.dao.implementation.CompanyImplementation;
import com.uorfood.ddd.Company;

import java.sql.SQLException;
import java.util.List;

public class CompanyService {
    private CompanyImplementation companyDao = new CompanyImplementation();

    public CompanyService() throws SQLException {
    }

    public List<Company> getALlCompany() {
        return companyDao.getAllCompany();
    }

    public List<Company> getCompanyByEmail(String email) {
        return companyDao.getCompanyByEmail(email);
    }

    public void insertCompany(Company company) {
        companyDao.insertCompany(company);
    }

    public void editCompany(Company company, Integer id) {
        companyDao.editCompany(company, id);
    }

    public void deleteCompany(Integer id) {
        companyDao.deleteCompany(id);
    }
}

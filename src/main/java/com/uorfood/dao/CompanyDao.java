package com.uorfood.dao;

import com.uorfood.ddd.Company;

import java.util.List;

public interface CompanyDao {
    /*@return  Todos as empresas */
    List<Company> getAllCompany();
    /*@return  Todos os usuários pelo seu  email
     * @param   Recebe um email como parâmetro, sera usado para comparar com a lista atual
     * e  retornar apenas os valores que faz verdadeiro a condição
     * */
    List<Company> getCompanyByEmail(String email);

    void insertCompany(Company company);

    void editCompany(Company company,Integer id);

    void deleteCompany(Integer id);


}

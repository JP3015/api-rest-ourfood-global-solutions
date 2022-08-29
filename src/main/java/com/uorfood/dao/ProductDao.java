package com.uorfood.dao;

import com.uorfood.ddd.Products;

import java.util.List;

public interface ProductDao {
    /*@return  Todos os dados referentes produtos*/
    List<Products> getAllProduct();
    /*@param   Valor recebido sera usado para povoar nosso List<Products> */
    void insertProduct(Products products);

}

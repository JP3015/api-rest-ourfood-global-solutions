package com.uorfood.dao;

import com.uorfood.ddd.Users;

import java.util.List;

public interface UserDao {
    /*@return  Todos os usuários */
    List<Users> getUsersAll();
    /*@return  Todos os usuários pelo seu identificador único
     * @param   Recebe um identificador único como parâmetro, sera usado para comparar com a lista atual
     * e  retornar apenas os valores que faz verdadeiro a condição
    * */
    List<Users> getUserById(Integer id);
    /*@return Todos os usuários pelo seu email
     * @param Recebe email como parâmetro, sera usado para comparar com a lista atual
     * e  retornar apenas os valores que faz verdadeiro a condição
    * */
    List<Users> getUserByEmail(String email);

    /*@param  Valor recebido sera para povoar nosso List<User> */
    void insertUsers(Users users);

    void editUsers(Users users,Integer id);

    void deleteUser(Integer id);

}

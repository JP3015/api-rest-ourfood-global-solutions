package com.uorfood.dao;

import com.uorfood.ddd.Reward;

import java.util.List;

public interface RewardDao {
    /*@return  Todos os dados referente as recompensas */
    List<Reward> getAllReward();
    /*@parm  Parâmetro recebido sera usado para povoar nosso  List<Reward> */
    void insertReward(Reward reward);

}

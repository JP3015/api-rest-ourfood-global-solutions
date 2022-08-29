package com.uorfood.service;

import com.uorfood.dao.implementation.RewardImplementation;
import com.uorfood.ddd.Reward;

import java.sql.SQLException;
import java.util.List;

public class RewardService {
    private RewardImplementation rewardDao = new RewardImplementation();

    public RewardService() throws SQLException {
    }

    public List<Reward> getAllReward() {
        return rewardDao.getAllReward();
    }

    public void insertReward(Reward reward) {
        rewardDao.insertReward(reward);
    }

}

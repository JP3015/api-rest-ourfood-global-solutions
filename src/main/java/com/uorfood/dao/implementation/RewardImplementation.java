package com.uorfood.dao.implementation;

import com.uorfood.Config;
import com.uorfood.dao.RewardDao;
import com.uorfood.ddd.Reward;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RewardImplementation implements RewardDao {
    private Config config = new Config();


    private static List<Reward> rewards;


    public RewardImplementation() throws SQLException {
    }


    @Override
    public List<Reward> getAllReward() {
        String query = "SELECT * FROM REWARDS";
        rewards = null;
        try (Connection coon = config.getConnection();
             Statement stm = coon.createStatement();
             ResultSet rest = stm.executeQuery(query);
        ) {

            if (rewards == null) {
                rewards = new ArrayList<Reward>();
                while (rest.next()) {
                    Reward reward = new Reward();
                    reward.setId(rest.getInt("reward_id"));
                    reward.setPhoto(rest.getString("reward_link"));
                    reward.setUserId(rest.getInt("user_id"));
                    reward.setTitle(rest.getString("reward_name"));
                    rewards.add(reward);
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rewards;
    }

    @Override
    public void insertReward(Reward reward) {
        String query = "INSERT INTO REWARDS(reward_name,reward_link,user_id) VALUES(?,?,?)";
        try(Connection coon = config.getConnection();
            PreparedStatement ps = coon.prepareStatement(query);
        ) {

            ps.setString(1, reward.getTitle());
            ps.setString(2, reward.getPhoto());
            ps.setInt(3, reward.getUserId());
            ps.executeQuery();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

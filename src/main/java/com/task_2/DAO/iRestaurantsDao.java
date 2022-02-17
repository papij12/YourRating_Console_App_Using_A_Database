package com.task_2.DAO;

import entity.Restaurants;

import java.util.List;

public interface iRestaurantsDao {
    void setRestaurants();

    void updateRestaurantsById();

    void getRestaurant();

    void deleteRestaurantsById();
}

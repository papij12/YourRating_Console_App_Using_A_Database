package com.task_2.DAO;

import entity.Restaurants;

import entity.Takeaway;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class RestaurantsDao implements iRestaurantsDao {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();



    @Override
    public void setRestaurants(){
        try{
            transaction.begin();
            Restaurants aresturants = new Restaurants();
            aresturants.setName("Test1 rest");
            aresturants.setRating(4);
            aresturants.setUserId(1);
            entityManager.persist(aresturants);
            transaction.commit();

        }
        finally {
            if (transaction.isActive()){
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();

        }


    }

    @Override
    public void updateRestaurantsById() {
        try {
            transaction.begin();
            Restaurants aresturants;
            Integer key = Integer.valueOf(12);
            aresturants = entityManager.find(Restaurants.class, key);
            aresturants.setRating(1);
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();

        }
    }

    @Override
    public void getRestaurant(){

        try{
            transaction.begin();
            Restaurants aresturants;
            Integer key = Integer.valueOf(2);
            aresturants = entityManager.find(Restaurants.class, key);
        System.out.println("id:"+aresturants.getrId()+"\n"+"Name"+aresturants.getName()+"\n"+"Rating"+aresturants.getRating()+"\n"+"User_Id"+aresturants.getUserId());
            transaction.commit();
        }
        finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();

        }

    }

    @Override
    public void deleteRestaurantsById(){
        try{
            transaction.begin();
            Restaurants aresturants;
            Integer key = Integer.valueOf(12);
            aresturants = entityManager.find(Restaurants.class, key);
          entityManager.remove(aresturants);
            transaction.commit();
        }
        finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();

        }

    }

}

package com.task_2.DAO;


import entity.Takeaway;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TakeAwayDao implements iTakeAwayDao {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();



    @Override
    public void setTakeaway(){
        try{
            transaction.begin();
            Takeaway atakeaway= new Takeaway();
            atakeaway.setName("Testxy takeaway");
            atakeaway.setRating(4);
            atakeaway.setUserId(1);
            entityManager.persist(atakeaway);
            transaction.commit();

        }
        finally {
            if (transaction.isActive()){
                transaction.rollback();
                Takeaway atakeaway= new Takeaway();
            }
            entityManager.close();
            entityManagerFactory.close();

        }


    }
    @Override
    public void updateTakeawayById() {
        try {
            transaction.begin();
            Takeaway atakeaway;
            Integer key = Integer.valueOf(3);
            atakeaway = entityManager.find(Takeaway.class, key);
            atakeaway.setRating(1);
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
    public void getTakeaway(){

        try{
            transaction.begin();
            Takeaway atakeaway;
            Integer key = Integer.valueOf(3);
            atakeaway = entityManager.find(Takeaway.class, key);
            System.out.println("id:"+atakeaway.gettId()+"\n"+"Name:"+atakeaway.getName()+"\n"+"Rating:"+atakeaway.getRating()+"\n"+"User_ID:"+atakeaway.getUserId());

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
    public void deleteTakeawayById(){
        try{
            transaction.begin();
            Takeaway atakeaway;
            Integer key = Integer.valueOf(3);
            atakeaway = entityManager.find(Takeaway.class, key);
            entityManager.remove(atakeaway);
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

package com.task_2;

import entity.Restaurants;
import entity.Takeaway;
import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.sql.ResultSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        System.out.println("Welcome to MyRating application");
        System.out.println("1.Takeaway\n2.Restaurants\n");
        Scanner input = new Scanner(System.in);
        int option = input.nextInt();
        switch(option) {
            case 1:
                try{
                    transaction.begin();

                    transaction.commit();
                }
                finally {
                    if (transaction.isActive()){
                        transaction.rollback();
                    }
                    entityManager.close();
                    entityManagerFactory.close();

                }
                break;
            case 2:
                try{
                    transaction.begin();
                    Restaurants aresturants = new Restaurants();
                    aresturants.setName("Test restaurant");
                    aresturants.setRating(5);
                    aresturants.setUserId(4);
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
                break;
            default:
                System.out.println("wrong Input");
        }

    }
}

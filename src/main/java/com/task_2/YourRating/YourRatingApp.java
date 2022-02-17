package com.task_2.YourRating;

import com.task_2.DAO.RestaurantsDao;
import com.task_2.DAO.TakeAwayDao;
import entity.Restaurants;
import entity.Takeaway;

import java.util.List;
import java.util.Scanner;

public class YourRatingApp {

    public static void main(String[] args) {
        RestaurantsDao restaurantsDao = new RestaurantsDao();
        TakeAwayDao takeAwayDao = new TakeAwayDao();
        System.out.println("Welcome to MyRating application");
        System.out.println("1.Restaurants\n2.Takeaway\n");
        Scanner input = new Scanner(System.in);
        int option = input.nextInt();
        switch(option) {
            case 1:
                System.out.println("Available choices");
                System.out.println("1.create\n2.Update\n3.Get\n4.Delete\n");
                Scanner choice = new Scanner(System.in);
                int x = choice.nextInt();
                switch(x) {
                    case 1:
                        // set restaurants
                        restaurantsDao.setRestaurants();
                        break;
                    case 2:
                        // updated restaurants
                        restaurantsDao.updateRestaurantsById();
                        break;
                    case 3:

                        // getAll restaurants
                        restaurantsDao.getRestaurant();

                        break;
                    case 4:

                        // delete restaurants
                        restaurantsDao.deleteRestaurantsById();

                        break;
                    default:
                        System.out.println("wrong Input");
                }

            case 2:
                System.out.println("Available choices");
                System.out.println("1.create\n2.Update\n3.Get\n4.Delete\n");
                Scanner choice1 = new Scanner(System.in);
                int y = choice1.nextInt();
                switch(y) {
                    case 1:
                        // set restaurants
                       takeAwayDao.setTakeaway();
                        break;
                    case 2:
                        // updated restaurants
                     takeAwayDao.updateTakeawayById();
                        break;
                    case 3:

                        // get restaurants
                      takeAwayDao.getTakeaway();

                        break;
                    case 4:

                        // delete restaurants
                        takeAwayDao.deleteTakeawayById();

                        break;
                    default:
                        System.out.println("wrong Input");
                }

                break;
            default:
                System.out.println("wrong Input");
        }

    }
}

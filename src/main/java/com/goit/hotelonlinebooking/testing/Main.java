package com.goit.hotelonlinebooking.testing;

import com.goit.hotelonlinebooking.controller.Controller;
import com.goit.hotelonlinebooking.entity.Hotel;
import com.goit.hotelonlinebooking.entity.Room;
import com.goit.hotelonlinebooking.entity.User;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Controller controller = new Controller();
        //User registration and creation of a list of users
        controller.userRegistration(new User(001, "Ivan", "Ivanov", 24, "ivanov@i.ua", "0679656343", "qwerty"));
        controller.userRegistration(new User(002, "Petr", "Petrov", 27, "petrov@i.ua", "0689871234", "123"));
        controller.userRegistration(new User(003, "Ivan", "Sidorov", 32, "sidorov@i.ua", "0978763434", "987"));

        //authorize a user
        controller.login(01);

        //search for hotels by city
        controller.findHotelByCity("Kiev");

        //search for hotels by name hotel
        for (Hotel h : controller.findHotelByHotelName("Hayat")) {
            System.out.println(h);
        }
        System.out.println();

        //output display list of free rooms by hotel
        for (Room r : controller.getFreeRoomsByHotel("Hayat")) {
            System.out.println(r);
        }

        //booking a hotel by id
        controller.bookRoom(2, 2, 1);
        controller.bookRoom(1, 2, 1);
        controller.bookRoom(3, 2, 1);
        controller.bookRoom(4, 2, 1);
        System.out.println();

        for (Room r : controller.getFreeRoomsByHotel("Hayat")) {
            System.out.println(r);
        }
        System.out.println();

        //Cancel Reservation
        controller.cancelReservation(4, 1);

        for (Room r : controller.getFreeRoomsByHotel("Hayat")) {
            System.out.println(r);
        }
        System.out.println();

        //Search rooms for their parameters
        Map<String, String> paramRoom = new HashMap<>();
        paramRoom.put("price", "200");
        paramRoom.put("floor", "2");
        paramRoom.put("capacity", "2");
        for (Object r : controller.findRoom(paramRoom)) {
            System.out.println(r);
        }
    }
}

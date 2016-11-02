package com.goit.hotelonlinebooking.controller;

import com.goit.hotelonlinebooking.dao.AbstractDAO;
import com.goit.hotelonlinebooking.dao.ById;
import com.goit.hotelonlinebooking.dao.HotelDAO;
import com.goit.hotelonlinebooking.dao.UserDAO;
import com.goit.hotelonlinebooking.entity.Hotel;
import com.goit.hotelonlinebooking.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {


    public void userRegistration(User user) {

        if (new UserDAO().checkRegistration(user)) {
            new UserDAO().save(user);
            System.out.println("User successfully added to the database");
        }

    }

    public List<Hotel> findHotelByHotelName(String hotelName) {

        List<Hotel> hotelList = new HotelDAO().getList().stream()
                .filter(n -> hotelName.equals(n.getHotelName()))
                .collect(Collectors.toList());

        if (hotelList.size() != 0) return hotelList;
        else {
            System.out.println("user with that Name is not found");
            return hotelList;
        }

    }

    public List<Hotel> findHotelByCity(String hotelCity) {

        List<Hotel> hotelList = new HotelDAO().getList().stream()
                .filter(n -> hotelCity.equals(n.getCityName()))
                .collect(Collectors.toList());

        if (hotelList.size() != 0) return hotelList;
        else {
            System.out.println("user with that Name is not found");
            return hotelList;
        }
    }

}

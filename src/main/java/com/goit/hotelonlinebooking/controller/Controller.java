package com.goit.hotelonlinebooking.controller;

import com.goit.hotelonlinebooking.dao.*;
import com.goit.hotelonlinebooking.entity.Hotel;
import com.goit.hotelonlinebooking.entity.Room;
import com.goit.hotelonlinebooking.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {


    public void userRegistration(User user) {

        if (new UserDAO().checkRegistration(user)) {
            new UserDAO().save(user);
            System.out.println("User "+ user.getName() +" "+user.getLastName()+ " successfully added to the database");
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

    public static void main(String[] args) {

        //HotelDAO hotelDAO = new HotelDAO();
        RoomDAO roomDAO = new RoomDAO();

        Controller controller = new Controller();

        controller.userRegistration(new User("Vladimir", "Mischenko", 37, "usonictw@bigmir.net", "0937354341", "123"));
        controller.userRegistration(new User("Ivan", "Ivanov", 16, "ivanov@bigmir.net", "0957344444", "123"));

       // controller.findHotelByCity("Kiev");

        for (Room r : roomDAO.getList()){
            System.out.println(r);
        }

    }

}

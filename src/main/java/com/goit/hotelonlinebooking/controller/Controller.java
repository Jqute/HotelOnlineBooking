package com.goit.hotelonlinebooking.controller;

import com.goit.hotelonlinebooking.dao.*;
import com.goit.hotelonlinebooking.entity.Hotel;
import com.goit.hotelonlinebooking.entity.Room;
import com.goit.hotelonlinebooking.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
            System.out.println("Hotel " + hotelName + " is not found");
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

    public List<Hotel> findRoom(Map<String, String> params) {
        List<Hotel> workingDB = new ArrayList<>(new HotelDAO().getList());

        for (Map.Entry<String, String> entry : params.entrySet()) {
            String fieldName = entry.getKey();
            String fieldValue = entry.getValue();

            switch (fieldName) {
                case "hotelName":
                    workingDB = workingDB.stream()
                            .filter(x -> x.getHotelName().equals(fieldValue))
                            .collect(Collectors.toList());
                    break;

                case "cityName":
                    workingDB = workingDB.stream()
                            .filter(x -> x.getCityName().equals(fieldValue))
                            .collect(Collectors.toList());
                    break;

                case "address":
                    workingDB = workingDB.stream()
                            .filter(x -> x.getAddress().equals(fieldValue))
                            .collect(Collectors.toList());
                    break;

                case "rating":
                    workingDB = workingDB.stream()
                            .filter(x -> x.getRating() == Integer.valueOf(fieldValue))
                            .collect(Collectors.toList());
                    break;

                case "price":

                    workingDB = workingDB.stream().filter(hotel -> {
                        List<Room> list = hotel.getRooms();
                        list = list.stream()
                                .filter(x -> x.getPrice() == Integer.valueOf(fieldValue))
                                .collect(Collectors.toList());
                        long foundEntries = list.size();

                        if (foundEntries == 0) {
                            return false;
                        } else {
                            hotel.setRooms(list);
                            return true;
                        }
                    }).collect(Collectors.toList());
                    break;

                case "capacity":
                    workingDB = workingDB.stream().filter(hotel -> {
                        List<Room> list = hotel.getRooms();
                        list = list.stream()
                                .filter(x -> x.getCapacity() == Integer.valueOf(fieldValue))
                                .collect(Collectors.toList());
                        long foundEntries = list.size();

                        if (foundEntries == 0) {
                            return false;
                        } else {
                            hotel.setRooms(list);
                            return true;
                        }
                    }).collect(Collectors.toList());
                    break;

                default:
                    System.out.println("Parameter \'" + fieldName + "\' given to method FindRoom() is wrong. Interrupted");
                    return null;
            }
        }
        return workingDB;
    }

    public static void main(String[] args) {

        //HotelDAO hotelDAO = new HotelDAO();
        RoomDAO roomDAO = new RoomDAO();

        Controller controller = new Controller();

        controller.userRegistration(new User("Vladimir", "Mischenko", 35, "usonictw@bigmir.net", "0937354341", "123"));
        controller.userRegistration(new User("Ivan", "Ivanov", 16, "ivanov@bigmir.net", "0957344444", "123"));

        for (Hotel h : controller.findHotelByCity("Kiev")){
            System.out.println(h);
        }







    }

}

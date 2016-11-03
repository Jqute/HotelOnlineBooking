package com.goit.hotelonlinebooking.controller;

import com.goit.hotelonlinebooking.dao.*;
import com.goit.hotelonlinebooking.entity.Hotel;
import com.goit.hotelonlinebooking.entity.Room;
import com.goit.hotelonlinebooking.entity.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Controller {

    private RoomDAO roomDAO = new RoomDAO();
    private HotelDAO hotelDAO = new HotelDAO();
    private UserDAO userDAO = new UserDAO();


    public void userRegistration(User user) {

        if (userDAO.checkRegistration(user)) {
            userDAO.save(user);
            System.out.println("User " + user.getName() + " " + user.getLastName() + " successfully registered");
        }

    }

    public List<Hotel> findHotelByHotelName(String hotelName) {

        List<Hotel> hotelList = hotelDAO.getList().stream()
                .filter(n -> hotelName.equals(n.getHotelName()))
                .collect(Collectors.toList());


        if (hotelList.size() != 0) return hotelList;
        else {
            System.out.println("Hotel " + hotelName + " is not found");
            return hotelList;
        }

    }


    public List<Hotel> findHotelByCity(String hotelCity) {

        List<Hotel> hotelList = hotelDAO.getList().stream()
                .filter(n -> hotelCity.equals(n.getCityName()))
                .collect(Collectors.toList());

        if (hotelList.size() != 0) return hotelList;
        else {
            System.out.println("user with that Name is not found");
            return hotelList;
        }
    }


    public List<Room> getFreeRoomsbyHotel (String nameHotel) {

        List<Room> list = new ArrayList<>();
        Iterator<Hotel> iterator = hotelDAO.getList().iterator();

        int countHotel = 1;
        while (iterator.hasNext()) {

            Hotel h = iterator.next();

            if (h.getHotelName().equals(nameHotel)) {
                System.out.println("The hotel " + nameHotel + "#" + countHotel + " has the following rooms available:");
                countHotel++;
                list = h.getRooms().stream()
                        .filter(r -> r.getUserReserved() == null)
                        .collect(Collectors.toList());

            }
        }

        if(countHotel == 1) System.out.println("Hotel with a name " + nameHotel + " not found");
        return list;
    }

    void bookRoom(int roomId, int userId, int hotelId) {
        //Hotel foundHotel = hotelDAO.findHotelByID(hotelId);
        Hotel foundHotel = hotelDAO.objectById(hotelId);
        if (foundHotel != null) {

            Room foundRoom;
            List<Room> listFoundRooms = foundHotel.getRooms().stream()
                    .filter(room -> room.getId() == roomId)
                    .collect(Collectors.toList());
            if (listFoundRooms.size() == 0 || listFoundRooms.size() >= 2) {
                System.out.println("Error. With room ID: " + roomId + " found more that 1 room...");
                foundRoom = null;
            } else foundRoom = listFoundRooms.get(0);

            if (foundRoom != null) {
                UserDAO userDB = userDAO;
                User foundUser = userDB.objectById(userId);
                if (foundUser != null) {
                    foundRoom.setUserReserved(foundUser);
                }
            }

        } else
            System.out.println("Sorry, hotel not found");
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

        HotelDAO hotelDAO = new HotelDAO();


        Controller controller = new Controller();

        controller.userRegistration(new User(01, "Vladimir", "Mischenko", 35, "usonictw@bigmir.net", "0937354341", "123"));
        controller.userRegistration(new User(02, "Ivan", "Ivanov", 16, "ivanov@bigmir.net", "0957344444", "123"));

        for (Hotel h : controller.findHotelByCity("Kiev")) {
            System.out.println(h);
        }

        System.out.println();

        for (Room r : controller.getFreeRoomsbyHotel("Hayat")){
            System.out.println(r);
        }

        controller.bookRoom(2, 01, 1);
        System.out.println();


        for (Room r : controller.getFreeRoomsbyHotel("Hayat")){
            System.out.println(r);
        }




    }

}

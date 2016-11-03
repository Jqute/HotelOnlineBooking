package com.goit.hotelonlinebooking.dao;

import com.goit.hotelonlinebooking.entity.Hotel;
import com.goit.hotelonlinebooking.entity.Room;
import com.goit.hotelonlinebooking.entity.User;

import java.util.*;
import java.util.stream.Collectors;


public class HotelDAO extends AbstractDAO<Hotel> {


    public HotelDAO() {
        hotelFactory();

    }


    private void hotelFactory() {

        save(new Hotel(new Random().nextInt(1000), "Radisson Podil", "Kiev",
                "Kiev, Podil", "radisson@ukr.net", 5, roomFactory(4)));
        save(new Hotel(1, "Hayat", "Kiev",
                "Kiev, Center", "hayat@ukr.net", 5, roomFactory(5)));
        save(new Hotel(new Random().nextInt(1000), "Bratislava", "Kiev",
                "Kiev, Darnitsa", "bratislava@ukr.net", 4, roomFactory(6)));
        save(new Hotel(new Random().nextInt(1000), "Gendel", "Rostov",
                "Rostov, DownTown", "gendel@mail.ru", 3, roomFactory(1)));
        save(new Hotel(new Random().nextInt(1000), "Radisson Alushta", "Alushta",
                "Alushta beach", "radissonalushta@ukr.net", 5, roomFactory(5)));
        save(new Hotel(new Random().nextInt(1000), "HOTEL-ka", "Moscow",
                "Moscow, Kremlin", "hotelka@rambler.ru", 4, roomFactory(5)));
        save(new Hotel(new Random().nextInt(1000), "Big Ben Hotel", "London",
                "Pasadena Str 7", "bb@london.uk", 5, roomFactory(4)));
        save(new Hotel(new Random().nextInt(1000), "Svitanok", "Zhitomir",
                "Zhitomir, Pavlova 5", "Svitanok@ukr.net", 4, roomFactory(5)));
        save(new Hotel(new Random().nextInt(1000), "Hertz Hotel", "Berlin",
                "Berlin, AntaresPlatz", "Hertz@nsdap.de", 5, roomFactory(6)));
        save(new Hotel(new Random().nextInt(1000), "Japoshka", "Tokio",
                "Tokio, Arigato Str", "arigato@.ucoz.ru", 5, roomFactory(4)));
    }

    public Hotel findHotelByID(int hotelID) {
        List<Hotel> foundHotels = getList().stream()
                .filter(hotel -> hotel.getId() == hotelID).collect(Collectors.toList());
        if (foundHotels.size() == 0 || foundHotels.size() >= 2) {
            System.out.println("Error. With hotel ID: " + hotelID + " found more that 1 hotel...");
            return null;
        } else return foundHotels.get(0);
    }

    private List<Room> roomFactory(int numberOfRooms) {     //return Rooms to some Hotel
        List<Room> DBRoom = new RoomDAO().getList();  ///maybe static???!!!!
        List<Room> fillingList = new ArrayList<>();
        if (DBRoom != null) {

            int roomDBSize = DBRoom.size();
            if (numberOfRooms > 0 && numberOfRooms <= roomDBSize) {
                for (int i = 0; i < numberOfRooms; i++)
                    fillingList.add(i, DBRoom.get(i));
            } else if (numberOfRooms > roomDBSize) {
                for (int i = 0; i < roomDBSize; i++)
                    fillingList.add(i, DBRoom.get(i));
            }
        } else {
            System.out.println("Sorry, Room's DB unavailable");
            return null;
        }
        return fillingList;

//        List<List<Room>> roomPackage = new ArrayList<>();
//        List<Room> listOne = new ArrayList<>();
//        listOne.add(new Room(new Random().nextLong(), 1_000, 1, 2, null));
//        listOne.add(new Room(new Random().nextLong(), 15_000, 1, 2, null));
//        listOne.add(new Room(new Random().nextLong(), 11_000, 1, 1, null));
//        listOne.add(new Room(new Random().nextLong(), 6_000, 1, 2, null));
//        listOne.add(new Room(new Random().nextLong(), 7_000, 1, 2, null));
//        listOne.add(new Room(new Random().nextLong(), 2_000, 1, 2, null));
//        listOne.add(new Room(new Random().nextLong(), 3_000, 1, 2, null));
//        listOne.add(new Room(new Random().nextLong(), 2_000, 1, 1, null));
//        listOne.add(new Room(new Random().nextLong(), 2_500, 1, 2, null));
//        listOne.add(new Room(new Random().nextLong(), 77_000, 1, 2, null));
//
//        List<Room> listTwo = new ArrayList<>();
//        listTwo.add(new Room(new Random().nextLong(), 17_000, 1, 2, null));
//        listTwo.add(new Room(new Random().nextLong(), 2_000, 1, 1, null));
//        listTwo.add(new Room(new Random().nextLong(), 1_632, 1, 2, null));
//        listTwo.add(new Room(new Random().nextLong(), 1_600, 1, 2, null));
//        listTwo.add(new Room(new Random().nextLong(), 5_000, 1, 2, null));
//        listTwo.add(new Room(new Random().nextLong(), 7_000, 1, 2, null));
//        listTwo.add(new Room(new Random().nextLong(), 11_000, 2, 2, null));
//        listTwo.add(new Room(new Random().nextLong(), 1_500, 1, 2, null));
//        listTwo.add(new Room(new Random().nextLong(), 2_000, 1, 1, null));
//        listTwo.add(new Room(new Random().nextLong(), 6_000, 1, 2, null));
//
//        List<Room> listThree = new ArrayList<>();
//        listThree.add(new Room(new Random().nextLong(), 12_000, 1, 2, null));
//        listThree.add(new Room(new Random().nextLong(), 5_452, 1, 2, null));
//        listThree.add(new Room(new Random().nextLong(), 3_632, 1, 2, null));
//        listThree.add(new Room(new Random().nextLong(), 2_000, 1, 2, null));
//        listThree.add(new Room(new Random().nextLong(), 5_000, 1, 2, null));
//        listThree.add(new Room(new Random().nextLong(), 5_000, 1, 2, null));
//        listThree.add(new Room(new Random().nextLong(), 11_000, 1, 1, null));
//        listThree.add(new Room(new Random().nextLong(), 2_000, 1, 2, null));
//        listThree.add(new Room(new Random().nextLong(), 5_500, 1, 2, null));
//        listThree.add(new Room(new Random().nextLong(), 7_000, 1, 2, null));
//
//        roomPackage.add(listOne);
//        roomPackage.add(listTwo);
//        roomPackage.add(listThree);
//
//        return roomPackage.get(new Random().nextInt(roomPackage.size()));


    }

    public List<Hotel> findHotelByHotelName(String hotelName) {

        return getList().stream()
                .filter(n -> hotelName.equals(n.getHotelName()))
                .collect(Collectors.toList());
    }

    public List<Hotel> findHotelByCity(String hotelCity) {
        return getList().stream()
                .filter(n -> hotelCity.equals(n.getCityName()))
                .collect(Collectors.toList());
    }


    public List<Hotel> findRoom(Map<String, String> params) {
        List<Hotel> workingDB = new ArrayList<>();
        workingDB.addAll(getList());
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

    void bookRoom(long roomId, long userId, int hotelId) {
        //Hotel foundHotel = findHotelByID(hotelId);
        Hotel foundHotel = objectById(hotelId);
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
                UserDAO userDB = new UserDAO();
                User foundUser = userDB.objectById(userId);
                if (foundUser != null) {
                    foundRoom.setUserReserved(foundUser);
                }
            }

        } else
            System.out.println("Sorry, hotel not found");
    }

    void cancelReservation(long roomId, long userId, int hotelId) {
        Hotel foundHotel = findHotelByID(hotelId);
        //Hotel foundHotel = objectById(hotelId);
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
                if (foundRoom.getUserReserved() != null) {
                    foundRoom.setUserReserved(null);
                }
            }
        } else
            System.out.println("Sorry, hotel not found");
    }


}

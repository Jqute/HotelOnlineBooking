package com.goit.hotelonlinebooking.dao;

import com.goit.hotelonlinebooking.entity.Hotel;
import com.goit.hotelonlinebooking.entity.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;


public class HotelDAO extends AbstractDAO<Hotel> {

    public HotelDAO() {
        HotelFactory();
    }

    private void HotelFactory() {
        save(new Hotel(new Random().nextInt(), "Radisson Podil", "Kiev",
                "Kiev, Podil", "radisson@ukr.net", 5, roomFactory(4)));
        save(new Hotel(new Random().nextInt(), "Hayat", "Kiev",
                "Kiev, Center", "hayat@ukr.net", 5, roomFactory(5)));
        save(new Hotel(new Random().nextInt(), "Bratislava", "Kiev",
                "Kiev, Darnitsa", "bratislava@ukr.net", 4, roomFactory(6)));
        save(new Hotel(new Random().nextInt(), "Gendel", "Rostov",
                "Rostov, DownTown", "gendel@mail.ru", 3, roomFactory(1)));
        save(new Hotel(new Random().nextInt(), "Radisson Alushta", "Alushta",
                "Alushta beach", "radissonalushta@ukr.net", 5, roomFactory(5)));
        save(new Hotel(new Random().nextInt(), "HOTEL-ka", "Moscow",
                "Moscow, Kremlin", "hotelka@rambler.ru", 4, roomFactory(5)));
        save(new Hotel(new Random().nextInt(), "Big Ben Hotel", "London",
                "Pasadena Str 7", "bb@london.uk", 5, roomFactory(4)));
        save(new Hotel(new Random().nextInt(), "Svitanok", "Zhitomir",
                "Zhitomir, Pavlova 5", "Svitanok@ukr.net", 4, roomFactory(5)));
        save(new Hotel(new Random().nextInt(), "Hertz Hotel", "Berlin",
                "Berlin, AntaresPlatz", "Hertz@nsdap.de", 5, roomFactory(6)));
        save(new Hotel(new Random().nextInt(), "Japoshka", "Tokio",
                "Tokio, Arigato Str", "arigato@.ucoz.ru", 5, roomFactory(4)));
    }

    private List<Room> roomFactory(int numberOfRooms) {     //return Rooms to some Hotel
        List<Room> dBList = new RoomDAO().getList();  ///maybe static???!!!!
        List<Room> initList = new ArrayList<>();
        int roomDBSize=initList.size();
        if (numberOfRooms>0 && numberOfRooms<=roomDBSize) {
            dBList.add(initList.get(new Random().nextInt(roomDBSize)));
        } else {
            System.out.println("Wrong number of rooms");
        }

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
        return dBList;

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
}

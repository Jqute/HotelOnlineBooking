package com.goit.hotelonlinebooking.dao;

import com.goit.hotelonlinebooking.entity.Hotel;
import com.goit.hotelonlinebooking.entity.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


public class HotelDAO extends AbstractDAO<Hotel> {

    public HotelDAO() {
        hotelFactory();
    }

    private void hotelFactory() {

        save(new Hotel(new Random().nextInt(1000), "Radisson Podil", "Kiev",
                "Kiev, Podil", "radisson@ukr.net", 5, roomFactory(10)));
        save(new Hotel(1, "Hayat", "Kiev",
                "Kiev, Center", "hayat@ukr.net", 5, roomFactory(10)));
        save(new Hotel(new Random().nextInt(1000), "Bratislava", "Dnepr",
                "Dnepr, Truda", "bratislava@ukr.net", 4, roomFactory(10)));
        save(new Hotel(new Random().nextInt(1000), "Gendel", "Dnepr",
                "Dnepr, DownTown", "gendel@gmail.com", 3, roomFactory(10)));
        save(new Hotel(new Random().nextInt(1000), "Radisson Alushta", "Alushta",
                "Alushta beach", "radissonalushta@ukr.net", 5, roomFactory(10)));
        save(new Hotel(new Random().nextInt(1000), "HOTEL-ka", "Alushta",
                "Alushta, center", "hotelka@rambler.ru", 4, roomFactory(10)));

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
        List<Room> DBRoom = generateRooms(false);  ///maybe static???!!!! false - static, true - automatic
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

    }
    private  List<Room> generateRooms(boolean auto){
        List<Room> roomList = new ArrayList<>();
        if (auto)
        {
            Random random = new Random();
            roomList.add(new Room(Math.abs(random.nextInt()),100,1,1,null));
            roomList.add(new Room(Math.abs(random.nextInt()),200,1,2,null));
            roomList.add(new Room(Math.abs(random.nextInt()),300,1,3,null));
            roomList.add(new Room(Math.abs(random.nextInt()),100,2,1,null));
            roomList.add(new Room(Math.abs(random.nextInt()),400,2,4,null));
            roomList.add(new Room(Math.abs(random.nextInt()),200,3,2,null));
            roomList.add(new Room(Math.abs(random.nextInt()),300,3,3,null));
            roomList.add(new Room(Math.abs(random.nextInt()),400,4,4,null));
            roomList.add(new Room(Math.abs(random.nextInt()),400,4,4,null));
        }
        else {

            Random random = new Random();
            int countOfFloor = 4;
            int maxPrice = 5;
            int minPrice = 0;
            int index = Math.abs(random.nextInt());
            for (int i = 1; i <= countOfFloor; i++) {
                for (int k = 1; k <= 5; k++) {
                    int capacity = 1 + (Math.abs(random.nextInt()) * ((4 - 1) + 1));
                    int price = (minPrice * capacity + (Math.abs(random.nextInt()) * ((maxPrice * capacity - minPrice * capacity) + 1))) * 100;
                    index++;
                    roomList.add(new Room(index, price, i, capacity, null));
                }
            }
        }
        return roomList;
    }

    public List<Room> getAllRoom(){
        List<Room> roomList = new ArrayList<>();
        for(int i = 0; i > getList().size(); i++)
        roomList.addAll(getList().get(i).getRooms());
        return roomList;
    }
}

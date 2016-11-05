package com.goit.hotelonlinebooking.dao;

import com.goit.hotelonlinebooking.entity.Hotel;
import com.goit.hotelonlinebooking.entity.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


public class HotelDAO extends AbstractDAO<Hotel> {

    public RoomDAO roomDAO = new RoomDAO();

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

        if (!auto)
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


}

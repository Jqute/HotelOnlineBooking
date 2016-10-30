package com.goit.hotelonlinebooking.dao;

import com.goit.hotelonlinebooking.entity.Hotel;
import com.goit.hotelonlinebooking.entity.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class HotelDAO extends AbstractDAO<Hotel>{


    public HotelDAO() {
        save(new Hotel(new Random().nextLong(), "Radisson Podil", "Kiev",
                "Kiev, Podil", "radisson@ukr.net",5,roomConstruction()));
        save(new Hotel(new Random().nextLong(), "Hayat", "Kiev",
                "Kiev, Center", "hayat@ukr.net",5,roomConstruction()));
        save(new Hotel(new Random().nextLong(), "Radisson Alushta", "Alushta",
                "Alushta beach", "radissonalushta@ukr.net",5,roomConstruction()));
        save(new Hotel(new Random().nextLong(), "HOTEL-ka", "Moscow",
                "Moscow, Kremlin", "hotelka@ukr.net",4,roomConstruction()));
        save(new Hotel(new Random().nextLong(), "Big Ben Hotel", "London",
                "Pasadena Str 7", "bb@ukr.net",5,roomConstruction()));
        save(new Hotel(new Random().nextLong(), "Svitanok", "Zhitomir",
                "Zhitomir, Pavlova 5", "Svitanok@ukr.net",4,roomConstruction()));
        save(new Hotel(new Random().nextLong(), "Hertz Hotel", "Berlin",
                "Berlin, AntaresPlatz", "Hertz@ukr.net",5,roomConstruction()));
        save(new Hotel(new Random().nextLong(), "Japoshka", "Tokio",
                "Tokio, Arigato Str", "Japoshka@ukr.net",5,roomConstruction()));
    }
    private List<Room> roomConstruction() {     //return Rooms to some Hotel
        List<List<Room>> roomPackage = new ArrayList<>();
        List<Room> listOne = new ArrayList<>();
        listOne.add(new Room(new Random().nextLong(), 1,2,null));
        listOne.add(new Room(new Random().nextLong(), 1,2,null));
        listOne.add(new Room(new Random().nextLong(), 1,2,null));
        listOne.add(new Room(new Random().nextLong(), 1,2,null));
        listOne.add(new Room(new Random().nextLong(), 1,2,null));
        listOne.add(new Room(new Random().nextLong(), 1,2,null));
        listOne.add(new Room(new Random().nextLong(), 1,2,null));
        listOne.add(new Room(new Random().nextLong(), 1,2,null));
        listOne.add(new Room(new Random().nextLong(), 1,2,null));
        listOne.add(new Room(new Random().nextLong(), 1,2,null));

        List<Room> listTwo = new ArrayList<>();
        listTwo.add(new Room(new Random().nextLong(), 1,2,null));
        listTwo.add(new Room(new Random().nextLong(), 1,2,null));
        listTwo.add(new Room(new Random().nextLong(), 1,2,null));
        listTwo.add(new Room(new Random().nextLong(), 1,2,null));
        listTwo.add(new Room(new Random().nextLong(), 1,2,null));
        listTwo.add(new Room(new Random().nextLong(), 1,2,null));
        listTwo.add(new Room(new Random().nextLong(), 1,2,null));
        listTwo.add(new Room(new Random().nextLong(), 1,2,null));
        listTwo.add(new Room(new Random().nextLong(), 1,2,null));
        listTwo.add(new Room(new Random().nextLong(), 1,2,null));

        List<Room> listThree = new ArrayList<>();
        listThree.add(new Room(new Random().nextLong(), 1,2,null));
        listThree.add(new Room(new Random().nextLong(), 1,2,null));
        listThree.add(new Room(new Random().nextLong(), 1,2,null));
        listThree.add(new Room(new Random().nextLong(), 1,2,null));
        listThree.add(new Room(new Random().nextLong(), 1,2,null));
        listThree.add(new Room(new Random().nextLong(), 1,2,null));
        listThree.add(new Room(new Random().nextLong(), 1,2,null));
        listThree.add(new Room(new Random().nextLong(), 1,2,null));
        listThree.add(new Room(new Random().nextLong(), 1,2,null));
        listThree.add(new Room(new Random().nextLong(), 1,2,null));

        roomPackage.add(listOne);
        roomPackage.add(listTwo);
        roomPackage.add(listThree);

        return roomPackage.get(new Random().nextInt(roomPackage.size()));

    }
}

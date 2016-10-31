package com.goit.hotelonlinebooking.entity;

import com.goit.hotelonlinebooking.dao.ById;

public class Room extends ById{
    private long id;
    private long price;
    private int floor;
    private int capacity;
    private User userReserved;


    public Room(long id, long price, int floor, int capacity, User userReserved) {
        this.id = id;
        this.price = price;
        this.floor = floor;
        this.capacity = capacity;
        this.userReserved = userReserved;
    }

    public long getId() {
        return id;
    }

    public int getFloor() {
        return floor;
    }


    public long getPrice() {
        return price;

    }

    public User getUserReserved() {
        return userReserved;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        if (id != room.id) return false;
        if (price != room.price) return false;
        if (floor != room.floor) return false;
        if (capacity != room.capacity) return false;
        return userReserved != null ? userReserved.equals(room.userReserved) : room.userReserved == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (price ^ (price >>> 32));
        result = 31 * result + floor;
        result = 31 * result + capacity;
        result = 31 * result + (userReserved != null ? userReserved.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Room[" +
                "id=" + id +
                ", floor=" + floor +
                ", capacity=" + capacity +
                ']';
    }
}

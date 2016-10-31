package com.goit.hotelonlinebooking.entity;

import com.goit.hotelonlinebooking.dao.ById;

public class Room extends ById {
    private long Id;
    private long price;
    private int floor;
    private int capacity;
    private User userReserved;


    public Room(long Id, int floor, int capacity, long price, User userReserved) {
        this.Id = Id;
        this.floor = floor;
        this.capacity = capacity;
        this.price = price;
        this.userReserved = userReserved;
    }

    public int getFloor() {
        return floor;
    }

    public int getCapacity() {
        return capacity;
    }

    public User getUserReserved() {
        return userReserved;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        if (Id != room.Id) return false;
        if (floor != room.floor) return false;
        if (capacity != room.capacity) return false;
        return userReserved.equals(room.userReserved);

    }

    @Override
    public int hashCode() {
        int result = (int) (Id ^ (Id >>> 32));
        result = 31 * result + floor;
        result = 31 * result + capacity;
        result = 31 * result + userReserved.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Room[" +
                "Id=" + Id +
                ", floor=" + floor +
                ", capacity=" + capacity +
                ']';
    }

    @Override
    public long getId() {
        return Id;
    }

    public long getPrice() {
        return price;
    }
}

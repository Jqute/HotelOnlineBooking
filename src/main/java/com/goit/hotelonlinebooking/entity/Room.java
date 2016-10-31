package com.goit.hotelonlinebooking.entity;

public class Room {
    private long id;
    private int floor;
    private int capacity;
    private User userReserved;


    public Room(long id, int floor, int capacity, User userReserved) {
        this.id = id;
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

        if (id != room.id) return false;
        if (floor != room.floor) return false;
        if (capacity != room.capacity) return false;
        return userReserved.equals(room.userReserved);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + floor;
        result = 31 * result + capacity;
        result = 31 * result + userReserved.hashCode();
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

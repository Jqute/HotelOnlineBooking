package com.goit.hotelonlinebooking.entity;

public class Room {
    private long roomId;
    private int floor;
    private int capacity;
    private User userReserved;


    public Room(long roomId, int floor, int capacity, User userReserved) {
        this.roomId = roomId;
        this.floor = floor;
        this.capacity = capacity;
        this.userReserved = userReserved;
    }

    public long getRoomId() {
        return roomId;
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

        if (roomId != room.roomId) return false;
        if (floor != room.floor) return false;
        if (capacity != room.capacity) return false;
        return userReserved.equals(room.userReserved);

    }

    @Override
    public int hashCode() {
        int result = (int) (roomId ^ (roomId >>> 32));
        result = 31 * result + floor;
        result = 31 * result + capacity;
        result = 31 * result + userReserved.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Room[" +
                "roomId=" + roomId +
                ", floor=" + floor +
                ", capacity=" + capacity +
                ']';
    }
}

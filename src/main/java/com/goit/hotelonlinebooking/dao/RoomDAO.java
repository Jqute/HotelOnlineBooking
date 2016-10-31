    package com.goit.hotelonlinebooking.dao;
    /*
    andrey.a.fedosov: version 1 - 30.10.2016/
     */

    import com.goit.hotelonlinebooking.entity.Room;
    import com.goit.hotelonlinebooking.entity.User;

    import java.util.ArrayList;
    import java.util.Iterator;
    import java.util.List;
    import java.util.stream.Collectors;



    public class RoomDAO  extends AbstractDAO<Room>{

        public RoomDAO() {
            generateRooms();
        }

        private void generateRooms(){
            int cntRooms = (int)Math.random()*100;
            System.out.println(cntRooms);
            save(new Room(1,1,1,100,null));
            save(new Room(2,1,2,300,null));
            save(new Room(3,1,3,400,null));
            save(new Room(4,2,1,1500,null));
            save(new Room(5,2,1,1500,null));
            save(new Room(6,2,4,2000,null));
            save(new Room(7,3,3,2500,null));
            save(new Room(8,3,3,2500,null));

        }

        public List<Room> getReservedRooms ()
        {
            List<Room> roomList = getList().stream()
                                            .filter(r -> !r.getUserReserved().equals(null))
                                            .collect(Collectors.toList());
            return roomList;
        }

        public List<Room> getFreeRooms ()
        {
            List<Room> roomList = getList().stream()
                                            .filter(r -> r.getUserReserved().equals(null))
                                            .collect(Collectors.toList());
            return roomList;

        }

        public Room getRoomById (long id)
        {
            Room room = new Room(-1,0,0,0,null);
            try
            {
            List<Room> roomList = getList().stream()
                                            .filter(r -> r.getId() == id)
                                            .collect(Collectors.toList());
            room = roomList.get(0);
            }
            catch (IndexOutOfBoundsException | NullPointerException a)
            {
                System.out.println("Не найдено ниодной комнаты с таким ID");

            }
            return room;
        }

        public boolean checkReservation (long id) {
            boolean checked = false;

            Room room = getRoomById(id);

            try
            {
                User user = room.getUserReserved();
                if (!user.equals(null))
                    checked = true;
            }
            catch (NullPointerException e)
            {
                checked = false;
            }
            return checked;

        }

        public void bookRoom(long roomId,User user)
        {

        }
        public void cancelReservation(long roomId, User user)
        {

        }

    }

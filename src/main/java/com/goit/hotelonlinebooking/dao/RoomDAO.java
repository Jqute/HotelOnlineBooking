    package com.goit.hotelonlinebooking.dao;
    /*
    andrey.a.fedosov: version 1 - 30.10.2016/
     */

    import com.goit.hotelonlinebooking.entity.Room;
    import com.goit.hotelonlinebooking.entity.User;
    import java.util.List;
    import java.util.stream.Collectors;



    public class RoomDAO  extends AbstractDAO<Room>{

        public RoomDAO() {
            generateRooms();
        }

        private void generateRooms(){
            int maxPrice =  50;
            int minPrice = 5;
            int index = 0;
            int cntFloor = 3 + (int)(Math.random() * ((8 - 3) + 1));
            int cntRoom = 1 + (int)(Math.random() * ((4 - 1) + 1));


            for (int i = 1; i<= cntFloor; i++) {
                for (int k = 1; k <= cntRoom; k++) {
                    int capacity = 1 + (int)(Math.random() * ((4 - 1) + 1));
                    int price = (minPrice*capacity + (int) (Math.random() * ((maxPrice*capacity - minPrice*capacity) + 1)))*100;
                    index++;
                    save(new Room(index, price, i, capacity, null));
                }
            }

        }

        public List<Room> getReservedRooms ()
        {
            List<Room> roomList = getList().stream()
                                            .filter(r -> r.getUserReserved() != null)
                                            .collect(Collectors.toList());
            return roomList;
        }

        public List<Room> getFreeRooms ()
        {
            List<Room> roomList = getList().stream()
                                            .filter(r -> r.getUserReserved() == null)
                                            .collect(Collectors.toList());
            return roomList;

        }

        public Room getRoomById (long Id)
        {

            try
            {
            List<Room> roomList = getList().stream()
                                            .filter(r -> r.getId() == Id)
                                            .collect(Collectors.toList());
            Room room  = roomList.get(0);
            }
            catch (IndexOutOfBoundsException | NullPointerException a)
            {
                System.out.println("Не найдено ниодной комнаты с таким ID");

            }
            return null;
        }

        public List<Room> getRoomByUser (User user)
        {
            try
            {
                List<Room> roomList = getList().stream()
                        .filter(r -> r.getUserReserved().equals(user))
                        .collect(Collectors.toList());
                return roomList;
            }
            catch (IndexOutOfBoundsException | NullPointerException a)
            {
                System.out.println("Не найдены комнаты забронированные данным пользователем: " + user);

            }
            return null;
        }

        public boolean checkReservation (long Id) {
            boolean checked = false;

            Room room = getRoomById(Id);

            try
            {
                User user = room.getUserReserved();
                if (user != null)
                    checked = true;
            }
            catch (NullPointerException e)
            {
                checked = false;
            }
            return checked;

        }

        public boolean checkReservation (long Id, User user) {
            boolean checked = false;

            Room room = getRoomById(Id);

            try
            {
                if (user.equals(room.getUserReserved()))
                checked = true;
            }
            catch (NullPointerException e)
            {
                checked = false;
            }
            return checked;

        }

        public void bookRoom(long Id,User user)
        {

        }
        public void cancelReservation(long Id, User user)
        {

        }

        public List<Room> findFreeRoomByPrice(int price)
        {
            try
            {
                List<Room> roomList = getFreeRooms().stream()
                        .filter(r -> r.getPrice() == price)
                        .collect(Collectors.toList());
                return roomList;
            }
            catch (IndexOutOfBoundsException | NullPointerException a)
            {
                System.out.println("Не найдены свободные комнаты  по цене " + price);

            }
            return null;
        }

        public List<Room> findFreeRoomByCapacity(int capacity)
        {
            try
            {
                List<Room> roomList = getFreeRooms().stream()
                        .filter(r -> r.getCapacity() == capacity)
                        .collect(Collectors.toList());
                return roomList;
            }
            catch (IndexOutOfBoundsException | NullPointerException a)
            {
                System.out.println("Не найдены свободные комнаты вместимостью: " + capacity);

            }
            return null;
        }

        public List<Room> findFreeRoomByFloor(int floor)
        {
            try
            {
                List<Room> roomList = getFreeRooms().stream()
                        .filter(r -> r.getFloor() == floor)
                        .collect(Collectors.toList());
                return roomList;
            }
            catch (IndexOutOfBoundsException | NullPointerException a)
            {
                System.out.println("Не найдены свободные комнаты на " + floor + " этаже");

            }
            return null;
        }

        public List<Room> findFreeRoomByParams(int price, int capacity)
        {
            try
            {
                List<Room> roomList = getFreeRooms().stream()
                        .filter(r -> (r.getPrice() == price) & (r.getCapacity() == capacity))
                        .collect(Collectors.toList());
                return roomList;
            }
            catch (IndexOutOfBoundsException | NullPointerException a)
            {
                System.out.println("Не найдены свободные комнаты по цене " + price + " вместимостью " + capacity);

            }
            return null;
        }


    }

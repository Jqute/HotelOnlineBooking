    package com.goit.hotelonlinebooking.dao;

    import com.goit.hotelonlinebooking.entity.Room;
    import com.goit.hotelonlinebooking.entity.User;

    import java.util.ArrayList;
    import java.util.List;
    import java.util.Random;
    import java.util.function.BooleanSupplier;
    import java.util.stream.Collectors;



    public class RoomDAO  extends AbstractDAO<Room>{

        public RoomDAO() {
            generateRooms(false);
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
                System.out.println();

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

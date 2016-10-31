package com.goit.hotelonlinebooking.controller;

/*
//Hotel - Collection<Room>
//Room - User userReserved
Collection<Hotel> findHotel(String name)
Collection<Hotel> findHotel(String city)
void bookRoom(long roomId, long userId, long hotelId)
void cancelReservation(long roomId, long userId, long hotelId)
Collection<Hotel> findRoom(Map<Sring, String> params)


//city - Kiev, hotelName - Radisson, price - 200, persons - 2

registerUser(User user)

 */


//import com.goit.hotelonlinebooking.dao.HotelDAO;
//import com.goit.hotelonlinebooking.dao.RoomDAO;
import com.goit.hotelonlinebooking.dao.UserDAO;
import com.goit.hotelonlinebooking.entity.Hotel;
import com.goit.hotelonlinebooking.entity.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Random;

public class TestController {

    User user = new User();
    UserDAO userDAO = new UserDAO();
    //HotelDAO hotelDAO = new HotelDAO();
    //RoomDAO roomDAO = new RoomDAO();

    public void registerUser() throws IOException {

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(inputStreamReader);

        int countLine = 1;

        while (countLine > 0) {

            System.out.print("Input User's name: ");

            try {
                user.setName(br.readLine());

            } catch (IOException io) {
                System.out.println("Wrong by input");
            }

            countLine--;
        }

        int countLine1 = 1;

        while (countLine1 > 0) {

            System.out.print("Input User's last name: ");

            try {
                user.setLastName(br.readLine());

            } catch (IOException io) {
                System.out.println("Wrong by input");
            }

            countLine1--;
        }

        int countLine2 = 1;

        while (countLine2 > 0) {

            System.out.print("Input User's age: ");

            try {
                String ageStr = br.readLine();
                int age = Integer.valueOf(ageStr);
                user.setAge(age);


            } catch (IOException  | NumberFormatException e) {
                System.out.println("Wrong by input");
            }

            countLine2--;
        }

        int countLine3 = 1;

        while (countLine3 > 0) {

            System.out.print("Input User's email: ");

            try {
                user.setEmail(br.readLine());

            } catch (IOException io) {
                System.out.println("Wrong by input");
            }

            countLine3--;
        }

        int countLine4 = 1;

        while (countLine4 > 0) {

            System.out.print("Input User's phone number: ");

            try {
                user.setUserPhoneNumber(br.readLine());

            } catch (IOException io) {
                System.out.println("Wrong by input");
            }

            countLine4--;
        }
        int countLine5 = 1;

        while (countLine5 > 0) {

            System.out.print("Input password: ");

            try {
                user.setHashedPassword(br.readLine());

            } catch (IOException io) {
                System.out.println("Wrong by input");
            }

            countLine5--;
        }

        br.close();

        user.setId(new Random().nextLong());

        userDAO.save(user);

    }

    /*public List<Hotel> findHotel(String hotelName) {

        for (Hotel hotel : hotelDAO.getList()) {


        }
        return null;
    }*/


}

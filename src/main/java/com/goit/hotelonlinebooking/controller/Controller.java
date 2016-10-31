package com.goit.hotelonlinebooking.controller;


import com.goit.hotelonlinebooking.dao.UserDAO;
import com.goit.hotelonlinebooking.entity.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Controller {

    private User user = new User();
    public UserDAO userDAO = new UserDAO();

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


            } catch (IOException | NumberFormatException e) {
                System.out.println("Wrong by input. Input correct age");
                throw e;

            }

            countLine2--;
        }

        int countLine3 = 1;

        while (countLine3 > 0) {

            System.out.print("Input User's email: ");

            try {
                String email = br.readLine();
                if (email.contains("@") && email.contains(".")) {
                    user.setEmail(email);
                } else {
                    System.out.println("You input incorrect email. Re-enter email");
                    countLine3++;
                }

            } catch (IOException io) {
                System.out.println("Wrong by input");

            }

            countLine3--;
        }

        int countLine4 = 1;

        while (countLine4 > 0) {

            System.out.print("Input User's phone number: ");

            try {
                String phoneNumber = br.readLine();
                if (phoneNumber.length() == 11) {
                    user.setUserPhoneNumber(phoneNumber);
                } else {
                    System.out.println("Re-enter phone number");
                    countLine4++;
                }

            } catch (IOException io) {
                System.out.println("Wrong by input");
            }

            countLine4--;
        }
        int countLine5 = 1;

        while (countLine5 > 0) {

            System.out.print("Input password: ");

            try {
                String password = br.readLine();
                if (password.length() >= 8) {
                    user.setHashedPassword(password);
                } else {
                    System.out.println("Re-enter password. Character number must be 8 or more");
                    countLine5++;
                }


            } catch (IOException io) {
                System.out.println("Wrong by input");
            }

            countLine5--;
        }

        br.close();

        user.setId(new Random().nextLong());

        userDAO.save(user);

    }
}

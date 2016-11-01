package com.goit.hotelonlinebooking.dao;

import com.goit.hotelonlinebooking.entity.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;


public class UserDAO extends AbstractDAO<User> {


    private boolean checkRegistration(User user) {

        Iterator<User> iterator = getList().iterator();

        boolean flag = true;
        while (iterator.hasNext()) {

            User u = iterator.next();
            if (u.getId() == user.getId()) {
                System.out.println("user with ID "+ user.getId()+" exists");
                flag = false;

            } else if (u.getEmail().equals(user.getEmail())) {
                System.out.println("user  with email " + user.getEmail()+" exists");
                flag = false;
            } else if (u.getUserPhoneNumber().equals(user.getUserPhoneNumber())) {
                System.out.println("user with phone number "+ user.getUserPhoneNumber() +" exists");
                flag = false;
            }

        }
        return flag;
    }

    public void userRegistration(User user) {

        if (checkRegistration(user)) {

            save(user);
        }

    }

    public List<User> findUserByName(String name) {

        List<User> userList = getList().stream()
                .filter(user -> user.getName().equals(name))
                .collect(Collectors.toList());

        if (userList.size() != 0) return userList;
        else {
            System.out.println("user with that Name is not found");
            return userList;
        }
    }

    public List<User> findUserByLastName(String lastName) {

        List<User> userList = getList().stream()
                .filter(user -> user.getLastName().equals(lastName))
                .collect(Collectors.toList());

        if (userList.size() != 0) return userList;
        else {
            System.out.println("user with that LastName is not found");
            return userList;
        }

    }

    public List<User> findUserByPhone(String phoneNumber) {

        List<User> userList = getList().stream()
                .filter(user -> user.getUserPhoneNumber().equals(phoneNumber))
                .collect(Collectors.toList());

        if (userList.size() != 0) return userList;
        else {
            System.out.println("user with that phone Number is not found");
            return userList;
        }

    }

    public List<User> findUserByEmail(String email) {

        List<User> userList = getList().stream()
                .filter(user -> user.getEmail().equals(email))
                .collect(Collectors.toList());

        if (userList.size() != 0) {
            return userList;
        } else {
            System.out.println("User with that email is not found");
            return userList;
        }


    }

    public static void main(String[] args) {



        UserDAO userDAO = new UserDAO();

        userDAO.save(new User(002, "A", "B", 21, "u@i.ua", "038463454", "213"));
        userDAO.save(new User(001, "B", "B", 21, "b@i.ua", "038463454", "213"));
        userDAO.save(new User(003, "A", "B", 21, "c@i.ua", "038463454", "213"));
        userDAO.save(new User(004, "D", "B", 21, "u@i.ua", "038463454", "213"));

        for (User u : userDAO.getList()) {
            System.out.println(u);
        }
        System.out.println();

        userDAO.userRegistration(new User(001, "G", "B", 23, "g@i.ua", "09374532", "123"));
        for (User u : userDAO.getList()) {
            System.out.println(u);
        }


    }
}

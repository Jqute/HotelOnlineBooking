package com.goit.hotelonlinebooking.dao;

import com.goit.hotelonlinebooking.entity.User;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class UserDAO extends AbstractDAO<User> {

    public boolean checkRegistration(User user) {
        int quantityDigit = 10;
        Iterator<User> iterator = getList().iterator();
        boolean flag = true;
        if (user.getUserPhoneNumber().length() != quantityDigit) {
            System.out.println("Phone number must contain 10 digits: For example 0967543231");
            flag = false;
        } else if (!(user.getEmail().contains("@") && user.getEmail().contains("."))) {
            System.out.println("e-mail must contain \"@\" and \".\"");
            flag = false;
        }
        while (iterator.hasNext()) {
            User u = iterator.next();
            if (u.getId() == user.getId()) {
                System.out.println("User with ID " + user.getId() + " exists");
                flag = false;
            } else if (u.getEmail().equals(user.getEmail())) {
                System.out.println("User  with email " + user.getEmail() + " exists");
                flag = false;
            } else if (u.getUserPhoneNumber().equals(user.getUserPhoneNumber())) {
                System.out.println("User with phone number " + user.getUserPhoneNumber() + " exists");
                flag = false;
            }
        }
        return flag;
    }

    public List<User> findUserByName(String name) {
        List<User> userList = getList().stream()
                .filter(user -> user.getName().equals(name))
                .collect(Collectors.toList());
        if (userList.size() != 0) return userList;
        else {
            System.out.println("User with that Name is not found");
            return userList;
        }
    }

    public List<User> findUserByLastName(String lastName) {
        List<User> userList = getList().stream()
                .filter(user -> user.getLastName().equals(lastName))
                .collect(Collectors.toList());
        if (userList.size() != 0) return userList;
        else {
            System.out.println("User with that LastName is not found");
            return userList;
        }
    }

    public List<User> findUserByPhone(String phoneNumber) {
        List<User> userList = getList().stream()
                .filter(user -> user.getUserPhoneNumber().equals(phoneNumber))
                .collect(Collectors.toList());
        if (userList.size() != 0) {
            return userList;
        } else {
            System.out.println("User with that phone Number is not found");
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
}


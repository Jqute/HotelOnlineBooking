package com.goit.hotelonlinebooking.dao;

import com.goit.hotelonlinebooking.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class UserDAO extends AbstractDAO<User> {

    public List<User> findUserByName(String name) {

        return getList().stream()
                .filter(user -> user.getName().equals(name))
                .collect(Collectors.toList());
    }

    public List<User> findUserByLastName(String lastName) {

        return getList().stream()
                .filter(user -> user.getLastName().equals(lastName))
                .collect(Collectors.toList());
    }

    public List<User> findUserByPhone(String phoneNumber) {

        List<User> userList = new ArrayList<>();
        if (phoneNumber.length() < 11 || phoneNumber.length() > 11) {
            System.out.println("You input incorrect phone number.");
        } else{
        userList = getList().stream()
                .filter(user -> user.getUserPhoneNumber().equals(phoneNumber))
                .collect(Collectors.toList());
        }

        return userList;
    }

    public List<User> findUserByEmail(String email) {

        return getList().stream()
                .filter(user -> user.getEmail().equals(email))
                .collect(Collectors.toList());
    }

}

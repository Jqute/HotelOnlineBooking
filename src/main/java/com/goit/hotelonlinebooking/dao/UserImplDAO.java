package com.goit.hotelonlinebooking.dao;

import com.goit.hotelonlinebooking.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by user on 28.10.2016.
 */
public class UserImplDAO extends AbstractDAO {

    private List<User> userList;

    public UserImplDAO() {
        userList = new ArrayList<>();
    }

    public List<User> findUserByName(String name) {

        return userList.stream()
                .filter(user -> user.getName().equals(name))
                .collect(Collectors.toList());
    }

    public List<User> findUserByLastName(String lastName) {

        return userList.stream()
                .filter(user -> user.getLastName().equals(lastName))
                .collect(Collectors.toList());
    }

    public List<User> findUserByPhone(int phoneNumber) {

        return userList.stream()
                .filter(user -> user.getUserPhoneNumber() == phoneNumber)
                .collect(Collectors.toList());
    }

    public List<User> findUserByEmail(String email) {

        return userList.stream()
                .filter(user -> user.getEmail().equals(email))
                .collect(Collectors.toList());
    }


}

package com.goit.hotelonlinebooking.dao;

import com.goit.hotelonlinebooking.entity.User;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by user on 28.10.2016.
 */
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

    public List<User> findUserByPhone(int phoneNumber) {

        return getList().stream()
                .filter(user -> user.getUserPhoneNumber() == phoneNumber)
                .collect(Collectors.toList());
    }

    public List<User> findUserByEmail(String email) {

        return getList().stream()
                .filter(user -> user.getEmail().equals(email))
                .collect(Collectors.toList());
    }

}

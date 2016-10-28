package com.goit.hotelonlinebooking.dao;

import com.goit.hotelonlinebooking.entity.User;

import java.util.List;

/**
 * Created by user on 28.10.2016.
 */
public abstract class AbstractUserDAO extends AbstractDAO {

    //abstract void update(T item);

    abstract List<User> findUserInfoByName(String name);

    abstract List<User> findUserInfoByLastName(String lastName);

    abstract List<User> findUserInfoByPhoneNumber(int phoneNumber);

    abstract List<User> findUserInfoByEmail(String email);


}

package com.goit.hotelonlinebooking.controller;

import com.goit.hotelonlinebooking.entity.User;


public class CurrentUser {

    User currentUser;


    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}

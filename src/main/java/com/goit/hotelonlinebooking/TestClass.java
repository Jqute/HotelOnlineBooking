package com.goit.hotelonlinebooking;

import com.goit.hotelonlinebooking.controller.TestController;
import com.goit.hotelonlinebooking.dao.UserDAO;

import java.io.IOException;

/**
 * @author jqute
 */
public class TestClass {

    public static void main(String[] args){

        System.out.println("Hi!");
        TestController testController = new TestController();


        try {
            testController.registerUser();
        }
        catch (IOException io){
            System.out.println("error");
        }

        System.out.println(testController.userDAO.getList());


    }

}

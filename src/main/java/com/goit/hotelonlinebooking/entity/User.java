package com.goit.hotelonlinebooking.entity;

import java.util.Random;

public class User extends WithId {
    private int id;
    private String name;
    private String lastName;
    private int age;
    private String email;
    private String userPhoneNumber;
    private String hashedPassword;

    public User(int id, String name, String lastName, int age, String email, String userPhoneNumber, String hashedPassword) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.userPhoneNumber = userPhoneNumber;
        this.hashedPassword = hashedPassword;

    }

    private int genUserId() {
        return (new Random(100).nextInt());
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (age != user.age) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (userPhoneNumber != null ? !userPhoneNumber.equals(user.userPhoneNumber) : user.userPhoneNumber != null)
            return false;
        return hashedPassword != null ? hashedPassword.equals(user.hashedPassword) : user.hashedPassword == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (userPhoneNumber != null ? userPhoneNumber.hashCode() : 0);
        result = 31 * result + (hashedPassword != null ? hashedPassword.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User : [" +
                "id = " + id +
                ", name ='" + name + '\'' +
                ", lastName = '" + lastName + '\'' +
                ", age = " + age +
                ", email = '" + email + '\'' +
                ", userPhoneNumber = " + userPhoneNumber +
                ", hashedPassword = '" + hashedPassword + '\'' +
                ']';
    }
}

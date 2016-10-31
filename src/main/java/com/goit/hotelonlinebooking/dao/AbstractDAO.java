package com.goit.hotelonlinebooking.dao;

import java.util.*;

public class AbstractDAO<T> {

    private List<T> listObject = new ArrayList<T>();

    public void save(T object) {

        if (listObject.size() == 0) {
            listObject.add(object);
        } else {

            if (listObject.contains(object)) {
                System.out.println("Object " + object + " already exist in list");
            } else listObject.add(object);
        }
    }


    public void delete(T object) {

        if (listObject.isEmpty()) {
            System.out.println("Objects list is empty");
        } else {
            if (listObject.contains(object)) {
                listObject.remove(object);
            }else System.out.println("Object "+object + " does not exist");

        }

    }

    public void deleteList(List<T> listObj) {

        if (listObject.isEmpty()) {
            System.out.println("Objects list is empty");
        } else if(listObj.containsAll(listObj)) {
            listObject.removeAll(listObj);
        } else System.out.println("enter the correct list of users you want to delete");
    }

    public void saveList(List<T> listObj) {

        listObject.addAll(listObj);
        Set<T> setObj = new HashSet<>(listObject);
        listObject.clear();
        listObject.addAll(setObj);

    }

    public List<T> getList() {

        return listObject;

    }
}

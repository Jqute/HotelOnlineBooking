package com.goit.hotelonlinebooking.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AbstractDAO<T> {

    private List<T> listObject = new ArrayList<T>();

    public void save(T object) {

        if (listObject.size() == 0) {
            listObject.add(object);
        } else {
            for (T u : listObject) {
                if (u.equals(object)) {
                    System.out.println("Object already exist in list");
                } else listObject.add(object);
            }
        }
    }

    public void delete(T object) {

        if (listObject.isEmpty()) {
            System.out.println("Objects list is empty");
        } else {
            listObject.remove(object);
        }
    }

    public void deleteList(List<T> listObj) {

        if (listObject.isEmpty()) {
            System.out.println("Objects list is empty");
        } else {
            listObject.removeAll(listObj);
        }
    }

    public void saveList(List<T> listObj) {

        listObject.addAll(listObj);
        Set<T> setObj = new HashSet<T>(listObject);
        listObject.clear();
        listObject.addAll(setObj);

    }

    public List<T> getList() {

        return listObject;

    }
}

package com.goit.hotelonlinebooking.dao;

import com.goit.hotelonlinebooking.entity.WithId;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AbstractDAO<T extends WithId> {

    private List<T> listObject = new ArrayList<>();

    public void save(T object) {
        if (this.listObject.size() == 0) {
            this.listObject.add(object);
        } else {
            if (this.listObject.contains(object)) {
                System.out.println("Object " + object + " already exist in list");
            } else {
                this.listObject.add(object);
            }
        }
    }


    public void delete(T object) {
        if (this.listObject.isEmpty()) {
            System.out.println("Objects list is empty");
        } else {
            if (this.listObject.contains(object)) {
                this.listObject.remove(object);
            } else {
                System.out.println("Object " + object + " does not exist");
            }
        }
    }

    public void deleteList(List<T> listObj) {
        if (this.listObject.isEmpty()) {
            System.out.println("Objects list is empty");
        } else if (listObj.containsAll(listObj)) {
            this.listObject.removeAll(listObj);
        } else {
            System.out.println("Enter the correct list of users you want to delete");
        }
    }

    public void saveList(List<T> listObj) {
        Set<T> setObj = new HashSet<>(this.listObject);
        this.listObject.addAll(setObj);
    }

    public T objectById(long id) {
        for (T t : this.listObject) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    public List<T> getList() {
        return this.listObject;
    }
}

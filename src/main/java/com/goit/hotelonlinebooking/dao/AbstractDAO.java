package com.goit.hotelonlinebooking.dao;

import java.util.List;

public abstract class AbstractDAO<T> {

    abstract void save(T object);

    abstract void delete(T object);

    abstract void deleteList(List<T> object);

    abstract void saveList(List<T> object);

    abstract List<T> getList();


}

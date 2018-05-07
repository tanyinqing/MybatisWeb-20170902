package dao;

import model.Person;

import java.util.List;

public interface GenericDao<T> {

    // create
    void create(T t);

    // remove
    void remove(int id);

    // update
    void update(T t);

    // queryAll
    List<T> queryAll();

    T queryById(int id);

    void removeSelected(int[] ids);
}

package dao;

import model.Person;

import java.util.List;

public interface PersonDao {

    // create
    void create(Person person);

    // remove
    void remove(int id);

    // update
    void update(Person person);

    // queryAll
    List<Person> queryAll();

    Person queryById(int id);

    void removeSelected(int[] ids);
}

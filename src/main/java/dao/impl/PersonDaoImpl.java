package dao.impl;

import dao.PersonDao;
import model.Person;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDaoImpl implements PersonDao {

    private final SqlSession sqlSession;

    @Autowired
    public PersonDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public void create(Person person) {
        sqlSession.insert("person.create", person);
    }

    @Override
    public void remove(int id) {
        sqlSession.delete("person.remove", id);
    }

    @Override
    public void update(Person person) {
        sqlSession.update("person.update", person);
    }

    @Override
    public List<Person> queryAll() {
        return sqlSession.selectList("person.queryAll");
    }

    @Override
    public Person queryById(int id) {
        return sqlSession.selectOne("person.queryById", id);
    }

    @Override
    public void removeSelected(int[] ids) {
        for (int id : ids) {
            remove(id);
        }
    }
}

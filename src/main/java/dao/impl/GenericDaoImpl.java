package dao.impl;

import com.sun.org.apache.xpath.internal.SourceTree;
import dao.GenericDao;
import model.Book;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.reflect.ParameterizedType;
import java.util.List;

@Repository
public class GenericDaoImpl<T> implements GenericDao<T> {

    @Autowired
    private SqlSession sqlSession;

    private String namespace;

    @SuppressWarnings("unchecked")
    public GenericDaoImpl() {
        // Java语音的反射机制
        ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
        Class<T> clazz = (Class<T>) parameterizedType.getActualTypeArguments()[0];
        namespace = clazz.getSimpleName().toLowerCase();
       System.out.println(clazz); // Book, Person, User
//        namespace="book";
        System.out.println(namespace); // book, person, user
    }

    @Override
    public void create(T t) {
        sqlSession.insert(namespace + ".create", t);
    }

    @Override
    public void remove(int id) {
        sqlSession.delete(namespace + ".remove", id);
    }

    @Override
    public void update(T t) {
        sqlSession.update(namespace + ".update", t);
    }

    @Override
    public List<T> queryAll() {
        return sqlSession.selectList(namespace + ".queryAll");
    }

    @Override
    public T queryById(int id) {
        return sqlSession.selectOne(namespace + ".queryById", id);
    }

    @Override
    public void removeSelected(int[] ids) {
        for (int id : ids) {
            remove(id);
        }
    }
}

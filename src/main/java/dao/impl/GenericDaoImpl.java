package dao.impl;

import com.sun.org.apache.xpath.internal.SourceTree;
import dao.GenericDao;
import model.Book;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;


public class GenericDaoImpl<T extends Serializable,N extends Serializable> implements GenericDao<T,N> {

    @Autowired
    private SqlSession sqlSession;

    private String namespace;


    @SuppressWarnings("unchecked")
    public GenericDaoImpl() {
        // Java语音的反射机制
//       namespace="book";
       ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
        Class<T> clazz = (Class<T>) parameterizedType.getActualTypeArguments()[0];
        namespace = clazz.getSimpleName().toLowerCase();
        System.out.println(clazz); // Book, Person, User
//        System.out.println(namespace); // book, person, user
//        System.out.println(getClass().getGenericSuperclass());
    }

    private String getStatement(String sqlId) {
        return namespace.concat(".").concat(sqlId);
    }
    @Override
    public void create(T t) {
//        System.out.println("jia ru yi ben shu--"+ getStatement("create"));
        sqlSession.insert(getStatement("create"), t);
    }

    @Override
    public void remove(N id) {
        sqlSession.delete(getStatement("remove"), id);
    }

    @Override
    public void update(T t) {
        sqlSession.update(getStatement("update"), t);
    }


    @Override
    public List<T> queryAll() {
//        System.out.println("cha xun suo you tu shu");
        return sqlSession.selectList(getStatement("queryAll"));
    }

    @Override
    public T queryById(N id) {
        return sqlSession.selectOne(getStatement("queryById"), id);
    }

    @Override
    public void removeSelected(N[] ids) {
        for (N id : ids) {
            remove(id);
        }
    }

    @Override
    public T queryOne(String statement, Object parameters) {
        return sqlSession.selectOne(statement, parameters);
    }
}

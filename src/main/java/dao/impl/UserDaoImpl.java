package dao.impl;

import dao.BookDao;
import dao.UserDao;
import model.Book;
import model.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User, Integer> implements UserDao {

/*
    @Autowired
    private SqlSession sqlSession;
    @Override
    public void create(User user) {
        sqlSession.insert("mapper.UserMapper.create", user);
    }

    @Override
    public User query(User user) {
        return  user = sqlSession.selectOne("mapper.UserMapper.signIn", user);
    }

    @Override
    public User queryByUsername(User user) {
        return sqlSession.selectOne("mapper.UserMapper.queryByUsername", user);
    }*/
}

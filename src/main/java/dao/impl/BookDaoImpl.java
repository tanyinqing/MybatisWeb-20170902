package dao.impl;

import dao.BookDao;
import model.Book;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImpl<Book> extends GenericDaoImpl<Book> implements BookDao<Book> {
/*
    @Autowired
    private SqlSession sqlSession;
    @Override
    public List<Book> queryAll() {
        return sqlSession.selectList("book.queryAll");
    }

    @Override
    public void create(Book book) {
        sqlSession.insert("book.create", book);
    }


    @Override
    public Book queryById(int id) {
        return sqlSession.selectOne("book.queryById", id);
    }

    @Override
    public void update(Book book) {
        sqlSession.update("book.update", book);
    }

    @Override
    public void remove(int id) {
        sqlSession.delete("book.remove", id);
    }

    @Override
    public void removeBooks(int[] ids) {
        for (int id : ids) {
            remove(id);
        }
    }*/
}

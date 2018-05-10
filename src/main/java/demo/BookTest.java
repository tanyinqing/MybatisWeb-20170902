package demo;

import model.Book;
import org.apache.ibatis.session.SqlSession;
import util.MyBatisSession;

import java.util.List;

public class BookTest {

    private static int create() {
//        try 后的语句会自动关闭资源 实现了 AutoCloseable接口
        try (SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
            return sqlSession.insert("book.create", new Book(null, "title2..", 123.456,100,"2018-04-09",1));
        }

    }

    private static int delete() {
//        try 后的语句会自动关闭资源 实现了 AutoCloseable接口
        try (SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
            return sqlSession.delete("book.delete", 3);
        }

    }

    //查询全部
    private static void retrieve() {
//        try 后的语句会自动关闭资源 实现了 AutoCloseable接口
        try (SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
            List<Book> books= sqlSession.selectList("book.queryAll");
            for (Book book:books){
                System.out.println(book.toString());
            }
        }

    }

    //查询一天
    private static void queryById() {
//        try 后的语句会自动关闭资源 实现了 AutoCloseable接口
        try (SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
           Book book= sqlSession.selectOne("book.queryById",1);
                System.out.println(book.toString());
        }

    }
    //更改
    private static void update() {
//        try 后的语句会自动关闭资源 实现了 AutoCloseable接口
        try (SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
           sqlSession.selectOne("book.update",new Book(1,"new title",123.00,10,"2018-4-9",1));

        }

    }

    public static void main(String[] args) {


//       create();
//        update();
//        queryById();
        //       delete();
//       retrieve();



    }



}

package demo;

import model.Book;
import org.apache.ibatis.session.SqlSession;
import util.MyBatisSession;

import java.util.List;

public class BookTest {

    private static int create() {
//        try ��������Զ��ر���Դ ʵ���� AutoCloseable�ӿ�
        try (SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
            return sqlSession.insert("book.create", new Book(null, "title2..", 123.456,100,"2018-04-09",1));
        }

    }

    private static int delete() {
//        try ��������Զ��ر���Դ ʵ���� AutoCloseable�ӿ�
        try (SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
            return sqlSession.delete("book.delete", 3);
        }

    }

    //��ѯȫ��
    private static void retrieve() {
//        try ��������Զ��ر���Դ ʵ���� AutoCloseable�ӿ�
        try (SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
            List<Book> books= sqlSession.selectList("book.queryAll");
            for (Book book:books){
                System.out.println(book.toString());
            }
        }

    }

    //��ѯһ��
    private static void queryById() {
//        try ��������Զ��ر���Դ ʵ���� AutoCloseable�ӿ�
        try (SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
           Book book= sqlSession.selectOne("book.queryById",1);
                System.out.println(book.toString());
        }

    }
    //����
    private static void update() {
//        try ��������Զ��ر���Դ ʵ���� AutoCloseable�ӿ�
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

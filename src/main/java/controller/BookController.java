package controller;

import model.Book;
import model.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import util.MyBatisSession;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * ������
 * ע�ⷽʽ��д
 * ����ӳ��
 */
@Controller
@RequestMapping("book")
public class BookController extends BaseController{

    @RequestMapping("create")
    private String create(Book book) {
//        System.out.println("user..."+user.toString());
        //����mybatis��ܰ��û��洢�����ݿ���  �����Ķ�Ӧ��ϵ
        try(SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
            sqlSession.insert("book.create", book);
        }
//        return "redirect:/home.jsp";
        return queryAll();
    }

    @RequestMapping("queryAll")
    private String queryAll() {
//        System.out.println("user..."+user.toString());
        //����mybatis��ܰ��û��洢�����ݿ���  �����Ķ�Ӧ��ϵ
        try(SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
           session.setAttribute("books", sqlSession.selectList("book.queryAll"));
        }
        return "redirect:/home.jsp";
    }

    @RequestMapping("queryById/{id}") //·�����������úͻ�ȡ
    private String queryById(@PathVariable int id) {
//        System.out.println("user..."+user.toString());
        //����mybatis��ܰ��û��洢�����ݿ���  �����Ķ�Ӧ��ϵ  false ��ѯ�������޹�
        try(SqlSession sqlSession = MyBatisSession.getSqlSession(false)) {
           session.setAttribute("book", sqlSession.selectOne("book.queryById", id));
        }
        return "redirect:/edit.jsp";
    }

    @RequestMapping("update") //·������
    private String update(Book book) {
//        System.out.println("user..."+user.toString());
        //����mybatis��ܰ��û��洢�����ݿ���  �����Ķ�Ӧ��ϵ  false ��ѯ�������޹�
        try(SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
           sqlSession.update("book.update", book);
        }
        return queryAll();
    }

    @RequestMapping("remove/{id}") //·������
    private String remove(@PathVariable int id) {
//        System.out.println("user..."+user.toString());
        //����mybatis��ܰ��û��洢�����ݿ���  �����Ķ�Ӧ��ϵ  false ��ѯ�������޹�
        try(SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
           sqlSession.delete("book.remove", id);
        }
        return queryAll();
    }


}

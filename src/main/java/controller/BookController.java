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
import java.util.Arrays;
import java.util.List;

/**
 * 控制器
 * 注解方式来写
 * 请求映射
 */
@Controller
@RequestMapping("book")
public class BookController extends BaseController {

    @RequestMapping("create")
    private String create(Book book) {
//        System.out.println("user..."+user.toString());
        //运用mybatis框架把用户存储到数据库中  隐含的对应关系
        try (SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
            sqlSession.insert("book.create", book);
        }
//        return "redirect:/home.jsp";
        return queryAll();
    }

    @RequestMapping("queryAll")
    private String queryAll() {
//        System.out.println("user..."+user.toString());
        //运用mybatis框架把用户存储到数据库中  隐含的对应关系
        try (SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
            session.setAttribute("books", sqlSession.selectList("book.queryAll"));
        }
        return "redirect:/home.jsp";
    }

    @RequestMapping("queryById/{id}") //路径参数发设置和获取
    private String queryById(@PathVariable int id) {
//        System.out.println("user..."+user.toString());
        //运用mybatis框架把用户存储到数据库中  隐含的对应关系  false 查询和事务无关
        try (SqlSession sqlSession = MyBatisSession.getSqlSession(false)) {
            session.setAttribute("book", sqlSession.selectOne("book.queryById", id));
        }
        return "redirect:/edit.jsp";
    }

    @RequestMapping("update") //路径参数
    private String update(Book book) {
//        System.out.println("user..."+user.toString());
        //运用mybatis框架把用户存储到数据库中  隐含的对应关系  false 查询和事务无关
        try (SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
            sqlSession.update("book.update", book);
        }
        return queryAll();
    }

    @RequestMapping("remove/{id}") //路径参数
    private String remove(@PathVariable int id) {
//        System.out.println("user..."+user.toString());
        //运用mybatis框架把用户存储到数据库中  隐含的对应关系  false 查询和事务无关
        try (SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
            sqlSession.delete("book.remove", id);
        }
        return queryAll();
    }


    @RequestMapping("removeBooks") //路径参数removeBooks
    private String removeBooks(int[] ids) {
        System.out.println(Arrays.toString(ids));
//        System.out.println("user..."+user.toString());
        //运用mybatis框架把用户存储到数据库中  隐含的对应关系  false 查询和事务无关
        try (SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
            for (int id : ids) {
                sqlSession.delete("book.remove", id);
            }
        }
        return queryAll();
    }


}

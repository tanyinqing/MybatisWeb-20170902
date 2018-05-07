package controller;

import dao.BookDao;
import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

/**
 * 控制器
 * 注解方式来写
 * 请求映射
 */
@Controller
@RequestMapping("book")
public class BookController extends BaseController {
   /* @Autowired
    private SqlSession sqlSession;*/

//    @Qualifier("bookDaoImpl")  用那一个版本
    //     @Qualifier("JDBCBookDaoImpl")
@Autowired
    private BookDao bookDao;

    @RequestMapping("create")
    private String create(Book book) {
//        System.out.println("user..."+user.toString());
        //运用mybatis框架把用户存储到数据库中  隐含的对应关系
//        try (SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
//            sqlSession.insert("book.create", book);
//        }
//        return "redirect:/home.jsp";
        bookDao.create(book);
        return queryAll();
    }

    @RequestMapping("queryAll")
    private String queryAll() {
//        System.out.println("user..."+user.toString());
        //运用mybatis框架把用户存储到数据库中  隐含的对应关系
//        try (SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
//            session.setAttribute("books", sqlSession.selectList("book.queryAll"));
//        }

        session.setAttribute("books",bookDao.queryAll());
        return "redirect:/home.jsp";
    }

    @RequestMapping("queryById/{id}") //路径参数发设置和获取
    private String queryById(@PathVariable int id) {
//        System.out.println("user..."+user.toString());
        //运用mybatis框架把用户存储到数据库中  隐含的对应关系  false 查询和事务无关
//        try (SqlSession sqlSession = MyBatisSession.getSqlSession(false)) {
//            session.setAttribute("book", sqlSession.selectOne("book.queryById", id));
//        }
        session.setAttribute("book", bookDao.queryById(id));
        return "redirect:/edit.jsp";
    }

    @RequestMapping("update") //路径参数
    private String update(Book book) {
//        System.out.println("user..."+user.toString());
        //运用mybatis框架把用户存储到数据库中  隐含的对应关系  false 查询和事务无关
//        try (SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
//            sqlSession.update("book.update", book);
//        }
        bookDao.update(book);
        return queryAll();
    }

    @RequestMapping("remove/{id}") //路径参数
    private String remove(@PathVariable int id) {
//        System.out.println("user..."+user.toString());
        //运用mybatis框架把用户存储到数据库中  隐含的对应关系  false 查询和事务无关
//        try (SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
//            sqlSession.delete("book.remove", id);
//        }
        bookDao.remove(id);
        return queryAll();
    }


    @RequestMapping("removeBooks") //路径参数removeBooks
    private String removeBooks(int[] ids) {
        System.out.println(Arrays.toString(ids));
//        System.out.println("user..."+user.toString());
        //运用mybatis框架把用户存储到数据库中  隐含的对应关系  false 查询和事务无关
//        try (SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
//            for (int id : ids) {
//                sqlSession.delete("book.remove", id);
//            }
//        }
//        bookDao.removeBooks(ids);
       bookDao.removeSelected(ids);
        return queryAll();
    }


}

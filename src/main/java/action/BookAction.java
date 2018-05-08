package action;

import model.Book;
import model.User;
import org.apache.ibatis.session.SqlSession;
import util.MyBatisSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/book")
public class BookAction extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equals("create")) {
            create(req, resp);
        }
        if (action.equals("queryAll")) {
            queryAll(req, resp);
        }
        if (action.equals("queryById")) {
            queryById(req, resp);
        }
        if (action.equals("update")) {
            update(req, resp);
        }
        if (action.equals("remove")) {
            remove(req, resp);
        }

    }
    private void remove(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        try(SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
            sqlSession.delete("book.remove", id);
        }
        queryAll(req, resp);
    }
    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String title = req.getParameter("title");
        double price = Double.parseDouble(req.getParameter("price"));
        int amount = Integer.parseInt(req.getParameter("amount"));
        String pubTime = req.getParameter("pubTime");

        Book book = new Book(id, title, price, amount, pubTime);

        try(SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
            sqlSession.update("book.update", book);
        }

        queryAll(req, resp);
    }

    private void queryById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        try (SqlSession sqlSession = MyBatisSession.getSqlSession(false)) {
            req.getSession().setAttribute("book", sqlSession.selectOne("book.queryById", id));
        }

        resp.sendRedirect("edit.jsp");
    }

    private void queryAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (SqlSession sqlSession = MyBatisSession.getSqlSession(false)) {
            List<Book> books = sqlSession.selectList("book.queryAll");
            req.getSession().setAttribute("books", books);
        }
        resp.sendRedirect("home.jsp");
    }

    private void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        double price = Double.parseDouble(req.getParameter("price"));
        int amount = Integer.parseInt(req.getParameter("amount"));
        String pubTime = req.getParameter("pubTime");

      Book book = new Book(null, title, price, amount, pubTime);

        try (SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
            sqlSession.insert("book.create", book);
        }
        queryAll(req,resp);
//        resp.sendRedirect("home.jsp");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}

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

        resp.sendRedirect("home.jsp");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}

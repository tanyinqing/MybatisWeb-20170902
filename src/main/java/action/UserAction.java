package action;

import model.User;
import org.apache.ibatis.session.SqlSession;
import util.MyBatisSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/user")
public class UserAction extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equals("signUp")) {
            signUp(req, resp);
        }
        if (action.equals("signIn")) {
            signIn(req, resp);
        }

        if (action.equals("signOut")) {
            signOut(req, resp);
        }
    }

    private void signOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect("index.jsp");
    }
    private void signIn(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try(SqlSession sqlSession = MyBatisSession.getSqlSession(false)){
            User user = sqlSession.selectOne("mapper.UserMapper.signIn", new User(null, username, password));
            if (user == null) {
                req.setAttribute("message", "Invalid username or password.");
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            } else {
                req.getSession().setAttribute("username", username);
//                resp.sendRedirect("home.jsp");
                resp.sendRedirect("/book?action=queryAll");
            }
        }
    }

    private void signUp(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        try (SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
             sqlSession.insert("mapper.UserMapper.create", new User(null, username, password));
        }
        resp.sendRedirect("index.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}

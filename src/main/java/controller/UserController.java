package controller;

import model.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import util.MyBatisSession;

/**
 * 控制器
 * 注解方式来写
 * 请求映射
 */
@Controller
@RequestMapping("user")
public class UserController extends BaseController{

    @RequestMapping("signUp")
    private String signUp(User user) {
//        System.out.println("user..."+user.toString());
        //运用mybatis框架把用户存储到数据库中  隐含的对应关系
        try(SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
            sqlSession.insert("mapper.UserMapper.create", user);
        }
        return "redirect:/index.jsp";
    }

    //用户的登录
    @RequestMapping("signIn")
    private String signIn(User user) {
//        System.out.println("user..."+user.toString());
        //运用mybatis框架把用户存储到数据库中  隐含的对应关系
        try(SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
//            运用的赋值语句
             user = sqlSession.selectOne("mapper.UserMapper.signIn", user);
        }
        if (user != null) {
            session.setAttribute("user",user);
//            return "redirect:/home.jsp";
            return "redirect:/book/queryAll";
        }
        request.setAttribute("message", "Invalid username or password.");
        return "/index.jsp"; // forward
    }

    @RequestMapping("signOut")
    private String signOut() {
        session.invalidate();
        return "redirect:/index.jsp";
    }

}

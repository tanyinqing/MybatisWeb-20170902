package controller;

import dao.BookDao;
import dao.UserDao;
import model.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import service.UserService;
import util.MyBatisSession;

/**
 * 控制器
 * 注解方式来写
 * 请求映射
 */
@Controller
@RequestMapping("user")
public class UserController extends BaseController{//高级业务类

    @Autowired
    private UserService userService;
   /* @Autowired
    @Qualifier("userDaoImpl")
    private UserDao userDao;*/
/*
    @Autowired
    private SqlSession sqlSession;*/

    @RequestMapping("signUp")
    private String signUp(User user) {
//        System.out.println("user..."+user.toString());
        //运用mybatis框架把用户存储到数据库中  隐含的对应关系
//        try(SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {//底层模块类
//            sqlSession.insert("mapper.UserMapper.create", user);
//        }
//        if (userDao.queryByUsername(user) != null) {
        if (!userService.signUp(user)) {
            request.setAttribute("message", "username is existed.");
            return "/sign_up.jsp";
        }

//        userDao.create(user);
        return "redirect:/index.jsp";
    }


    //用户的登录
    @RequestMapping("signIn")
    private String signIn(User user) {
//        System.out.println("user..."+user.toString());
        //运用mybatis框架把用户存储到数据库中  隐含的对应关系
//        try(SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
//            运用的赋值语句
//             user = sqlSession.selectOne("mapper.UserMapper.signIn", user);
//        }


//        加密后的密码
       /* String encryptedPassword=userDao.queryByUsername(user).getPassword();
//        明文密码
        String palinPassword=user.getPassword();

//        user=userDao.query(user);
       if (DigestUtils.md5DigestAsHex(palinPassword.getBytes()).equals(encryptedPassword)) {
            session.setAttribute("user",user);
            //     return "redirect:/home.jsp";
                   return "redirect:/book/queryAll";
        }
        request.setAttribute("message", "Invalid username or password.");
        return "/index.jsp"; // forward*/
       return null;
    }

    @RequestMapping("signOut")
    private String signOut() {
        session.invalidate();
        return "redirect:/index.jsp";
    }

}

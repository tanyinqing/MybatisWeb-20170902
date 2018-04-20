package controller;

import model.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import util.MyBatisSession;

/**
 * ������
 * ע�ⷽʽ��д
 * ����ӳ��
 */
@Controller
@RequestMapping("user")
public class UserController extends BaseController{

    @RequestMapping("signUp")
    private String signUp(User user) {
//        System.out.println("user..."+user.toString());
        //����mybatis��ܰ��û��洢�����ݿ���  �����Ķ�Ӧ��ϵ
        try(SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
            sqlSession.insert("mapper.UserMapper.create", user);
        }
        return "redirect:/index.jsp";
    }

    //�û��ĵ�¼
    @RequestMapping("signIn")
    private String signIn(User user) {
//        System.out.println("user..."+user.toString());
        //����mybatis��ܰ��û��洢�����ݿ���  �����Ķ�Ӧ��ϵ
        try(SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
//            ���õĸ�ֵ���
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

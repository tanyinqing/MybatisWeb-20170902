package demo;

import mapper.UserMapper;
import model.User;
import org.apache.ibatis.session.SqlSession;
import util.MyBatisSession;

import java.util.List;

public class MyBatisTest {
    // create record by XML configuration
//    两个方法一样 和接口无关 通过映射文件
//    不需要做接口  推荐使用
    private static int createUserViaXML() {
//        try 后的语句会自动关闭资源 实现了 AutoCloseable接口
        try (SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
            return sqlSession.insert("mapper.UserMapper.create", new User(null, "Tester3", "password1"));
        }

     /*   try (SqlSession sqlSession = MyBatisSession.getSqlSession(false)) {
            return sqlSession.insert("mapper.UserMapper.create", new User(null,"Tester3", "password1"));
            sqlSession.rollback();  //发生错误 进行回滚
            sqlSession.commit();
        }*/
    }

    // create record by Mapper interface  依靠接口来做的
//    参数错误 会有类型检查 会报编译错误
    private static int createUser() {
        try (SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            return userMapper.create(new User(null, "Tester4", "password2"));
        }
    }

    private static int modifyUser() {
        try (SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
            return sqlSession.update("mapper.UserMapper.modify", new User(1, "谈", "123"));
        }
    }

    private static int remove() {
        try (SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
            User user = new User();
            user.setId(2);
            return sqlSession.delete("mapper.UserMapper.remove", user);
        }
    }

    //查询和事务无关你 ture与false都可以
    private static List<User> queryAll() {
        try (SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
            return sqlSession.selectList("mapper.UserMapper.queryAll");
        }
    }

    //查询和事务无关你 ture与false都可以
    private static User queryById() {
        try (SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
            return sqlSession.selectOne("mapper.UserMapper.queryById", 3);
        }
    }

        /*  private  static  int remove(){
        try (SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
            return sqlSession.delete("mapper.UserMapper.remove",2);
        }
    }*/

    public static void main(String[] args) {

//      dml语句 inset update delete  参数为false不会生效

        User user = queryById();
        System.out.println(user.toString());

        /* List<User> users=queryAll();
        for (User user:users){
            System.out.println(user.toString());
        }*/

        //  createUserViaXML(); // MyBatis method 1  推荐使用
//        modifyUser(); // MyBatis method 1  推荐使用
//        remove(); // MyBatis method 1  推荐使用  返回值  有几条语句被修改了
//        createUser(); // MyBatis method 2: Type Safer
    }
}

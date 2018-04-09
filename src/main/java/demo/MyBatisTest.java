package demo;

import mapper.UserMapper;
import model.User;
import org.apache.ibatis.session.SqlSession;
import util.MyBatisSession;

import java.util.List;

public class MyBatisTest {
    // create record by XML configuration
//    ��������һ�� �ͽӿ��޹� ͨ��ӳ���ļ�
//    ����Ҫ���ӿ�  �Ƽ�ʹ��
    private static int createUserViaXML() {
//        try ��������Զ��ر���Դ ʵ���� AutoCloseable�ӿ�
        try (SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
            return sqlSession.insert("mapper.UserMapper.create", new User(null, "Tester3", "password1"));
        }

     /*   try (SqlSession sqlSession = MyBatisSession.getSqlSession(false)) {
            return sqlSession.insert("mapper.UserMapper.create", new User(null,"Tester3", "password1"));
            sqlSession.rollback();  //�������� ���лع�
            sqlSession.commit();
        }*/
    }

    // create record by Mapper interface  �����ӿ�������
//    �������� �������ͼ�� �ᱨ�������
    private static int createUser() {
        try (SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            return userMapper.create(new User(null, "Tester4", "password2"));
        }
    }

    private static int modifyUser() {
        try (SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
            return sqlSession.update("mapper.UserMapper.modify", new User(1, "̸", "123"));
        }
    }

    private static int remove() {
        try (SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
            User user = new User();
            user.setId(2);
            return sqlSession.delete("mapper.UserMapper.remove", user);
        }
    }

    //��ѯ�������޹��� ture��false������
    private static List<User> queryAll() {
        try (SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
            return sqlSession.selectList("mapper.UserMapper.queryAll");
        }
    }

    //��ѯ�������޹��� ture��false������
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

//      dml��� inset update delete  ����Ϊfalse������Ч

        User user = queryById();
        System.out.println(user.toString());

        /* List<User> users=queryAll();
        for (User user:users){
            System.out.println(user.toString());
        }*/

        //  createUserViaXML(); // MyBatis method 1  �Ƽ�ʹ��
//        modifyUser(); // MyBatis method 1  �Ƽ�ʹ��
//        remove(); // MyBatis method 1  �Ƽ�ʹ��  ����ֵ  �м�����䱻�޸���
//        createUser(); // MyBatis method 2: Type Safer
    }
}

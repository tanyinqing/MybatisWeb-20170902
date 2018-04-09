package util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

// ����ģʽ  �κ�ʱ��ֻ��һ�����ʵ��
public class MyBatisSession {
//    ����ģʽ  ���ǹ���
    private static SqlSessionFactory sqlSessionFactory;
    private static SqlSessionFactory getSqlSessionFactory() {
        if (sqlSessionFactory == null) {
            try {  //�������ļ��л��
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sqlSessionFactory;
    }
//�ӹ�����ȡ��һ����Ʒ  SqlSession���ݿ�Ự
    public static SqlSession getSqlSession(boolean autoCommit) {
//        �Ƿ��Զ��ύ  �������й�
        return getSqlSessionFactory().openSession(autoCommit);
    }
}

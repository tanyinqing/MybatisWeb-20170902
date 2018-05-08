package dao;

import model.Book;
import model.User;

import java.util.List;

/**
 * dao 数据访问对象
 */
public interface UserDao {
    void signUp(User user);
    User signIn(User user);
    User queryByUsername(User user);

}

package dao;

import java.io.Serializable;
import java.util.List;
//泛型有界参数
public interface GenericDao<T extends Serializable,N extends Serializable> {

    // create
    void create(T t);

    // remove
    void remove(N id);

    // update
    void update(T t);

    // queryAll
    List<T> queryAll();

    T queryById(N id);

    void removeSelected(N[] ids);

    T queryOne(String statement,Object parameters);
}

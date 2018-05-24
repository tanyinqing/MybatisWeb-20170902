package model;

import java.io.Serializable;
import java.util.List;

public class Address implements Serializable {
    // 主键用封装类  比较大用 长整型
    private  Integer id;
    private  String detail;
    private  int userId;

    public Address() {
    }

    public Address(Integer id, String detail, int userId) {
        this.id = id;
        this.detail = detail;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}

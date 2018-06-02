package model;

import java.io.Serializable;

public class Course implements Serializable {
    // �����÷�װ��  �Ƚϴ��� ������
    private  Integer id;
    private  String title;

    public Course() {
    }

    public Course(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

package com.example.wbxu.mygreendaodemo.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by wbxu on 2017/6/19.
 */
@Entity
public class Animals {
    @Id(autoincrement = true)
    private Long id;
    private String Name;
    private int Age;
    @Generated(hash = 431525849)
    public Animals(Long id, String Name, int Age) {
        this.id = id;
        this.Name = Name;
        this.Age = Age;
    }
    @Generated(hash = 1996800341)
    public Animals() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.Name;
    }
    public void setName(String Name) {
        this.Name = Name;
    }
    public int getAge() {
        return this.Age;
    }
    public void setAge(int Age) {
        this.Age = Age;
    }
}

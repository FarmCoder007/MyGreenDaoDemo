package com.example.wbxu.mygreendaodemo.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by wbxu on 2017/6/19.
 */
@Entity
public class Peore {
    private  Long id;
    private String  name;
    @Generated(hash = 1686489648)
    public Peore(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    @Generated(hash = 1507300704)
    public Peore() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

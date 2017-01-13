package com.wangdh.learner.springCache;

/**
 * 账号实体
 * @author wangdh
 * 2017年1月13日上午8:46:59
 */
public class Account {

    private int id;
    private String name;

    public Account(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
package com.wangdh.learner.base;

import java.io.Serializable;

/**
 * @author wangdh
 * @Description
 * @date 2018-02-07
 */
public class Student implements Cloneable,Serializable{
    /**
     * 学生姓名
     */
    private String name;
    /**
     * 学生年龄
     */
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

}
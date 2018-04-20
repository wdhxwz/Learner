package com.wangdh.learner.base.bean;

public class Student extends People{
    static {
        System.out.println("Student init......");
    }

    public Student(){
        System.out.println("new Student......");
    }
}

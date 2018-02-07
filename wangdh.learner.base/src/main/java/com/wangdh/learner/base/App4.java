package com.wangdh.learner.base;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author wangdh
 * @Description 创建对象的不同方式 http://blog.csdn.net/shadow_zed/article/details/71486816
 * @date 2018-02-07
 */
public class App4 {
    public static void main(String[] args){
        // 1. new 操作符
        Student student_01 = new Student();
        student_01.setName("student_01");
        System.out.println(student_01.toString());

        // 2. Class.newInstance()
        try {
            Student student_02 = (Student) Class.forName("com.wangdh.learner.base.Student").newInstance();
            student_02.setName("student_02");
            System.out.println(student_02.toString());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 3. Constructor.newInstance()
        Constructor<Student> constructor = null;
        try {
            constructor = Student.class.getConstructor();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        try {
            Student student_03 = constructor.newInstance();
            student_03.setName("student_03");
            System.out.println(student_03.toString());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        // 4. clone




    }
}

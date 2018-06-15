package com.wangdh.learner.base.date;

import com.wangdh.learner.base.Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatApp {
    public static void main(String[] args) throws ParseException {
        String temp = "2016-06-20 22:49:02.967";

        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(temp);
        String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);

        // format函数需要接受一个Date类型参数
        str = new SimpleDateFormat("yyyy-MM").format(new Date());
        System.out.println("==== this time ==="+str);

        Student student = new Student();
        student.setName("介个名字");
        student.setAge(38);
        System.out.println(student.toString());
        test1(student);
        System.out.println(student.toString());

        System.out.println("UserInfo:yyuid:".hashCode());
    }

    /**
     * 功能描述:
     * @auther: dw_wangdonghong
     * @date: 2018/6/12 11:14
     * @param:
     * @return:
     */
    private static void test1(Student student){
        test(student);
    }

    /**
     * 功能描述:
     * @auther: dw_wangdonghong
     * @date: 2018/6/12 11:15
     * @param: [student]
     * @return: void
     */
    private static void test(Student student){
        student.setName("辣个名字");
        student.setAge(18);
    }
}

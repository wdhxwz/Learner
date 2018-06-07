package com.wangdh.learner.base.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: Administrator
 * @Date: 2018/6/7 15:32
 * @Description:
 */
public class FormatApp {
    public static void main(String[] args) throws ParseException {
        String temp = "2016-06-20 22:49:02.967";

        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(temp);
        String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);

        // format函数需要接受一个Date类型参数
        str = new SimpleDateFormat("yyyy-MM").format(new Date());
        System.out.println("==== this time ==="+str);
    }
}

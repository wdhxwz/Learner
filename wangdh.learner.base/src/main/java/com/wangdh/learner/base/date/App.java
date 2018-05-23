package com.wangdh.learner.base.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2018/3/9.
 */
public class App {
    public  static void main(String[] args){
        long time = 1338480000000L;
        Date date = new Date(time);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("");

        // 获取这个月第几天
        Calendar calendar = Calendar.getInstance();
        int thisDay = calendar.get(Calendar.DAY_OF_MONTH);

        System.out.println(thisDay);

        // 获取对应月份最大天数
        date = new Date();
        calendar.setTime(date);
        int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        System.out.println(maxDay);

        // 月份加减
        calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -5);
        DateFormat format = new SimpleDateFormat("yyyyMM");
        String monthString = format.format(calendar.getTime());
        System.out.println(monthString);

        int[] intArray = new int[0];
        // intArray[0] = 1;
        System.out.println(intArray);



    }
}

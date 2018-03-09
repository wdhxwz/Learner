package com.wangdh.learner.base.date;

import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by Administrator on 2018/3/9.
 */
public class App {
    public  static void main(String[] args){
        long time = 1338480000000L;
        Date date = new Date(time);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("");



    }
}

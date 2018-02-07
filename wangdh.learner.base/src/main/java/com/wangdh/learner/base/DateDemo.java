package com.wangdh.learner.base;

import java.time.*;
import java.util.Date;

/**
 * @author wangdh
 * @Description
 * @date 2018-02-07
 */
public class DateDemo {
    public static void main(String[] args){
        Date date = Date.from(Instant.now());
        // Instant instant = date.toInstant();

        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        LocalDate localDate = localDateTime.toLocalDate();
        LocalTime localTime = localDateTime.toLocalTime();

        Date date1 = Date.from(localDateTime.toInstant(ZoneOffset.UTC));
        System.out.println(date1);
        System.out.println(Date.from(localDateTime.toInstant(ZoneOffset.UTC)));
        System.out.println(Date.from(localDateTime.toInstant(ZoneOffset.UTC)));

        System.out.println(date);
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);
    }
}
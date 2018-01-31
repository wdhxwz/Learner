package com.wangdh.learner.base;

import java.time.*;
import java.time.temporal.TemporalUnit;

/**
 * @author wangdh
 * @Description
 * @date 2018-01-31
 */
public class TimeDemo {
    public static void main(String[] args){
        System.out.println(ZonedDateTime.now());
        System.out.println(LocalDateTime.now());
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(ZoneId.systemDefault());

        Period period = Period.between(LocalDate.now(),LocalDate.of(2010,10,10));
        System.out.println(period.getYears());

        LocalDate today = LocalDate.now();
        Month currentMonth = today.getMonth();
        Month firstMonthOfQuarter = currentMonth.firstMonthOfQuarter();
        System.out.println(today.withYear(10));

        System.out.println(today.toEpochDay());


//        2018-01-31T14:00:26.140+08:00[Asia/Shanghai]
//        2018-01-31T14:00:26.141
//        2018-01-31
//        14:00:26.141
//        Asia/Shanghai
    }
}

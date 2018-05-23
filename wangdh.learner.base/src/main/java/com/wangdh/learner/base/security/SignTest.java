package com.wangdh.learner.base.security;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 所有参数按照参数名字母升序排列，sign不参与签名；
 * 2. 将排序后的参数名与对应的参数值（原值）用&拼接在一起，如：a=1,b=2,c=3拼接得到a=1&b=2&c=3；
 * 3. 然后在直接连接“&sysKey=key”值，做一次md5加密并转换成小写，得到签名signature值。如：sysKey为123，则md5前的源串为“a=1&b=2&c=3&sysKey=123”，进行md5之后，
 * 得到sign=382cb3ceb99bb9efead95b4ee43b8b8b
 */
public class SignTest {
    public static void main(String[] args){


    }
}
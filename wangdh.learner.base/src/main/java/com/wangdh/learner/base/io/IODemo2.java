package com.wangdh.learner.base.io;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author wangdh
 * @Description
 * @date 2018-02-07
 */
public class IODemo2 {
    private static final String FILE_PATH = "D:\\test\\test.txt";

    public static void main(String[] args) throws Exception {
        testReader();

        System.out.println("OK");
        // args.length;
        // "".length();
        // list.size()
        // set.size()
        // map.size()

    }

    private static void testStream() throws Exception{
        // 第1步：使用File类找到一个文件
        // 声明File对象
        File f = new File(FILE_PATH);

        // 第2步：通过子类实例化父类对象
        // 准备好一个输出的对象
        OutputStream out = new FileOutputStream(f);

        // 通过对象多态性进行实例化
        // 第3步：进行写操作
        // 准备一个字符串
        String str = "Hello World!!!";

        // 字符串转byte数组
        byte b[] = str.getBytes();

        // 将内容输出
        out.write(b);

        // 第4步：关闭输出流
        // out.close();
        // 此时没有关闭
    }

    private static void testReader() throws Exception{
        // 第1步：使用File类找到一个文件
        // 声明File 对象
        File f = new File(FILE_PATH);

        // 第2步：通过子类实例化父类对象
        // 准备好一个输出的对象
        Writer out = new FileWriter(f);

        // 第3步：进行写操作
        // 准备一个字符串
        String str = "Hello World!!!";

        // 将内容输出
        out.write(str);

        // 第4步：关闭输出流
        // out.close();
        // 此时没有关闭
    }
}

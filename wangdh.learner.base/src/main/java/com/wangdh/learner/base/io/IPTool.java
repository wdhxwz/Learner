package com.wangdh.learner.base.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;

/**
 * @Auther: Administrator
 * @Date: 2018/5/23 14:59
 * @Description:
 */
public class IPTool {
    private static final String FILE_PATH = "C:\\Users\\Administrator\\Desktop\\ip.txt";
    public static void main(String[] args) throws Exception{
        File file = new File(FILE_PATH);
        FileInputStream fileInputStream = new FileInputStream(file);
        FileReader fileReader = new FileReader(file);

        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String header = bufferedReader.readLine();
        header = bufferedReader.readLine();
        String[] headerArray = header.split("\t");
        for (String h : headerArray) {
            System.out.println(h);
        }



        System.out.println(bufferedReader.readLine());



    }
}

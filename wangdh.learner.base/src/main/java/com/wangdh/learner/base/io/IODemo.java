package com.wangdh.learner.base.io;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author wangdh
 * @Description
 * @date 2018-01-31
 */
public class IODemo {
    public static void main(String[] args){
        System.out.println(System.getProperty("user.home"));
        File homedir = new File(System.getProperty("user.home"));
        File file = new File(homedir,"app.conf");

        if(file.exists() && file.isFile() && file.canRead()){
            File configdir = new File(file,".configdir");
            configdir.mkdir();
            file.renameTo(new File(configdir,".config"));
        }

        System.out.println("OK");

        // File:没有直接提供基本功能，无法读取文件内容
        // I/O流(字节流)：InputStream/OutputStream
        // --> FileInputStream/FileOutputStream
        // 字符流:Read/Writer
        // FileReader/BufferedReader/InputStreamReader
        // FileWriter/BufferedWriter/InputStreamWriter
        // Java 7.0 :try-with-resources(TWR)-->AutoCloseable接口
        //
        //
        //

        // Files
        // Paths.get("");
    }
}

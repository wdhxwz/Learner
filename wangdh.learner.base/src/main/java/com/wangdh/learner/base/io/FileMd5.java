package com.wangdh.learner.base.io;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Auther: dw_wanghonghong
 * @Date: 2018/6/20 09:48
 * @Description:
 */
public class FileMd5 {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Administrator\\Desktop\\icon-vip1.png";
        System.out.println(DigestUtils.md5Hex(new FileInputStream(path)));

//        String rootPath = "C:\\Users\\Administrator\\Desktop\\images\\";
//        String[] files = new String[]{ "Vip1.png","Vip2.png","Vip3.png","Vip4.png",
//                "Vip5.png","Vip6.png","Vip7.png","Vip8.png","Vip9.png"};
//
//        for (String file: files) {
//            System.out.println(file + ",MD5=" + DigestUtils.md5Hex(new FileInputStream(rootPath + file)));
//        }
    }
}

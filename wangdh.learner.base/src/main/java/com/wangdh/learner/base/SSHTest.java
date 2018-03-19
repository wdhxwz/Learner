package com.wangdh.learner.base;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 基于Java代码进行ssh连接并操作Linux系统
 * Created by Administrator on 2018/3/19.
 */
public class SSHTest {
    public static void main(String[] args){
        try{
            // 基于IP和端口号建立连接
            Connection connection = new Connection("192.168.1.76",22);
            connection.connect();

            // 进行用户名/密码校验
            boolean isAuthenticated = connection.authenticateWithPassword("root","123456");

            if(!isAuthenticated){
               throw new Exception("授权验证失败");
            }

            // 打开一个会话并执行命令
            Session session = connection.openSession();
            session.execCommand("cd /lvdata/cbb/apphome && ls  \n");

            // 获取返回数据
            InputStream stdout = new StreamGobbler(session.getStdout());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stdout));
            while (true){
                String line = bufferedReader.readLine();
                if(line == null){
                    break;
                }
                System.out.println(line);
            }
            session.close();
            connection.close();
        }
        catch (Exception ex){
            System.err.println("发生异常:" + ex.getMessage());
        }
    }
}

package com.wangdh.learner.redis.mysqlfrom;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangdh
 * @Description
 * @date 2017-12-13
 */
public class ToRedisScript {
    public static void main(String[] args) {
        Connection conn = null;
        String sql;
        try {
            // 动态加载mysql驱动
            Class.forName(MysqlConfig.DRIVER_NAME);

            conn = DriverManager.getConnection(MysqlConfig.URL);
            Statement stmt = conn.createStatement();

            // 查询表名
            sql = "" +
                    "select table_name from information_schema.tables " +
                    " where table_schema='" +
                    MysqlConfig.DB_NAME +
                    "' " +
                    "and table_type='base table' " +
                    "and table_name not like 'act_%';";
            ResultSet result = stmt.executeQuery(sql);
            List<String> tableNames = new ArrayList<>(16);
            while (result.next()) {
                tableNames.add(result.getString(1));
            }

            // 输出表名
            System.out.println("输出表名:");
            tableNames.forEach(item -> System.out.println(item));

            // 有些表可能没主键
            // 有些可能是联合主键
            // 查询主键的SQL语句
//            SELECT  DISTINCT
//            t.TABLE_NAME,
//                    c.COLUMN_NAME
//            FROM
//            INFORMATION_SCHEMA.TABLE_CONSTRAINTS AS t,
//                    INFORMATION_SCHEMA.KEY_COLUMN_USAGE AS c,
//            information_schema.TABLES AS ts
//                    WHERE
//            t.TABLE_NAME = c.TABLE_NAME
//            AND t.TABLE_SCHEMA = 'glcloud'
//            AND t.TABLE_NAME not like 'act_%'
//            AND t.CONSTRAINT_TYPE = 'PRIMARY KEY';

            // 输出redis脚本
            // 主键列和表名
            String keyColumn = "COMMAND_ID";
            String tableName = "udp_command";
            sql = "" +
                    "select column_name from information_schema.columns " +
                    "where table_schema='" +
                    MysqlConfig.DB_NAME +
                    "' " +
                    "and table_name='" +
                    tableName +
                    "';";
            result = stmt.executeQuery(sql);
            List<String> columnNames = new ArrayList<>(16);
            while (result.next()) {
                columnNames.add(result.getString(1));
            }

            StringBuilder redisScript = new StringBuilder(128);
            redisScript.append("SELECT CONCAT(\n");
            redisScript.append("\t\"*");
            redisScript.append(2 * (columnNames.size() + 1));
            redisScript.append("\\r\\n\",");
            redisScript.append("\n\t'$',LENGTH(redis_cmd),'\\r\\n',redis_cmd,'\\r\\n',");
            redisScript.append("\n\t'$',LENGTH(redis_key),'\\r\\n',redis_key,'\\r\\n',");
            for (int index = 0; index < columnNames.size() - 1; index++) {
                redisScript.append("\n\t'$',LENGTH(hkey1),'\\r\\n',hkey1,'\\r\\n','$',LENGTH(hval1),'\\r\\n',hval1,'\\r\\n',".replace("1", index + ""));
            }
            redisScript.append("\n\t'$',LENGTH(hkey1),'\\r\\n',hkey1,'\\r\\n','$',LENGTH(hval1),'\\r\\n',hval1,'\\r'".replace("1", columnNames.size() - 1 + ""));

            redisScript.append("\n)FROM(\n" +
                    "\tSELECT 'HMSET' AS redis_cmd,\n" +
                    "\tconcat_ws(':','udp_command', " +
                    keyColumn +
                    ") AS redis_key,");
            // 可以只要一个循环，多个变量来存后面的字符串，最后再拼起来
            for (int index = 0; index < columnNames.size() - 1; index++) {
                redisScript.append("\n\t'" +
                        columnNames.get(index) +
                        "' AS hkey" +
                        index +
                        ", " +
                        columnNames.get(index) +
                        " AS hval" +
                        index +
                        ",");
            }

            redisScript.append("\n\t'" +
                    columnNames.get((columnNames.size() - 1)) +
                    "' AS hkey" +
                    (columnNames.size() - 1) +
                    ", " +
                    columnNames.get((columnNames.size() - 1)) +
                    " AS hval" +
                    (columnNames.size() - 1));

            redisScript.append("\n\tFrom " +
                    tableName +
                    "\n)AS t;");
            File file = new File(MysqlConfig.SAVE_DIR + tableName + "_to_redis.sql");
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(redisScript.toString().getBytes());
            fileOutputStream.flush();


        } catch (SQLException e) {
            System.out.println("MySQL操作错误：" + e.getMessage());
        } catch (Exception e) {
            System.out.println("异常：" + e.getMessage());
        } finally {
            conn = null;
        }

        System.out.println("OK");
    }
}

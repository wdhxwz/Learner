package com.wangdh.learner.redis.mysqlfrom;

/**
 * @author wangdh
 * @Description mysql服务器相关配置
 * @date 2017-12-13
 */
public class MysqlConfig {
    /**
     * 服务器连接
     */
    public  static  final String URL="jdbc:mysql://192.168.1.20:3306/glcloud?user=root&password=opopop&useUnicode=true&characterEncoding=UTF8";

    /**
     * JDBC驱动
     */
    public static  final String DRIVER_NAME="com.mysql.jdbc.Driver";

    /**
     * 用户名称
     */
    public static  final String USER_NAME="root";

    /**
     * 密码
     */
    public static  final String PASSWORD="opopop";

    /**
     * 数据库名
     */
    public static  final  String DB_NAME="glcloud";

    /**
     * 脚本保存根目录
     */
    public  static  final String  SAVE_DIR="D:\\test\\";
}

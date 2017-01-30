package com.wangdh.learner.mybatis.Utils;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtils {
	private static SqlSessionFactory sqlSessionFactory;

	/**
	 * 获取数据库访问工厂
	 * 
	 * @return SqlSessionFactory
	 */
	public static SqlSessionFactory getSqlSessionFactory(String environment) {
		if (sqlSessionFactory == null) {
			InputStream inputStream;
			try {
				inputStream = Resources.getResourceAsStream("mybatis-Config.xml");
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, environment);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return sqlSessionFactory;
	}

	/**
	 * 获取数据库对象 SqlSession 对象实例不是线程安全的，并且不被共享。 所 以 SqlSession 的作用域最好就是其所在方法的作用域。从
	 * Web 应用程序角度上看，SqlSession 应该存在于 request 级 别作用域上
	 * 
	 * @return SqlSession
	 */
	public static SqlSession openSession(boolean autoCommit) {
		return getSqlSessionFactory(null).openSession(autoCommit);
	}
}
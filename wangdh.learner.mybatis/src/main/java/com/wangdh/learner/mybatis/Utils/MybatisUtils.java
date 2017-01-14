package com.wangdh.learner.mybatis.Utils;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtils {
	private static SqlSessionFactory sqlSessionFactory;
	private static SqlSession sqlSession;

	/**
	 * 获取数据库访问工厂
	 * 
	 * @return SqlSessionFactory
	 */
	public static SqlSessionFactory getSqlSessionFactory() {
		if (sqlSessionFactory == null) {
			InputStream inputStream;
			try {
				inputStream = Resources.getResourceAsStream("mybatisConfig.xml");
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return sqlSessionFactory;
	}

	/**
	 * 获取数据库对象 SqlSession 对象实例不是线程安全的，并且不被共享。
	 * 所 以 SqlSession 的作用域最好就是其所在方法的作用域。从
	 * Web 应用程序角度上看，SqlSession 应该存在于 request 级 别作用域上
	 * @return SqlSession
	 */
	public static SqlSession openSession() {
		if (sqlSession == null) {
			sqlSession = getSqlSessionFactory().openSession();
		}

		return sqlSession;
	}

	public static void commit() {
		if (sqlSession != null) {
			sqlSession.commit();
		}
	}

	/**
	 * 关闭数据库连接
	 */
	public static void closeSession() {
		if (sqlSession != null) {
			sqlSession.close();
		}
	}
}
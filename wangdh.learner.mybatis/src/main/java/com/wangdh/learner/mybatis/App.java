package com.wangdh.learner.mybatis;

import javax.sql.DataSource;

import com.wangdh.learner.mybatis.Utils.MybatisUtils;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws Exception {
		System.out.println(1 + 2 + "" + 2);
		
		DataSource dataSource = MybatisUtils.getDataSource();
		
		System.out.println("OK");
	}
}

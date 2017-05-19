package com.wangdh.learner.zookeeperDemo;

import java.io.IOException;

import org.apache.zookeeper.KeeperException;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
		
//		List<String> children = operator.getChildren("/");
//
//		System.out.println("一级节点");
//		for (String string : children) {
//			System.out.println(string);
//		}
//		
//		
//		System.out.println("二级节点");
//		for (String string : operator.getChildren("/dubbo")) {
//			System.out.println(string);
//		}
//		
//		System.out.println("三级节点");
//		for (String string : operator.getChildren("/dubbo/com.dubboclub.dk.storage.StatisticsStorage")) {
//			System.out.println(string);
//		}
//		
//		System.out.println("四级节点");
//		for (String string : operator.getChildren("/dubbo/com.dubboclub.dk.storage.StatisticsStorage/configurators")) {
//			System.out.println(string);
//		}
//		
//		ZooKeeperOperator operator = new ZooKeeperOperator("10.1.20.162:2181");
//		operator.getData("/disconf/oas-finance-os_1_0_0_0_dev/file/sso.properties/TWEB2113_0_1ab4626b-5950-4f25-be0a-2b7ed92b7c99");
		
		ZooKeeperOperator operator = new ZooKeeperOperator("localhost:2181");
		System.out.println(operator.create("/wangdh", "test"));
		System.out.println(operator.exists("/dubbo"));
	}
}
package com.wangdh.learner.zookeeperDemo;

import java.util.List;

import org.I0Itec.zkclient.ZkClient;

public class ZkClientDemo {

	public static void main(String[] args) {
		ZkClient zkClient = new ZkClient("10.1.21.4:2181", 60000);

		List<String> list = zkClient.getChildren("/");
		for (String string : list) {
			System.out.println(string);
		}
	}
}

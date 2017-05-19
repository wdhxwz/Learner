package com.wangdh.learner.zookeeperDemo;

import java.io.IOException;
import java.util.List;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import com.wangdh.learner.base.json.JsonUtils;

public class ZooKeeperOperator {

	private final int SESSION_TIMEOUT = 30000;

	private ZooKeeper zooKeeper;

	Watcher watcher = new Watcher() {
		@Override
		public void process(WatchedEvent event) {
			String path = event.getPath();
			KeeperState keeperState = event.getState();
			EventType eventType = event.getType();
			System.out.println("path=" + path + ",keeperState=" + keeperState + ",eventType=" + eventType);
		}
	};

	public ZooKeeperOperator(String address) throws IOException {
		zooKeeper = new ZooKeeper(address, SESSION_TIMEOUT, watcher);
	}

	public void Test(String path) throws KeeperException, InterruptedException {

	}

	public List<String> getChildren(String path) throws KeeperException, InterruptedException {
		return zooKeeper.getChildren(path, true, null);
	}

	public String getData(String path) throws KeeperException, InterruptedException {
		String value = new String(zooKeeper.getData(path, true, null));
		System.out.println(value);

		return value;
	}

	public void delete(String path, int version) throws InterruptedException, KeeperException {
		zooKeeper.delete(path, version);
	}

	public String create(String path, String data) throws KeeperException, InterruptedException {
		if (data == null)
			data = "";

		Stat stat = zooKeeper.exists(path, watcher);
		if (stat != null) {
			System.out.println(JsonUtils.toJson(stat));
			zooKeeper.delete(path, -1);
		}

		String result = zooKeeper.create(path, data.getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

		return result;
	}
	
	public String exists(String path) throws KeeperException, InterruptedException{
		Stat stat = zooKeeper.exists(path, watcher);
		
		return JsonUtils.toJson(stat);
	}
}

package com.wangdh.learner.base.thread;

/**
 * 使用线程的Stop()方法来终止线程
 * <p>
 * stop()方法比较暴力，会强行将执行了一半的线程终止
 * </p>
 * 
 * @author wdhcxx
 *
 */
public class StopThreadUnSafe {
	public static User user = new User();

	public static class User {
		private int id;
		private String name;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "User [id=" + id + ",name=" + name + "]";
		}
	}

	public static class ChangeObjectThread implements Runnable {
		@Override
		public void run() {
			while (true) {
				synchronized (user) {
					int v = (int) System.currentTimeMillis() / 1000;
					user.setId(v);
					try {
						Thread.sleep(100);
					} catch (Exception e) {
						e.printStackTrace();
					}

					user.setName(String.valueOf(v));
				}
				Thread.yield();
			}
		}
	}

	public static class ReadObjectThread implements Runnable {
		@Override
		public void run() {
			while (true) {
				synchronized (user) {
					if (user.getName()!=null && user.getId() != Integer.parseInt(user.getName())) {
						System.out.println(user.toString());
					}
				}
				Thread.yield();
			}
		}
	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		new Thread(new ReadObjectThread()).start();
		while (true) {
			Thread thread = new Thread(new ChangeObjectThread());
			thread.start();
			Thread.sleep(150);
			thread.stop();
		}
	}
}

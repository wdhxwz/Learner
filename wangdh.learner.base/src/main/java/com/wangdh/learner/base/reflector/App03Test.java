package com.wangdh.learner.base.reflector;

public class App03Test {

	public double sum() {
		return count * price;
	}

	public void test() {
		int i = 0;
		int j = 1;

		i = i + j;
	}

	/**
	 * 数量
	 */
	private int count;

	/**
	 * 单价
	 */
	private double price;

	/**
	 * 总价
	 */
	private double totalPrice;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
}

package com.wangdh.learner.base.spi;

import java.util.ServiceLoader;

public class SpiFactory {
	private static ServiceLoader<Spi> spiLoader = ServiceLoader.load(Spi.class);

	public static Spi getSpi(String name) {
		for (Spi spi : spiLoader) {
			if (spi.isSupport(name)) {
				return spi;
			}
		}
		return null;
	}
}
package com.wangdh.learner.base.ini;

import java.util.stream.Stream;

/**
 * 这是个配置文档操作类，用来读取和配置ini配置文档
 */
public final class ConfigurationFile {
	public static void main(String[] args) {
		String dids = "042271813eb744a88a71a77563b6fa3d,"
				+ "05ad0e01dfb04d6389a858680298c3b1,"
				+ "2d8cc7532d2c40d9873229d346b4f2e2,"
				+ "2f074565ef77456b978fcb9b239ea918,"
				+ "6ec6cceeaa424540bb07d46c7e9730df,"
				+ "735c57d955b443e6ac42869274f1666d,"
				+ "8c7f8b087b5c4d2789b8346ac3bd6427,"
				+ "96a06ff4f41b4e3885b9c67a178c5a3f,"
				+ "96fe333623343235455549d3656a3929,"
				+ "a8d4eb897f0c436dbb5df956b46bd5b4,"
				+ "b6e1bc8b6a694750a6c83f604f708f13,"
				+ "c0850827ef02483db6e6b76814e583a6,"
				+ "e95c64c11d1245efaa646d7b7e538fce,"
				+ "f003eec4490c47d38719c024dcc7fa13";
		Stream.of(dids.split(",")).forEach(
				s -> System.out.println(Math.abs(s.hashCode()) % 5));

	}
}
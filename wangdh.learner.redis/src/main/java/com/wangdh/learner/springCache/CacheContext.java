package com.wangdh.learner.springCache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

@Component
public class CacheContext<T> {
	private Map<String, T> cache = new ConcurrentHashMap<String, T>();

	public T get(String key) {
		return cache.get(key);
	}

	public void addOrUpdateCache(String key, T value) {
		cache.put(key, value);
	}

	public void evictCache(String key) {
		if (cache.containsKey(key)) {
			cache.remove(key);
		}
	}

	public void evictCache() {
		cache.clear();
	}
}
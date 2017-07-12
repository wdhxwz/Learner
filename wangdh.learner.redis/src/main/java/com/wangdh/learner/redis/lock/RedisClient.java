package com.wangdh.learner.redis.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;

public class RedisClient {

    public JedisPool jedisPool;
    
    public RedisClient(JedisPool pool) {
    	this.jedisPool = pool;
    }
    
    public RedisClient(){
    	
    }
    
    public JedisPool getJedisPool() {
        return jedisPool;
    }

    public void setJedisPool(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }
    
   
    /**
     * 根据key来获取对应的value
     */
    public Object getByKey(String key) {
        Jedis client = jedisPool.getResource();
        Object o = null;
        try {
            o = client.get(key);
        } finally {
        	client.close();
        }
        return o;
    }

    /**
     * 判断String类型key是否存在
     */
    public boolean isKeyExist(String key) {
        Jedis client = jedisPool.getResource();
        boolean o = false;
        try {
            o = client.exists(key);
        } finally {
        	client.close();
        }
        return o;
    }

    /**
     * String类型的键值写入redis
     * 
     * @param key
     * @param value
     * @return
     */
    public boolean set(String key, String value) {
        Jedis client = jedisPool.getResource();
        String issuccess = "";
        try {
            issuccess = client.set(key, value);
            if ("OK".equals(issuccess)) {
                return true;
            } else {
                return false;
            }
        } finally {
        	client.close();
        }
    }
    
    public Long setnx(String key, String value) {
        Jedis client = jedisPool.getResource();
        try {
        	
            Long result = client.setnx(key, value);
            System.out.println("setnx key=" + key + " value=" + value + 
            		"result=" + result) ;
        	return result;
        } finally {
        	client.close();
        }
    }

    /**
     * String类型的键值写入redis,并设置失效时间
     * 
     * @param key
     * @param value
     * @return
     */
    public boolean setKeyWithExpireTime(String key, String value, int time) {
        if (time == 0) {

        }
        Jedis client = jedisPool.getResource();
        String issuccess = "";
        try {
            issuccess = client.setex(key, time, value);
            if ("OK".equals(issuccess)) {
                return true;
            } else {
                return false;
            }
        } finally {
        	client.close();
        }
    }

    /**
     * list<String>结构的数据写入redis
     * 
     * @param key
     * @param value
     * @return
     */
    public boolean lpush(String key, List<String> value) {
        Jedis client = jedisPool.getResource();
        try {
            Transaction tx = client.multi();
            for (String one : value) {
                tx.lpush(key, one);
            }
            tx.exec();
            return true;
        } finally {
        	client.close();
        }
    }

    /**
     * 根据key获取list类型
     * 
     * @param key
     * @return
     */
    public List<String> lrange(String key) {
        Jedis client = jedisPool.getResource();
        List<String> returnList = null;
        try {
        	 returnList = client.lrange(key, 0, -1);

        } finally {
        	client.close();
        }
        return returnList;
    }
    
    public List<String> lrange(String key, int start, int length){
		Jedis client = jedisPool.getResource();
        try {
            return client.lrange(key, start, length);
        } finally{
        	client.close();
        }
    }

    public List<String> getKeys(String pattern) {
        Jedis client = jedisPool.getResource();
        List<String> result = new ArrayList<String>();
        try {
            Set<String> set = client.keys(pattern);
            result.addAll(set);
        } finally {
        	client.close();
        }
        return result;
    }

    public boolean delKey(String key) {
        Jedis client = jedisPool.getResource();
        try {
        	System.out.println("del key=" + key);
            client.del(key);
            return true;
        } finally {
        	client.close();
        }
    }

    public <T> boolean hset(String key, String field, T t) {
        Jedis client = jedisPool.getResource();
        try {
            String afterSerialize = "";
            client.hset(key, field, afterSerialize);
            return true;
        } finally {
        	client.close();
        }

    }

    public String hgetString(String key, String field) {
        Jedis client = jedisPool.getResource();
        try {
            String value = client.hget(key, field);
            return value;
        } finally {
            client.close();// 向连接池“归还”资源
        }

    }

    public Map<String, String> hGetAll(String key) {
        Jedis client = jedisPool.getResource();
        try {
            return client.hgetAll(key);
        } finally {
            client.close();// 向连接池“归还”资源
        }

    }

    public List<String> hkeys(String key) {
        Jedis client = jedisPool.getResource();
        try {
            List<String> fields = new ArrayList<String>();
            Set<String> set = client.hkeys(key);
            fields.addAll(set);
            return fields;
        } finally {
            client.close();// 向连接池“归还”资源
        }

    }

    public List<String> hvals(String key) {
        Jedis client = jedisPool.getResource();
        try {
            List<String> values = client.hvals(key);
            return values;
        } finally {
            client.close();// 向连接池“归还”资源
        }

    }

    public boolean hexists(String key, String field) {
        Jedis client = jedisPool.getResource();
        try {
            return client.hexists(key, field);
        } finally {
            client.close();// 向连接池“归还”资源
        }
    }

    public long incr(String key) {
        Jedis client = jedisPool.getResource();
        try {
            return client.incr(key);
        } finally {
            client.close();
        }
    }

    public void hdel(String key, String... fields) {
        Jedis client = jedisPool.getResource();
        try {
            client.hdel(key, fields);
        } finally {
            client.close();
        }
    }

    /**
     * 
     * 
     * @param key
     * @param field
     */
    public void lpush(String key, String field) {
        Jedis client = jedisPool.getResource();
        try {
            client.lpush(key, field);
        } finally {
            client.close();
        }
    }

    /**
     * 该方法不适用于普通的调用，该方法只针对于错误日志记录
     * 
     * @param key
     * @param field
     */
    public void lpushForErrorMsg(String key, String field) {
        Jedis client = jedisPool.getResource();
        try {
            if (client.llen(key) > 1000) {
                return;
            }
            client.lpush(key, field);
        } finally {
            client.close();
        }
    }
    
    public long llen(String key){
		Jedis client = jedisPool.getResource();
        try {
            return client.llen(key);
        } finally{
            client.close();
        }
    }

    public List<String> blPop(String key, int timeoutSeconds) {
        Jedis client = jedisPool.getResource();
        try {
            return client.blpop(timeoutSeconds, key);
        } finally {
            client.close();
        }
    }

    public <T> long sadd(String key, String... values) {
        Jedis client = jedisPool.getResource();
        try {
            return client.sadd(key, values);
        } finally {
            client.close();
        }
    }

    public <T> long sadd(String key, List<T> ts) {
        Jedis client = jedisPool.getResource();
        try {
            if (ts == null || ts.size() ==0) {
                return 0l;
            }
            String[] values = new String[ts.size()];
            for (int i = 0; i < ts.size(); i++) {
                values[i] = ts.get(i).toString();
            }
            return client.sadd(key, values);
        } finally {
            client.close();
        }
    }

    public long srem(String key, String... values) {
        Jedis client = jedisPool.getResource();
        try {
            return client.srem(key, values);
        } finally {
            client.close();
        }
    }

    public <T> long srem(String key, List<T> ts) {
        Jedis client = jedisPool.getResource();
        try {
            if (ts == null || ts.size() ==0) {
                return 0l;
            }
            String[] values = new String[ts.size()];
            for (int i = 0; i < ts.size(); i++) {
                values[i] = ts.get(i).toString();
            }
            return client.srem(key, values);
        } finally {
            client.close();
        }
    }

    public Set<String> getByRange(String key, double min, double max) {
        Jedis client = jedisPool.getResource();
        try {
            return client.zrangeByScore(key, min, max);
        } finally {
            client.close();
        }
    }

    public Long decr(String key) {
        Jedis client = jedisPool.getResource();
        try {
            return client.decr(key);
        } finally {
            client.close();
        }
    }
    
    public Long hlen(String key) {
        Jedis client = jedisPool.getResource();
        try {
            return client.hlen(key);
        } finally {
        	client.close();
        }
    }
    
    public List<String> hmget(String key, String... fields) {
        Jedis client = jedisPool.getResource();
        try {
            return client.hmget(key, fields);
        } finally {
        	client.close();
        }
    }
    
    /**
	 * 从redis里面得到以 某字符串开头的所有key
	 * 
	 * @param str
	 * */
	public Set<String> getKeyByStr(String str) {
		Jedis client = jedisPool.getResource();

		Set<String> keys = null;
		try {
			keys = client.keys(str);
		} finally {
			client.close();
		}
		return keys;
	}
	
	public void ltrim(String key, int start, int stop){
		Jedis client = jedisPool.getResource();
        try {
            client.ltrim(key, start, stop);
        } finally{
        	client.close();
        }
    }
	/**
	 * 
	 * @param key
	 * @param seconds
	 * @return
	 */
	public Long expire(String key,Integer seconds){
		Jedis client = jedisPool.getResource();
		Long success = 1l;
		try{
			success = client.expire(key, seconds);
		}finally{
			client.close();
		}
		return success;
	}
}
package com.wangdh.learner.springCache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 账号服务类
 * 
 * @author wangdh 2017年1月13日上午8:56:48
 */
@Service
public class AccountService {

	@Autowired
	private CacheContext<Account> accountCacheContext;

	public Account getAccount(String accountName) {
		Account result = accountCacheContext.get(accountName);
		if (result != null) {
			System.out.println("get from cache...");
			return result;
		}

		result = getFromDB(accountName);
		accountCacheContext.addOrUpdateCache(accountName, result);

		return result;
	}

	public void reload() {
		accountCacheContext.evictCache();
	}

	private Account getFromDB(String accountName) {
		Account account = new Account(accountName);
		account.setId(999);

		System.out.println("get from db...");
		return account;
	}
}
package com.wangdh.learner.springCache;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * 使用Spring Cache的账号服务类
 * 
 * @author wangdh 2017年1月13日上午9:16:56
 */
@Service
public class AccountService2 {
	@Cacheable("accountCache")
	public Account getAccount(String accountName) {
		Account result = getFromDB(accountName);

		return result;
	}

	private Account getFromDB(String accountName) {
		Account account = new Account(accountName);
		account.setId(999);

		System.out.println("get from db...");
		return account;
	}

	@CacheEvict(value = "accountCache", key = "#account.getName()")
	public void updateAccount(Account account) {
		updateDB(account);
	}

	@CacheEvict(value = "accountCache", allEntries = true)
	public void reload() {
	}

	private void updateDB(Account account) {
		System.out.println("real update db...");
	}
}
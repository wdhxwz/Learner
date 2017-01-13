package com.wangdh.learner.redis;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wangdh.learner.springCache.Account;
import com.wangdh.learner.springCache.AccountService;
import com.wangdh.learner.springCache.AccountService2;

public class MyCacheTest {

	private AccountService accountService;
	private AccountService2 accountService2;

	@SuppressWarnings("resource")
	@Before
	public void setUp() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-cache.xml");
		accountService = context.getBean(AccountService.class);
		accountService2 = context.getBean(AccountService2.class);
	}

	@Test
	public void testInject() {
		Assert.assertNotNull(accountService);
	}

	@Test
	public void myCacheTest() {
		accountService.getAccount("accountName");
		accountService.getAccount("accountName");

		accountService.reload();
		System.out.println("after reload...");

		accountService.getAccount("accountName");
		accountService.getAccount("accountName");
	}

	@Test
	public void testGetAccountByName() throws Exception {
		System.out.println("first query...");
		accountService2.getAccount("accountName");

		Account account = accountService2.getAccount("accountName2");
		account.setId(10086);
		accountService2.updateAccount(account);		
		
		System.out.println("second query...");
		accountService2.getAccount("accountName");
	}
}

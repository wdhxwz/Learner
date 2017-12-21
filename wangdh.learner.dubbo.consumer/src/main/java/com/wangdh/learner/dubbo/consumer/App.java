package com.wangdh.learner.dubbo.consumer;

import com.alibaba.dubbo.remoting.RemotingException;
import com.alibaba.dubbo.rpc.RpcException;
import com.wangdh.learner.dubbo.api.ValidationService;
import com.wangdh.learner.dubbo.model.ValidationParameter;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wangdh.learner.dubbo.api.ISampleService;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Date;
import java.util.Set;

public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
    	@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:dubbo.xml");
		context.start();

        ValidationService validationService = (ValidationService) context.getBean("validationService");
        // Save OK
        ValidationParameter parameter = new ValidationParameter();
        parameter.setName("liangfei");
        parameter.setEmail("liangfei@liang.fei");
        parameter.setAge(50);
        parameter.setLoginDate(new Date(System.currentTimeMillis() - 1000000));
        parameter.setExpiryDate(new Date(System.currentTimeMillis() + 1000000));
        System.out.println(validationService.save(parameter));
        System.out.println("Validation Save OK");

        // Save Error
        try {
            parameter = new ValidationParameter();
            parameter.setEmail("123");
            System.out.println(validationService.save(parameter));
            System.err.println("Validation Save ERROR");
        } catch (RpcException e) {
            // 客户端验证
//            ConstraintViolationException ve = (ConstraintViolationException) e.getCause();
//            Set<ConstraintViolation<?>> violations = ve.getConstraintViolations();
//            for (ConstraintViolation error: violations) {
//               System.out.println(error.getPropertyPath() + error.getMessage()+"\r");
//            }

            // 服务端验证抛出的异常
            RemotingException remotingException = (RemotingException)e.getCause();
            // System.out.println(remotingException.getMessage());
            // System.out.println(violations);
        }


//		while (true) {
//			ISampleService demoService = (ISampleService) context.getBean("sampleService");
//			String hello = "";
//			try {
//				hello = demoService.sayHello("wangdh");
//				demoService.test();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			System.out.println(Thread.currentThread().getName() + " " + hello);
//
//			Thread.sleep(1000);
//		}
    }
}

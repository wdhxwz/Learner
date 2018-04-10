package com.wangdh.learner.mybatis.Utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.wangdh.learner.mybatis.entity.UserEntity;

public class MapperProxy implements InvocationHandler {

    @SuppressWarnings("unchecked")
    public <T> T newInstance(Class<T> type) {
        return (T) Proxy.newProxyInstance(type.getClassLoader(), new Class[]{type}, this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理类：" + proxy.getClass());
        System.out.println("执行：" + method.getDeclaringClass() + "." + method.getName());
        for (Object object : args) {
            System.out.println("参数:" + object.toString());
        }
        if (Object.class.equals(method.getDeclaringClass())) {
            try {
                return method.invoke(this, args);
            } catch (Exception e) {
            }
        }

        return new UserEntity("123", "wangdh", 25);
    }

}

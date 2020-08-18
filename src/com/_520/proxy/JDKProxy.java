package com._520.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Werdio丶
 * @since 2020-08-12 17:27:31
 */
public class JDKProxy implements InvocationHandler {

    private Object target;

    public JDKProxy(Object target) {
        this.target = target;
    }

    public <T>T getObj(){
        return  (T)Proxy.newProxyInstance(JDKProxy.class.getClassLoader(),
                target.getClass().getInterfaces(),
                this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("开始增强");
        Object o = method.invoke(target, args);
        System.out.println("增强结束");

        return o;
    }
}

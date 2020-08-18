package com._520.proxy;

/**
 * @author Werdio丶
 * @since 2020-08-12 17:35:22
 */
public class Client {

    public static void main(String[] args) {
        JDKProxy proxy = new JDKProxy(new TargetImpl());
        TargetInteface targetInteface = proxy.getObj();
        targetInteface.get();
        System.out.println(targetInteface);


    }
}

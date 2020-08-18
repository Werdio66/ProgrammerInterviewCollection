package com._520.proxy;

/**
 * @author Werdio丶
 * @since 2020-08-12 17:28:05
 */
public class TargetImpl implements TargetInteface {

    @Override
    public void get(){
        System.out.println("获取数据");
    }

    @Override
    public String toString() {
        System.out.println("调用 toString ");
        return "toString";
    }
}

package com.chao.reflect.AOP;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {

    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    // 执行动态代理的所有方法时会被替换为执行如下的 invoke 方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        DogUtil du = new DogUtil();
        du.method1();
        // 实现了调用 target 对象的原有方法
        Object result = method.invoke(target, args);
        du.method2();
        return result;
    }
}

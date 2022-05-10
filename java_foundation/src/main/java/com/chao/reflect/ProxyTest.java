package com.chao.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyTest {

    public static void main(String[] args) {
        InvocationHandler handler = new MyInvocationHandler();
        Person p = (Person)Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[]{Person.class}, handler);
        p.walk();
        p.sayHello("Bob");
    }
}

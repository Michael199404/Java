package com.chao.test.thread.chapter2.synLockIn_1;

/**
 * 可重入锁
 * 线程A获得了Service对象的锁，此时这个锁还没有释放
 * 当A再次想获取该对象的锁时还是可以获取的
 */
public class Service {

    synchronized public void service1() {
        System.out.println("service1");
        service2();
    }

    synchronized public void service2() {
        System.out.println("service2");
        service3();
    }

    synchronized public void service3() {
        System.out.println("service3");
    }

}

package com.chao.test.thread.chapter2.synchronizedMethodLockObject;

public class Run {
    public static void main(String[] args) {
        MyObject myObject = new MyObject();
        ThreadA threadA = new ThreadA(myObject);
        threadA.setName("a");
        ThreadB threadB = new ThreadB(myObject);
        threadB.setName("b");
        threadA.start();
        threadB.start();
    }
}

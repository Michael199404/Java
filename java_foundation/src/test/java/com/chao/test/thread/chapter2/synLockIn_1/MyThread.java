package com.chao.test.thread.chapter2.synLockIn_1;

import org.junit.Test;

public class MyThread extends Thread {

    @Override
    public void run() {
        Service service = new Service();
        service.service1();
    }

    @Test
    public void test() {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}

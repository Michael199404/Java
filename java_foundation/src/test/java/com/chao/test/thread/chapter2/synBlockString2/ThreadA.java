package com.chao.test.thread.chapter2.synBlockString2;

public class ThreadA extends Thread {
    private Service service;

    public ThreadA(Service service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.a();
    }
}
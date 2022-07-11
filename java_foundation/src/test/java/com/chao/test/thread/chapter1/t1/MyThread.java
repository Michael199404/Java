package com.chao.test.thread.chapter1.t1;

public class MyThread extends Thread {

    @Override
    public void run() {
        super.run();
        System.out.println("MyThread");
    }
}

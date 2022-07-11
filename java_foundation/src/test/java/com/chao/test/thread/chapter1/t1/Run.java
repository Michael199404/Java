package com.chao.test.thread.chapter1.t1;

import com.chao.test.thread.chapter1.t1.MyThread;

public class Run {

    /**
     * 在使用多线程技术时，代码的运行结果与代码的执行顺序或调用顺序无关
     * @param args
     */
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println("运行结束!");
    }
}

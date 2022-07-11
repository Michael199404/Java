package com.chao.test.thread.chapter2.synBlockString2;

/**
 * Java 还支持任意对象来作为对象监视器来实现同步功能
 * 持有不同对象监视器是异步的效果
 */
public class Service {
    private String anyString = new String();
    public void a() {
        try {
            // 如果换成了this会是什么结果？
            synchronized (anyString) {
                System.out.println("a begin");
                Thread.sleep(3000);
                System.out.println("a end");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void b() {
        System.out.println("b begin");
        System.out.println("b end");
    }
}

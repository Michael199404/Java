package com.chao.test.thread.chapter2.twoObjectTowLock;

/**
 * synchronized 取得的锁都是对象锁，而不是把一段代码或方法当做锁
 */
public class HasSelfPrivateNum {
    private int num = 0;
    synchronized public void addI(String username) {
        try {
            if (username.equals("a")) {
                num = 100;
                System.out.println("a set is over!");
                Thread.sleep(2000);
            } else {
                num = 200;
                System.out.println("b set is over!");
            }
            System.out.println(username + " num = " + num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

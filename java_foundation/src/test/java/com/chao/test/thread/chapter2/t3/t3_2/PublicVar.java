package com.chao.test.thread.chapter2.t3.t3_2;

public class PublicVar {
    public String username = "A";
    public String password = "AA";

    // A 线程调用此方法时，A 线程就获得了setValue()所在对象的锁，其他线程必须等A执行完毕才能调用setValue方法
    synchronized public void setValue(String username, String password) {
        try {
            this.username = username;
            Thread.sleep(5000);
            this.password = password;
            System.out.println("setValue method thread name = " + Thread.currentThread().getName() + " username = " + username + " password = " + password);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // B 线程如果调用了getValue()，必须等A将setValue()执行完，也就是释放对象锁之后才能执行
    synchronized public void getValue() {
        System.out.println("getValue method thread name = " + Thread.currentThread().getName() + " username = " + username + " password = " + password);
    }


}

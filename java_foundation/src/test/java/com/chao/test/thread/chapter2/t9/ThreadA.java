package com.chao.test.thread.chapter2.t9;

public class ThreadA extends Thread {
    private MyOneList myOneList;

    public ThreadA(MyOneList myOneList) {
        this.myOneList = myOneList;
    }

    @Override
    public void run() {
        MyService myService = new MyService();
        myService.addServiceMethod(myOneList, "A");
    }
}

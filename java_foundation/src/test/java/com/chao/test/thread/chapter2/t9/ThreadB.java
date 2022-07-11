package com.chao.test.thread.chapter2.t9;

public class ThreadB extends Thread {
    private MyOneList myOneList;

    public ThreadB(MyOneList myOneList) {
        this.myOneList = myOneList;
    }

    @Override
    public void run() {
        MyService myService = new MyService();
        myService.addServiceMethod(myOneList, "B");
    }
}

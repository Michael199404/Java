package com.chao.test.thread.chapter2.t9;

public class Test {
    public static void main(String[] args) {
        try {
            MyOneList myOneList = new MyOneList();
            ThreadA threadA = new ThreadA(myOneList);
            threadA.setName("A");
            threadA.start();
            ThreadB threadB = new ThreadB(myOneList);
            threadB.setName("B");
            threadB.start();
            Thread.sleep(6000);
            System.out.println("listSize=" + myOneList.getSize());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

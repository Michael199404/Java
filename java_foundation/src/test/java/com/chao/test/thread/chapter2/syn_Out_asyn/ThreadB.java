package com.chao.test.thread.chapter2.syn_Out_asyn;

public class ThreadB extends Thread{
    private MyList myList;

    public ThreadB(MyList myList) {
        this.myList = myList;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            myList.add("threadB" + (i+1));
        }
    }
}

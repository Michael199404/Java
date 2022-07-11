package com.chao.test.thread.chapter2.t9;

public class MyService {
    public MyOneList addServiceMethod(MyOneList list, String data) {
        try {
            // 由于list参数对象在项目中是一份实例，是单例的，而且也正需要对list参数的getSize方法进行同步调用，所以就用list参数进行同步处理
            synchronized (list) {
                if (list.getSize() < 1) {
                    Thread.sleep(2000);
                    list.add(data);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return list;
    }
}

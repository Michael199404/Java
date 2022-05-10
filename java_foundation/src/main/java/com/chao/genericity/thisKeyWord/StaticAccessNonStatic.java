package com.chao.genericity.thisKeyWord;

public class StaticAccessNonStatic {

    public void info() {
        System.out.println("简单info 方法");
    }

    /**
     * this关键字总是指向调用该方法的对象
     * 对于static修饰的方法而言，可以直接使用类来访问
     * 如果在static修饰的方法中使用this关键字，则此关键字无法指向合适的对象
     * @param args
     */
    public static void main(String[] args) {
//        this.info();
        new StaticAccessNonStatic().info();
    }
}

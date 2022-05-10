package com.chao.genericity.thisKeyWord;

public class Dog1 {

    public void jump() {
        System.out.println("jump方法");
    }

    public void run() {
        this.jump();
        System.out.println("run方法");
    }
}

package com.chao.genericity.thisKeyWord;

public class Dog {

    public void jump() {
        System.out.println("jump 方法");
    }

    public void run() {
        Dog d = new Dog();
        d.jump();
        System.out.println("run方法");
    }

    public static void main(String[] args) {
        Dog dog = new Dog();

        dog.run();
    }
}

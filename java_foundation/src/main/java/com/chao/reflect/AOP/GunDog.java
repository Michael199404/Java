package com.chao.reflect.AOP;

public class GunDog implements Dog {
    @Override
    public void info() {
        System.out.println("I am a hunter");
    }

    @Override
    public void run() {
        System.out.println("I run fast");
    }
}

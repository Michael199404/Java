package com.chao.java8.lamdba;

public class LamdbaTest {

    public static void main(String[] args) {
        Integer num = operation(100, (x) -> x * x);
        System.out.println(num);
    }

    public static Integer operation(Integer num, MyFun myFun) {
        return myFun.getValue(num);
    }


}

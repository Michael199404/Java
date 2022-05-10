package com.chao.java8.optional;

import java.util.Optional;

public class OptionalTest {

    // 创建 Optional 实例，NoSuchElementException 异常
    public static void main(String[] args) {
        Optional<Car> empty = Optional.empty();
        Car car = empty.get();
        System.out.println(car);
    }

}

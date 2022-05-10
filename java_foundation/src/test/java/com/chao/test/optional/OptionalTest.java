package com.chao.test.optional;

import com.chao.java8.optional.Car;
import org.junit.Test;

import java.util.Optional;

public class OptionalTest {

    @Test
    public void testOptional() {
        // 创建一个空的 Optional
        Optional<Car> emptyOpt = Optional.empty();
        Car car = emptyOpt.get();
    }

    @Test
    public void createOptional() {
        Car car = null;
        // NullPointerException，需要明确对象不为 null 的时候使用 of()
        Optional<Car> opt = Optional.of(car);
    }

    @Test
    public void createOptional2() {
        String str = "hello";
        Optional<String> opt = Optional.ofNullable(str);

        String s = opt.get();

        // [ifPresent] Optional 中是否有值
        opt.ifPresent(u -> System.out.println(u));

        // [orElse] Optional 中如果有值就返回该值，如果没有值就返回默认值
        String aDefault = Optional.ofNullable(str).orElse("default");

        // [orElseGet]
        Optional.ofNullable(null).orElseGet(() -> "data");
    }

}

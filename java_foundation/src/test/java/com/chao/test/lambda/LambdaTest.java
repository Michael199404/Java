package com.chao.test.lambda;

import org.junit.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Lambda 练习
 */
public class LambdaTest {

    @Test
    public void test1() {

        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
    }

    @Test
    public void test2() {
        Comparator<Integer> com = Integer::compare;
        System.out.println(com);
    }

    @Test
    public void test3() {
        // 使用匿名内部类的方式创建一个对象
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world1");
            }
        };
        r.run();

        // 用lambda表达式创建一个对象
        Runnable r1 = () -> System.out.println("hello world2");
        r1.run();
    }

    @Test
    public void test4() {
        /** lambda 表达式就是对 Consumer 接口中 void accept(T t) 抽象方法的实现 */
        Consumer<String> con = (x) -> System.out.println(x);
        con.accept("hello world");
    }

    @Test
    public void test5() {
        /**
         * 若 lambda 表达式只有一个参数，那么小括号可以省略不写
         */
        Consumer<String> con = x -> System.out.println(x);
        con.accept("hello world");
    }

    /**
     * 有两个以上的参数，并且 lambda 体中有多条语句
     */
    @Test
    public void test6() {
        Comparator<Integer> com = (x, y) -> {
            System.out.println("hello world");
            return Integer.compare(x, y);
        };

        int compare = com.compare(4, 2);
        System.out.println(compare);
    }

    /**
     * 如果只有一条语句，那么大括号和 return 都可以省略不写
     */
    @Test
    public void test7() {
        // 这里相当于实现了 Comparator 中 compare 这个抽象方法, 同时新建了一个对象
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        // 方法引用
        Comparator<Integer> com1 = Integer::compare;

        System.out.println(com1.compare(4, 2));
    }


}

package com.chao.test.stream;

import com.chao.java8.lamdba.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 中间操作
 *
 */
public class TestStreamApi2 {

    List<Employee> emps = Arrays.asList(
            new Employee(101, "张三", 18, 9999.99),
            new Employee(101, "李四", 15, 5555.99),
            new Employee(101, "王五", 23, 8888.99),
            new Employee(101, "赵六", 13, 6666.99)
    );

    /**
     * 中间操作
     *
     * 筛选与切片
     * filter: 接收 Lambda, 从流中排除某些元素
     * limit: 截断流，使其元素不超过给定数量
     * skip(n): 跳过元素，返回一个扔掉前 n 个元素的流，若流中的元素不足 n 个，则返回一个空流，与 limit(n) 互补
     * distinct: 筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
     *
     */

    /**
     * 内部迭代：迭代由 Stream API 完成
     */
    @Test
    public void test1() {
        // 中间操作: 不会执行任何操作
        Stream<Employee> stream = emps.stream()
                .filter((e) -> e.getAge() > 35);

        // 终止操作: 一次性执行全部内容，即“惰性求值”
        stream.forEach(System.out::println);
    }

    @Test
    public void test2() {

    }

    /**
     * 中间操作
     *
     * 映射
     * map: 接收一个 Lambda, 将元素转换成其他形式的的信息。接收一个函数作为参数，该参数会被应用到每个元素上，并将其映射成一个新元素
     * flatMap: 接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有的流连接成一个流
     */
    @Test
    public void test5() {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");

        list.stream()
                .map((str) -> str.toUpperCase())
                .forEach(System.out::println);

        emps.stream()
                .map((e) -> e.getName())
                .forEach(System.out::println);

        Stream<Stream<Character>> stream = list.stream().map(TestStreamApi2::filterCharacter);
        
        stream.forEach((sm) -> {
            sm.forEach(System.out::println);
        });

        Stream<Character> stream1 = list.stream()
                .flatMap(TestStreamApi2::filterCharacter);
    }

    public static Stream<Character> filterCharacter(String str) {
        List<Character> list = new ArrayList<>();
        for (Character ch : str.toCharArray()) {
            list.add(ch);
        }
        return list.stream();
    }

    /**
     * 中间操作
     * 排序
     * sorted(): 自然排序（Comparable）
     * sorted(Comparator com): 定制排序（Comparator）
     */
    @Test
    public void test6() {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");
        list.stream().sorted().forEach(System.out::println);

        emps.stream()
                .sorted((e1, e2) -> {
                    if (e1.getAge() == e2.getAge()) {
                        return e1.getName().compareTo(e2.getName());
                    }
                    return 0;
                }).forEach(System.out::println);
    }
}

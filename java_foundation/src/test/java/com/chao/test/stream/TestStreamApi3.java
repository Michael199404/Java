package com.chao.test.stream;

import com.chao.java8.lamdba.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 终止操作
 */
public class TestStreamApi3 {

    List<Employee> emps = Arrays.asList(
            new Employee(101, "张三", 18, 9999.99, Employee.Status.BUSY),
            new Employee(101, "李四", 15, 5555.99, Employee.Status.FREE),
            new Employee(101, "王五", 23, 8888.99, Employee.Status.VOCATION),
            new Employee(101, "赵六", 13, 6666.99, Employee.Status.FREE)
    );

    /**
     * 查找与匹配
     *
     * allMatch: 检查是否匹配所有元素
     * anyMatch: 检查是否至少匹配一个元素
     * noneMatch: 检查是否没有匹配所有元素
     * findFirst: 返回第一个元素
     * findAny: 返回当前流中任意元素
     * count: 返回流中元素的总个数
     * max: 返回流中最大值
     * min: 返回流中最小值
     */
    @Test
    public void test1() {
        Optional<Employee> any = emps.stream()
                .filter((e) -> e.getStatus().equals(Employee.Status.FREE))
                .findAny();
        System.out.println(any.get());

        Optional<Employee> max = emps.stream()
                .max((e1, e2) -> Double.compare(e1.getMoney(), e2.getMoney()));
        System.out.println(max.get());

        Optional<Double> min = emps.stream()
                .map(Employee::getMoney)
                .min(Double::compare);
        System.out.println(min.get());
    }

    /**
     * 归约
     * reduce: 可以将流中的元素反复结合起来，得到一个值
     */







}

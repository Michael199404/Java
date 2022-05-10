package com.chao.test.lambda;

import com.chao.java8.lamdba.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.DoubleToIntFunction;

public class LambdaTest2 {

    List<Employee> emps =Arrays.asList(
            new Employee(101, "张三", 18, 9999.99),
            new Employee(101, "李四", 15, 5555.99),
            new Employee(101, "王五", 23, 8888.99),
            new Employee(101, "赵六", 13, 6666.99)
            );

    /**
     * 通过 Collections.sort 方法，通过定制排序比较两个 Employee，使用Lambda 作为参数传递
     */
    @Test
    public void test1() {
        Collections.sort(emps, (e1, e2) -> {
            if (e1.getAge() == e2.getAge()) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return Integer.compare(e1.getAge(), e2.getAge());
            }
        });

        for (Employee emp : emps) {
            System.out.println(emp);
        }
    }
}

package com.chao.test.lambda;

import com.chao.java8.lamdba.Employee;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 一、方法引用：若Lambda体中的内容有方法已经实现了，我们可以使用方法引用
 * 可以理解为方法引用是 Lambda 表达式的另外一种表现形式
 *
 * 主要有三种语法格式：
 * 对象::实例方法名
 * 类::静态方法名
 * 类::实例方法名
 *
 * 注意：
 * Lambda 体中调用方法的参数与返回值类型要与函数式接口中抽象方法的函数列表和返回值类型保持一致
 * 若 Lambda 参数列表中第一个参数是实例方法的调用者， 第二个参数是实例方法的参数时，可以使用 ClassName::method
 *
 * 二、构造器引用
 * 格式：ClassName::new
 */
public class LambdaTest4 {

    /**
     * 对象::实例方法名
     */
    @Test
    public void test1() {
        Consumer<String> con = (x) -> System.out.println(x);

        PrintStream ps = System.out;
        Consumer<String> con1 = ps::println;

        Consumer<String> con2 = System.out::println;
        con2.accept("abcdefg");
    }

    @Test
    public void test2() {
        Employee employee = new Employee(13, "Bob", 14, 15);
        Supplier<String> sup = () -> employee.getName();
        String str = sup.get();
        System.out.println(str);

        Supplier<Integer> sup2 = employee::getAge;
        Integer age = sup2.get();
        System.out.println(age);
    }

    /**
     * 类::静态方法
     */
    @Test
    public void test3() {
        // Lambda 表达式
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);

        // 方法引用
        Comparator<Integer> com2 = Integer::compareTo;

        int compare = com2.compare(1, 2);

        System.out.println(compare);
    }

    /**
     * 类::实例方法名
     */
    @Test
    public void test4() {
        // 若 Lambda 参数列表中第一个参数是实例方法的调用者， 第二个参数是实例方法的参数时，可以使用 ClassName::method
        BiPredicate<String, String> biPredicate = (x, y) -> x.equals(y);

        BiPredicate<String, String> bp2 = String::equals;

        boolean test = bp2.test("a", "b");
        System.out.println(test);
    }

    /**
     * 构造器引用
     */
    @Test
    public void test5() {
        Supplier<Employee> sup = () -> new Employee();

        Supplier<Employee> sup2 = Employee::new;
    }

    @Test
    public void test6() {
        Function<Integer, Employee> fun = (x) -> new Employee(13);

        Supplier<Employee> sup2 = Employee::new;
    }
}

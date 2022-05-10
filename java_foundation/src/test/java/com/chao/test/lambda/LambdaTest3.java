package com.chao.test.lambda;

import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 四大内置函数式接口
 */
public class LambdaTest3 {

    /**
     * Consumer<T> 消费型接口
     * void accept(T t)
     */
    @Test
    public void test1() {
        // 行为参数化
        happy(10000, (m) -> System.out.println("大宝剑:" + m));
    }

    public void happy(double money, Consumer<Double> con) {
        con.accept(money);
    }

    /**
     * Supplier<T>: 供给型接口
     * T get()
     */
    @Test
    public void test2() {
        List<Integer> numList = getNumList(10, () -> (int) (Math.random() * 100));
        System.out.println(numList);
    }

    /**
     * 需求：产生指定个数的整数，并放入集合中
     */
    public List<Integer> getNumList(int num, Supplier<Integer> sup) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Integer n = sup.get();
            list.add(n);
        }
        return list;
    }

    /**
     * Function<T, R>: 函数型接口
     * R apply(T t)
     */
    @Test
    public void test3() {
        String newStr = strHandler("\t\t\t hello world!", (str) -> str.trim());
        System.out.println(newStr);
    }

    /**
     * 需求：处理字符串
     */
    public String strHandler(String str, Function<String, String> fun) {
        return fun.apply(str);
    }

    /**
     * Predicte<T>: 断言型接口
     * boolean test(T t)
     */
    @Test
    public void test4() {
        List<String> list = Arrays.asList("Hello", "people", "Lambda", "www", "ok");
        List<String> strList = filterStr(list, (s) -> s.length() > 3);
        for (String str : strList){
            System.out.println(str);
        }
    }

    /**
     * 需求：将满足条件的字符串放入集合当中
     */
    public List<String> filterStr(List<String> list, Predicate<String> pre) {
        List<String> strList = new ArrayList<>();
        
        for (String str : list) {
            if (pre.test(str)) {
                strList.add(str);
            }
        }
        return strList;
    }

    @Test
    public void testRegex() {
        String regex = "(/merchant/(frozenMerchant|activeMerchant|deleteMerchant))";
        boolean matches = "/merchant/frozenMerchant".matches(regex);
        System.out.println(matches);
    }


}

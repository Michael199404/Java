package com.chao.test.dateTime;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import static java.time.temporal.TemporalAdjusters.*;

public class LocalDateTest {

    @Test
    public void localDateTest1() {
        LocalDate date = LocalDate.of(2014, 3, 10);
        // 2014
        int year = date.getYear();
        Month month = date.getMonth();
        int dayOfMonth = date.getDayOfMonth();
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        int lengthOfMonth = date.lengthOfMonth();
        boolean leapYear = date.isLeapYear();

        LocalDate today = LocalDate.now();
    }

    /**
     * 使用 with 方法对 LocalDate 进行修改
     */
    @Test
    public void localTest2() {
        // 创建 LocalDate 的修改版
        LocalDate date1 = LocalDate.of(2014, 3, 8);
        LocalDate date2 = date1.withYear(2011);
        LocalDate date3 = date2.withDayOfMonth(25);
        LocalDate date4 = date3.with(ChronoField.MONTH_OF_YEAR, 9);
        System.out.println(date4);
    }

    /**
     * 以相对方式修改 LocalDate 对象的属性
     */
    @Test
    public void localTest3() {
        LocalDate date1 = LocalDate.of(2014, 3, 8);
        // 2014-03-15
        LocalDate date2 = date1.plusWeeks(1);
        // 2013-03-15
        LocalDate date3 = date2.minusYears(1);
        // 2013-09-15
        /**
         * 这里的 plus 是一个通用的方法
         */
        LocalDate date4 = date3.plus(6, ChronoUnit.MONTHS);
    }

    @Test
    public void localTest4() {
        LocalDate date1 = LocalDate.of(2014, 3, 8);
        LocalDate date2 = date1.with(nextOrSame(DayOfWeek.SUNDAY));
        LocalDate date3 = date2.with(lastDayOfMonth());
    }

    @Test
    public void localTest5() {
        LocalDate now = LocalDate.now();
        // 两个月后的今天
        LocalDate date2 = now.plusMonths(2);
        // 两个月前的今天
        LocalDate date3 = now.minusMonths(2);
    }

    @Test
    public void durationTest() {

    }

    @Test
    public void periodTest() {
        LocalDate now = LocalDate.now();
        LocalDate localDate = LocalDate.of(2022, 5, 15);
        Period between = Period.between(now, localDate);
    }

    @Test
    public void dateTimeFormatterTest() {
    }


}

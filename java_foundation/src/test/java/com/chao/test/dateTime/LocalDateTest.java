package com.chao.test.dateTime;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Comparator;

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

    /**
     * 比较两个时间的大小
     */
    @Test
    public void localDateTest6() {
        LocalDate date1 = LocalDate.of(2022, 3, 8);
        LocalDate date2 = LocalDate.of(2022, 5, 8);
        boolean after = date1.isAfter(date2);
        System.out.println(after);
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

    @Test
    public void testPivotIndex() {
        int[] nums = {0, 1};
        int index = pivotIndex(nums);
        System.out.println(index);
    }

    public int pivotIndex(int nums[]) {
        if (nums.length == 1) return 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int leftSum = 0;
        int rightSum = sum - nums[0];
        if (leftSum == rightSum) return 0;
        for (int i = 1; i < nums.length; i++) {
            leftSum = leftSum + nums[i-1];
            rightSum = rightSum - nums[i];
            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }

    @Test
    public void testInsert() {
        int[] nums = {1, 3, 5, 6};
        int result = searchInsert(nums, 2);
        System.out.println(result);
    }

    public int searchInsert(int[] nums, int target) {
        if (target <= nums[0]) return 0;
        if (target == nums[nums.length-1]) return nums.length -1;
        if (target > nums[nums.length-1]) return nums.length;
        int l = 0;
        int r = nums.length - 1;
        int m = 0;
        while (l <= r) {
            m = (l + r) / 2;
            if (nums[m] == target) {
                return m;
            } else if (target > nums[m]) {
                l = m + 1;
            } else {
                r = m -1;
            }
        }
        return m;
    }

    @Test
    public void testSort() {
        int[][] ints = new int[0][2];
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] intervals1, int[] intervals2) {
                return intervals1[0] - intervals2[0];
            }
        });
    }

}

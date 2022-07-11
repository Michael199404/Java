package com.chao.test.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Merge {

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] intervals1, int[] intervals2) {
                return intervals1[0] - intervals2[0];
            }
        });
        List<int[]> merged = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    @Test
    public void reverseWords() {
        String s = "the  sky is blue  ";
        String s1 = reverseWords(s);
        System.out.println(s1);
    }

    public String reverseWords(String s) {
        if (s.length() == 0 || s == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String[] s1 = s.split("\\s+");
        for (int i = s1.length - 1; i >= 0; i--) {
            if (i > 0) {
                sb.append(s1[i]).append(" ");
            } else {
                sb.append(s1[i]);
            }
        }
        return sb.toString();
    }


}

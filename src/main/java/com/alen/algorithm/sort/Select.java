package com.alen.algorithm.sort;

import java.util.Arrays;

/**
 * 选择排序
 *
 * @author lijialun
 * @Desc
 * @create 2020-09-18 11:39
 **/
public class Select {

    //排序
    public static void sort(Comparable[] comparables) {
        for (int i = 0; i <= comparables.length - 2; i++) {
            int min = i;
            for (int j = i; j < comparables.length; j++) {
                if (greater(j, j + 1)) {
                    min = j + 1;
                }
            }
            exch(comparables, i, min);
        }
    }


    //比较
    public static boolean greater(Comparable a, Comparable b) {
        return a.compareTo(b) > 0;
    }

    //交换
    public static void exch(Comparable[] comparables, int a, int b) {
        Comparable t = comparables[b];
        comparables[b] = comparables[a];
        comparables[a] = t;
    }

    public static void main(String[] args) {
        Integer[] integers = new Integer[]{6, 9, 6, 2, 3, 1, 5, 9};
        Bubble.sort(integers);
        System.out.println(Arrays.toString(integers));
    }
}


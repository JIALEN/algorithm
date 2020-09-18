package com.alen.algorithm.until;

import java.util.Arrays;

/**
 * 冒泡
 *
 * @author lijialun
 * @Desc
 * @create 2020-09-18 11:01
 **/
public class Bubble {

    //排序
    public static void sort(Comparable[] comparables) {
        //每次要冒泡的元素
        for (int i = comparables.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (greater(comparables[j], comparables[j + 1])) {
                    exch(comparables, j, j + 1);
                }
            }
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

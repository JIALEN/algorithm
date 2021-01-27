package com.alen.algorithm.review.sort;

import java.util.Arrays;

/**
 * @author lijialun
 * @Desc 选择排序
 * @create 2020-12-26 13:19
 **/
public class Selection {
    //排序逻辑
    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length-1; i++) {
            for (int j = i; j < a.length-1; j++) {
                if(greater(a[j],a[j+1])){
                    exch(a,j,j+1);
                }
            }
        }
    }

    //比较元素大小
    public static boolean greater(Comparable a, Comparable b) {
        return a.compareTo(b) > 0;
    }

    //交换元素
    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        Integer[] a = {4, 5, 6, 3, 2, 1};
        Bubble.sort(a);
        System.out.println(Arrays.toString(a));
    }
}

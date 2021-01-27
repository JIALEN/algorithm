package com.alen.algorithm.review.sort;

import java.util.Arrays;

/**
 * @author lijialun
 * @Desc 冒泡排序
 * @create 2020-12-26 12:52
 **/
public class Bubble {
    //数组进行排序
    public static void sort(Comparable[] arr) {
        for (int i = arr.length-1; i >0; i--) {
            for (int j = 0; j < i; j++) {
                if (greater(arr[j], arr[j + 1])) {
                    exch(arr, j, j + 1);
                }
            }
        }
    }

    //比较两个元素的大小
    public static boolean greater(Comparable a, Comparable b) {
        return a.compareTo(b) > 0;
    }

    //交换两个元素的位置
    public static void exch(Comparable[] a, int i, int j) {
      Comparable t=a[i];
      a[i]=a[j];
      a[j]=t;
    }

    public static void main(String[] args) {
        Integer[] a = {4, 5, 6, 3, 2, 1};
        Bubble.sort(a);
        System.out.println(Arrays.toString(a));
    }
}

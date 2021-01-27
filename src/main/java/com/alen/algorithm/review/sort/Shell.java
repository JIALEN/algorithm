package com.alen.algorithm.review.sort;

import java.util.Arrays;

/**
 * @author lijialun
 * @Desc 希尔排序
 * @create 2020-12-26 14:12
 **/
public class Shell {

    //使用希尔分组选择排序
    public static void sort(Comparable[] a) {
        int N = a.length; //确定增长量h的最大值
        int h = 1;
        while (h < N / 2) {
            h = h * 2 + 1;
        }
        // 当增长量h小于1，排序结束
        while (h >= 1) {
            // 找到待插入的元素
            for (int i = h; i < N; i++) {
                // a[i]就是待插入的元素
                // 把a[i]插入到a[i-h],a[i-2h],a[i-3h]...序列中
                for (int j = i; j >= h; j -= h) {
                    // a[j]就是待插入元素，依次和a[j-h],a[j-2h],a[j-3h]进行比较，如果a[j]小，那么 交换位置，如果不小于，a[j]大，则插入完成。
                    if (greater(a[j - h], a[j])) {
                        exch(a, j, j - h);
                    } else {
                        break;
                    }
                }
            }
            h /= 2;
        }
    }

    //比较两个元素的大小
    public static boolean greater(Comparable a, Comparable b) {
        return a.compareTo(b) > 0;
    }

    //交互元素大小
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

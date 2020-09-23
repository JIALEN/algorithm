package com.alen.algorithm.until;

import java.util.Arrays;

/**
 * @author lijialun
 * @Desc
 * @create 2020-09-23 13:36
 **/
public class Merge {

    public static Comparable[] assist = null;

    //对comparables数组中的元素进行排序
    public static void sort(Comparable[] comparables) {
        assist = new Comparable[comparables.length];
        int start = 0;
        int end = comparables.length - 1;
        sort(comparables, start, end);
    }

    //对comparables数组中start与end之间的元素进行排序
    public static void sort(Comparable[] comparables, int start, int end) {
        if (end <= start) {
            return;
        }
        int z = start + (end - start) / 2;
        sort(comparables, start, z);
        sort(comparables, z + 1, end);
        merge(comparables, start, z, z + 1, end);
    }

    public static void merge(Comparable[] comparables, int start, int end, int start2, int end2) {
        int i = start;
        int p1 = start;
        int p2 = start2;
        while (p1 <= end && p2 <= end2) {
            if (greater(comparables[p1], comparables[p2])) {
                assist[i++] = comparables[p2++];
            } else {
                assist[i++] = comparables[p1++];
            }
        }
        while (p1 <= end) {
            assist[i++] = comparables[p1++];
        }
        while (p2 <= end2) {
            assist[i++] = comparables[p2++];
        }
        for (int j = start; j <=end2; j++) {
            comparables[j] = assist[j];
        }
    }

    //比较
    public static boolean greater(Comparable a, Comparable b) {
        return a.compareTo(b) > 0;
    }

    public static void main(String[] args) {
        Integer[] integers = new Integer[]{6,1,8,3,4,1,6,0,8,7, 9, 6, 2, 3, 1, 5, 9};
        Merge.sort(integers);
        System.out.println(Arrays.toString(integers));
    }
}

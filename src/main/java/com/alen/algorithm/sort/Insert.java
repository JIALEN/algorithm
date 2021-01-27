package com.alen.algorithm.sort;

import java.util.Arrays;

/**
 * @author lijialun
 * @Desc
 * @create 2020-09-18 13:15
 **/
public class Insert {

    //排序
    public static void sort(Comparable[] comparables) {
        for (int i = 1; i <comparables.length-1 ; i++) {
            for (int j = i; j >0 ; j--) {
                if(greater(j-1,j)){
                    exch(comparables,j-1,j);
                }else {
                    //因为以前已经是有序的了，所以出现这种情况，j肯定比前面所有的都大
                    break;
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


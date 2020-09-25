package com.alen.algorithm.until;

import java.util.Arrays;

/**
 * @author lijialun
 * @Desc
 * @create 2020-09-25 9:06
 **/
public class Quick {

    //比较
    public static boolean greater(Comparable a, Comparable b) {
        return a.compareTo(b) >0;
    }

    //交换
    public static void exch(Comparable[] comparables, int a, int b) {
        Comparable t = comparables[b];
        comparables[b] = comparables[a];
        comparables[a] = t;
    }

    public static void sort(Comparable[] comparables) {
        int min = 0;
        int max = comparables.length - 1;
        sort(comparables, min, max);
    }

    public static void sort(Comparable[] comparables, int min, int max) {
        if (min >= max) {
            return;
        }
        int z = segment(comparables, min, max);
        sort(comparables, min, z - 1);
        sort(comparables, z+1, max);
    }

    public static int segment(Comparable[] comparables, int min, int max) {
        Comparable key = comparables[min];
        int start = min ;
        int end = max+1 ;
        while (true) {
            while (greater(key, comparables[++start])) {
                if(start==max){
                    break;
                }
            }
            while (greater(comparables[--end], key)) {
                if(end==min){
                    break;
                }
            }
           if(start>=end){
               break;
           }else {
               exch(comparables,start,end);
           }
        }
        exch(comparables,min,end);
        return end;
    }

    public static void main(String[] args) {
        Integer[] integers = new Integer[]{6, 9, 8, 2, 3, 1, 9, 9};
        Quick.sort(integers);
        System.out.println(Arrays.toString(integers));
    }
}

package com.alen.algorithm.until;

import java.util.Arrays;

/**
 * @author lijialun
 * @Desc
 * @create 2020-09-21 9:26
 **/
public class Shell {

    public static void sort(Comparable[] comparables) {
        //确定增长量 h
        int N=comparables.length;
        int h=1;
        while (h<N/2){
            h=h*2+1;
        }
        System.out.println("h---:"+h);

        while (h>=1){
            for (int i = h; i < N; i++) {
                for (int j = i; j>=h ; j-=h) {
                  if(greater(comparables[j-h],comparables[j])){
                     exch(comparables,j-h,j);
                  }else {
                      break;
                  }
                }
                h=h/2;
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


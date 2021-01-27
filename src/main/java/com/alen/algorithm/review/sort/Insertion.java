package com.alen.algorithm.review.sort;

import java.util.Arrays;

/**
 * @author lijialun
 * @Desc 插入排序
 * @create 2020-12-26 13:35
 **/
public class Insertion {
    //对数组进行插入排序
    public  static void sort(Comparable[] a){
        for (int i = 1; i <a.length-1 ; i++) {
            for (int j = i; j >0; j--) {
                if(greater(a[j-1],a[j])){
                    exch(a,j-1,j);
                }else {
                    break;
                }
            }
        }
    }
    //比较元素大小
    public static boolean  greater(Comparable a,Comparable b){
        return a.compareTo(b)>0;
    }

    public  static  void exch(Comparable[] a,int i,int j){
        Comparable t=a[i];
        a[i]=a[j];
        a[j]=a[i];
    }
    public static void main(String[] args) {
        Integer[] a = {4, 5, 6, 3, 2, 1};
        Bubble.sort(a);
        System.out.println(Arrays.toString(a));
    }
}

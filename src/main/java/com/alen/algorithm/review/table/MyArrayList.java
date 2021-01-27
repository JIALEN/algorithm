package com.alen.algorithm.review.table;

/**
 * @author lijialun
 * @Desc
 * @create 2020-12-27 13:01
 **/

import java.util.Arrays;


public class MyArrayList implements MyList {

    private int size;
    private Object[] elementData;
    // JDK源码规定长度
    private static final int DEFAULT_CAPACITY = 10;

    // 构造方法 --- 空参
    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    // 有参构造方法
    public MyArrayList(int initialCapacity) {
        /*
         * 1.含参构造器
         * 2.要对传入的初始量的合法性进行检测
         * 3.通过新建数组实现
         */
        if (initialCapacity < 0) {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        elementData = new Object[initialCapacity];
    }

    // 返回长度
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        // 返回长度是否为0即可
        return size == 0;
    }

    // 暂时只考虑直接equals的情况
    @Override
    public boolean contains(Object o) {
        for (Object old : elementData) {
            if (o.equals(old)) {
                return true;
            }
        }
        return false;
    }

    // 清除数组
    @Override
    public void clear() {
        elementData = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public boolean add(Object object) {
        ensureCapacity();
        elementData[size] = object;
        size++;
        return true;
    }

    @Override
    public boolean remove(int index) {
        /*
         * 1.下标合法性检测
         * 2.删除指定下标对象，并返回其值
         * 3.通过数组复制实现
         * 4.因为前移，数组最后一位要置为空
         */
        rangeCheck(index);
        int arrnums = size - index - 1;
        if (arrnums > 0) {
            // 思路：从被删除的索引的下一位开始复制给新的当前数组索引的起始位置，长度为size - index - 1 --- 数学问题
            System.arraycopy(elementData, index + 1, elementData, index, arrnums);
        }
        elementData[--size] = null;
        return true;
    }

    @Override
    public Object get(int index) {
        rangeCheck(index);
        return elementData[index];
    }

    // 数组容量检测方法 --- 如果超了就得扩容
    private void ensureCapacity() {
        if (size == elementData.length) {
            Object[] newArray = new Object[size * 2 + 1];
            System.arraycopy(elementData, 0, newArray, 0, elementData.length);
            elementData = newArray;
        }
    }

    // 对索引下标进行合法性检查
    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "elementData=" + Arrays.toString(elementData) +
                '}';
    }
}

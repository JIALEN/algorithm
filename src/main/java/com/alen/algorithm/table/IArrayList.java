package com.alen.algorithm.table;

import java.util.Objects;

/**
 * @author lijialun
 * @Desc
 * @create 2021-01-27 14:01
 **/
public class IArrayList<T> {
    //存储元素的数组
    private T[] array;
    //元素的数量
    private int size;

    //构造方法
    IArrayList(int capacity){
        this.array = (T[]) new Object[capacity];
    }

    //无参构造
    IArrayList(){
        this(10);
    }

    public int getSize(){
        return size;
    }

    //添加元素到尾部
    public void add(T t) {
        add(t,size);
    }

    //添加元素到索引位置
    public void add(T t,int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("角标越界");
        }
        //检查数组容量
        if (size == this.array.length){
            //先扩容
            resize();
        }
        //移动元素
        System.arraycopy(array,index,array,index+1,size-index);
        //插入
        this.array[index] = t;
        size++;
    }

    //判空
    public boolean isEmpty(){
        return this.size == 0;
    }

    //扩容
    private void resize(){
        //计算新数组长度
        int newLength = array.length * 2 + 1;
        //创建数组
        T[] newArray = (T[]) new Object[newLength];
        //复制
        System.arraycopy(array,0,newArray,0,size);
        //指向
        array = newArray;
    }

    //按索引查询元素
    public T get(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("角标越界");
        }
        return array[index];
    }

    //根据索引设置元素值
    public void set(T t,int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("角标越界");
        }
        array[index] = t;
    }

    //移除索引处的元素
    public T remove(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("角标越界");
        }
        //获取要移除的目标元素
        T targetElement = array[index];
        //将targetElement之后的元素向前移动一个位置
        for (int i = index; i < size-1; i++) {
            array[i] = array[i+1];
        }
        array[size-1] = null;
        size--;
        return targetElement;
    }

    //移除指定元素(存在多个相等的元素时,只移除第一个)
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            //注意元素为null的情况
            if (Objects.equals(array[i],o)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            //注意处理array[i] == null的情况
            sb.append("[" + (array[i] == null ? "null" : array[i].toString()) + "]");
        }
        return sb.toString();
    }

}

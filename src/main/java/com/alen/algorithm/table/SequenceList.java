package com.alen.algorithm.table;

import java.util.Iterator;

/**
 * @author lijialun
 * @Desc 顺序表
 * @create 2020-10-02 14:32
 **/
public class SequenceList<T> implements Iterable {

    //存储元素的数组
    private T[] eles;
    //当前线性表的长度
    private int N;

    //创建容量为capacity的SequenceList对象
    SequenceList(int capacity) {
        eles = (T[]) new Object[capacity];
    }

    //    空置线性表
    public void clear() {
        this.N = 0;
    }

    //判断线性表是否为空，是返回true，否返回false
    public boolean isEmpty() {
        return N == 0 ? true : false;
    }

    //获取线性表中元素的个数
    public int length() {
        return this.N;
    }

    //读取并返回线性表中的第i个元素的值
    public T get(int i) throws Exception {
        if (i < 0 || i >= N) {
            throw new Exception("元素不存在");
        }
        return eles[i];
    }

    //在线性表的第i个元素之前插入一个值为t的数据元素。
    public void insert(int i, T t) {
        if (i == eles.length) {
            throw new RuntimeException("当前表已满");
        }
        if (i < 0 || i > N) {
            throw new RuntimeException("插入的位置不合法");
        }
        //把i位置空出来，i位置及其后面的元素依次向后移动一位
        for (int j = N; j > i; j--) {
            eles[j] = eles[j - 1];
        }
        // 把t放到i位置处
        eles[i] = t;
        // 元素数量+1
        N++;
    }

    //向线性表中添加一个元素t
    public void insert(T t) {
        if (N == eles.length) {
            resize(eles.length * 2);
        }
        eles[N++] = t;
    }

    //删除并返回线性表中第i个数据元素。
    public T remove(int i) {
        if (i < 0 || i > N - 1) {
            throw new RuntimeException("当前要删除的元素不存在");
        }
        //记录i位置处的元素
        T result = eles[i];
        // 把i位置后面的元素都向前移动一位
        for (int index = i; index < N - 1; index++) {
            eles[index] = eles[index + 1];
        }
        //当前元素数量
        N--;
        return result;
    }

    //返回线性表中首次出现的指定的数据元素的位序号，若不存在，则返回-1。
    public int indexOf(T t) {
        if (t == null) {
            throw new RuntimeException("查找的元素不合法");
        }
        for (int i = 0; i < N; i++) {
            if (eles[i].equals(t)) {
                return i;
            }
        }
        return -1;
    }

    //改变容量
    private void resize(int newSize) {
        //记录旧数组
        T[] temp = eles;
        //创建新数组
        eles = (T[]) new Object[newSize];
        //把旧数组中的元素拷贝到新数组
        for (int i = 0; i < N; i++) {
            eles[i] = temp[i];
        }
    }

    public int capacity() {
        return eles.length;
    }

    public static void main(String[] args) throws Exception {
//        //创建顺序表对象
//        SequenceList<String> sl = new SequenceList<>(10);
//        //测试插入
//        sl.insert("姚明"); sl.insert("科比");
//         sl.insert("麦迪"); sl.insert(1,"詹姆斯");
//         //测试获取
//        String getResult = sl.get(1);
//        System.out.println("获取索引1处的结果为："+getResult);
//        //测试删除
//        String removeResult = sl.remove(0);
//        System.out.println("删除的元素是："+removeResult);
//        // 测试清空
//        sl.clear();
//        System.out.println("清空后的线性表中的元素个数为:"+sl.length());


        SequenceList<String> squence = new SequenceList<>(5); //测试遍历
        squence.insert(0, "姚明");
        squence.insert(1, "科比");
        squence.insert(2, "麦迪");
        squence.insert(3, "艾佛森");
        squence.insert(4, "卡特");
        for (Object s : squence) {
            System.out.println(s);
        }
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator {
        private int cur;

        public SIterator() {
            this.cur = 0;
        }

        @Override
        public boolean hasNext() {
            return this.cur < N;
        }


        @Override
        public Object next() {
            return eles[cur++];
        }


    }
}

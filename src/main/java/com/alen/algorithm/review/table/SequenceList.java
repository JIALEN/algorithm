package com.alen.algorithm.review.table;


import java.util.Iterator;

/**
 * @author lijialun
 * @Desc 顺序表
 * @create 2020-12-27 10:37
 **/
public class SequenceList<T> implements Iterable<T> {
    //存储元素的数组
    private T[] eles;
    //记录当前顺序表中的元素个数
    private int N;

    //构造方法
    public SequenceList(int capacity) {
        eles = (T[]) new Object[capacity];
        N = 0;
    }

    //容量
    public int capacity() {
        return eles.length;
    }

    //空置线性表
    public void clear() {
        this.N = 0;
    }

    //判断当前线性表是否为空表
    public boolean isEmpty() {
        return this.N == 0;
    }

    //获取线性表的长度
    public int length() {
        return this.N;
    }

    //获取指定位置的元素
    public T get(int i) {
        if (i < 0 || i > N) {
            throw new RuntimeException("数组下标越界");
        }
        return eles[i];
    }

    //向指定位置插入元素
    public void insert(int i, T t) {
        if (N == eles.length) {
            throw new RuntimeException("当前表已满");
        }
        if (i < 0 || i > N) {
            throw new RuntimeException("插入的位置不合法");
        }
        //元素已经放满了数组，需要扩容
        if (N == eles.length) {
            resize(eles.length * 2);
        }
        // 把i位置空出来，i位置及其后面的元素依次向后移动一位
        for (int j = N; j > i; j--) {
            eles[j] = eles[j - 1];
        }
        eles[i] = t;
        N++;
    }

    //向数组末尾插入元素
    public void insert(T t) {
        if (eles.length == N) {
            throw new RuntimeException("数组已满");
        }
        eles[N++] = t;
    }

    //删除指定位置的元素并返回元素
    public T remove(int i) {
        if (i < 0 || i > N) {
            throw new RuntimeException("当前元素不存在");
        }
        T result = eles[i];
        for (int j = N; j > i; j--) {
            eles[j] = eles[j + 1];
        }
        N--;
        //当元素已经不足数组大小的1/4,则重置数组的大小
        if (N > 0 && N < eles.length / 4) {
            resize(eles.length / 2);
        }
        return result;
    }

    //重新设置数组大小
    public void resize(int newSize) {
        T[] oldEles = eles;
        eles = (T[]) new Object[newSize];
        for (int i = 0; i < N; i++) {
            eles[i] = oldEles[i];
        }
    }

    //返回元素的索引
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

    private class SIterator implements Iterator {
        private int cur;

        private SIterator() {
            cur = 0;
        }

        @Override
        public boolean hasNext() {
            return cur < N;
        }

        @Override
        public Object next() {
            return eles[cur++];
        }
    }

    //测试代码
    public static void main(String[] args) {
        //创建顺序表对象
        SequenceList<String> sl = new SequenceList<>(10);
        //测试插入
        sl.insert("姚明");
        sl.insert("科比");
        sl.insert("麦迪");
        sl.insert(1, "詹姆斯");
        //测试获取
        String getResult = sl.get(1);
        System.out.println("获取索引1处的结果为：" + getResult);
        //测试删除
        String removeResult = sl.remove(0);
        System.out.println("删除的元素是：" + removeResult);
        //测试清空
        sl.clear();
        System.out.println("清空后的线性表中的元素个数为:" + sl.length());
    }

    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }
}


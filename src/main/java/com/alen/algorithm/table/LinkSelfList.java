package com.alen.algorithm.table;

import java.util.Iterator;

/**
 * @author lijialun
 * @Desc
 * @create 2020-10-02 17:57
 **/
public class LinkSelfList<T> implements Iterable<T> {
    //记录头结点
    private Node head;
    //链表长度
    private int N;

    public LinkSelfList(int n) {
        head = new Node(null, null);
        N = n;
    }

    //空置线性表
    public void clear() {
        head.item = null;
        N = 0;
    }

    //判断线性表是否为空，是返回true，否返回false
    public boolean isEmpty() {
        return N == 0 ? true : false;
    }

    //获取线性表中元素的个数
    public int length() {
        return N;
    }

    //读取并返回线性表中的第i个元素的值
//获取指定位置i出的元素
    public T get(int i) {
        if (i < 0 || i >= N) {
            throw new RuntimeException("位置不合法！");
        }
        Node n = head.next;
        for (int index = 0; index < i; index++) {
            n = n.next;
        }
        return n.item;
    }

    //往线性表中添加一个元素
    public void insert(T t) {
        Node nodeOld = head.next;
        Node newNode = new Node(t, nodeOld);
        head.next = newNode;
        //长度+1
        N++;
    }

    //在线性表的第i个元素之前插入一个值为t的数据元素
    public void insert(int i, T t) {
        if (i < 0 || i >= N) {
            throw new RuntimeException("位置不合法！");
        }
        Node pre = head;
        for (int index = 0; index <= i - 1; index++) {
            pre = pre.next;
        }
        //位置i的结点
        Node curr = pre.next;
        Node newNode = new Node(t, curr);
        pre.next = newNode;
        //长度+1
        N++;
    }

    //删除并返回线性表中第i个数据元素。
    public T remove(int i) {
        if (i < 0 || i >= N) {
            throw new RuntimeException("位置不合法！");
        }
        Node pre = head;
        for (int index = 0; index <= i - 1; index++) {
            pre = pre.next;
        }
        //位置i的结点
        Node curr = pre.next;
//        Node newNode = new Node( t,curr);
        pre.next = curr.next;
        N--;
        return (T) curr.item;
    }

    //返回线性表中首次出现的指定的数据元素的位序号，若不存在，则
    //    返回-1
    public int indexOf(T t) {
        Node n = head;
        for (int i = 0; n.next != null; i++) {
            n = n.next;
            if (n.item.equals(t)) {
                return i;
            }
        }
        return 0;
    }

    private class Node {
        //存储数据
        T item;
        //  下一个结点
        Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    @Override
    public Iterator iterator() {
        return new LIterator();
    }

    private class LIterator implements Iterator<T> {
        private Node n;

        public LIterator() {
            this.n = head;
        }

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public T next() {
            n = n.next;
            return n.item;
        }
    }

    public static void main(String[] args) {
        //测试代码
        LinkSelfList<String> list = new LinkSelfList<>(8);
        list.insert(0, "张三");
        list.insert(1, "李四");
        list.insert(2, "王五");
        list.insert(3, "赵六"); //测试length方法
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println(list.length());
        System.out.println("-------------------");
        //测试get方法
        System.out.println(list.get(2));
        System.out.println("------------------------");
        //测试remove方法
        String remove = list.remove(1);
        System.out.println(remove);
        System.out.println(list.length());
        System.out.println("----------------");
        for (String s : list) {
            System.out.println(s);
        }
    }
}


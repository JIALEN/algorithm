package com.alen.algorithm.review.table;

import java.util.Iterator;

/**
 * @author lijialun
 * @Desc 单向链表
 * @create 2020-12-27 13:17
 **/
public class LinkList<T> implements Iterable<T> {
    class Node { //存储元素
        public T item;
        // 指向下一个结点
        public Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    //记录首结点
    private Node head;
    //记录链表的长度
    private int N;

    public LinkList() { //初始化头结点
        head = new Node(null, null);
        N = 0;
    }

    //获取链表长度
    public int length() {
        return N;
    }

    //清空链表
    public void clear() {
        head.next=null;
        head.item=null;
        N = 0;
    }

    //判断线性表是否为空，是返回true，否返回false
    public boolean isEmpty() {
        return N == 0;
    }

    //获取指定位置i出的元素
    public T get(int i) {
        if (i < 0 || i >= N) {
            throw new RuntimeException("位置不合法！");
        }
        Node n = head.next;
        for (int j = 0; j < i; j++) {
            n = n.next;
        }
        return n.item;
    }

    //往线性表中添加一个元素
    public void insert(T t) {
        //找到最后一个元素
        Node node = head.next;
        while (node != null) {
            node = node.next;
        }
        //构建一个新的节点
        Node newNode = new Node(t, null);
        //链表长度+1
        node.next = newNode;
        N++;
    }

    //往线性表中添加一个元素
    public void insert(int i, T t) {
        if (i < 0 || i > N) {
            throw new RuntimeException("位置不合法！");
        }
        //寻找位置i之前的结点
        Node pre = head;
        for (int j = 0; j < i - 1; j++) {
            pre = pre.next;
        }
        Node cur = pre.next;
        Node newNode = new Node(t, cur);
        pre.next = newNode;
        N++;
    }


    //删除指定位置i处的元素，并返回被删除的元素
    public T remove(int i) {
        if (i < 0 || i >= N) {
            throw new RuntimeException("位置不合法");
        }
        // 寻找i之前的元素
        Node pre = head;
        for (int index = 0; index <= i - 1; index++) {
            pre = pre.next;
        }
        // 当前i位置的结点
        Node curr = pre.next;
        // 前一个结点指向下一个结点，删除当前结点
        pre.next = curr.next;
        // 长度-1
        N--;
        return curr.item;
    }

    //查找元素t在链表中第一次出现的位置
    public int indexOf(T t) {
        Node n = head;
        for (int i = 0; n.next != null; i++) {
            n = n.next;
            if (n.item.equals(t)) {
                return i;
            }
        }
        return -1;
    }


    @Override
    public Iterator<T> iterator() {
        return new LinkListIterator();
    }

    private class LinkListIterator implements Iterator<T> {
        private Node n;

        public LinkListIterator() {
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

    public static void main(String[] args) throws Exception {
        LinkList<String> list = new LinkList<>();
        list.insert(0, "张三");
        list.insert(1, "李四");
        list.insert(2, "王五");
        list.insert(3, "赵六");
        //测试length方法
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println(list.length());
        System.out.println("-------------------"); //测试get方法
        System.out.println(list.get(2));
        System.out.println("------------------------"); //测试remove方法
        String remove = list.remove(1);
        System.out.println(remove);
        System.out.println(list.length());
        System.out.println("----------------");
        ;
        for (String s : list) {
            System.out.println(s);
        }
    }
}

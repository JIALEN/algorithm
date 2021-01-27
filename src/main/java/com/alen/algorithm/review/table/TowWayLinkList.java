package com.alen.algorithm.review.table;

import java.util.Iterator;

/**
 * @author lijialun
 * @Desc 双向队列
 * @create 2020-12-27 13:59
 **/
public class TowWayLinkList<T> implements Iterable<T> {

    @Override
    public Iterator<T> iterator() {
        return new TIterator();
    }

    class Node {
        //数据
        private T item;
        //前节点
        private Node pre;
        //下一个节点
        private Node next;

        public Node(T item, Node pre, Node next) {
            this.item = item;
            this.pre = pre;
            this.next = next;
        }
    }

    //首结点
    private Node head;
    //记录尾结点
    private Node last;
    // 记录链表的长度
    private int N;

    public TowWayLinkList() {
        last = null;
        head = new Node(null, null, null);
        N = 0;
    }

    //清空链表
    public void clear() {
        this.head.item = null;
        this.last = null;
        this.head.next = last;
        N = 0;
    }

    //判断线性表是否为空，是返回true，否返回false
    public boolean isEmpty() {
        return N == 0;
    }

    //获取线性表中元素的个数
    public int length() {
        return N;
    }

    //插入元素t
    public void insert(T t) {
        if (last == null) {
            last = new Node(t, head, null);
            head.next = last;
        } else {
            Node oldLast = last;
            Node node = new Node(t, oldLast, null);
            oldLast.next = node;
            last = node;
        }
        //长度+1
        N++;
    }

    //向指定位置i处插入元素t
    public void insert(int i, T t) {
        if (i < 0 || i >= N) {
            throw new RuntimeException("位置不合法");
        }
        //找到位置i的前一个结点
        Node pre = head;
        for (int index = 0; index < i; index++) {
            pre = pre.next;
        }
        // 当前结点
        Node curr = pre.next; //构建新结点
        Node newNode = new Node(t, pre, curr);
        curr.pre = newNode;
        pre.next = newNode; //长度+1
        N++;
    }

    //读取并返回线性表中的第i个元素的值
    public T get(int i) {
        if (i < 0 || i >= N) {
            throw new RuntimeException("位置不合法");
        }//寻找当前结点
        Node curr = head.next;
        for (int index = 0; index < i; index++) {
            curr = curr.next;
        }
        return curr.item;
    }

    //找到元素t在链表中第一次出现的位置
    public int indexOf(T t) {
        Node n = head;
        for (int i = 0; n.next != null; i++) {
            n = n.next;
            if (n.next.equals(t)) {
                return i;
            }
        }
        return -1;
    }

    //删除位置i处的元素，并返回该元素
    public T remove(int i) {
        if (i < 0 || i >= N) {
            throw new RuntimeException("位置不合法");
        }
        //寻找i位置的前一个元素
        Node pre = head;
        for (int index = 0; index < i; index++) {
            pre = pre.next;
        }
        //i位置的元素
        Node curr = pre.next; //i位置的下一个元素
        Node curr_next = curr.next;
        pre.next = curr_next;
        curr_next.pre = pre; //长度-1；
        N--;
        return curr.item;
    }//获取第一个元素

    public T getFirst() {
        if (isEmpty()) {
            return null;
        }
        return head.next.item;
    }

    //获取最后一个元素
    public T getLast() {
        if (isEmpty()) {
            return null;
        }
        return last.item;
    }


    private class TIterator implements Iterator {
        private Node n = head;

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public Object next() {
            n = n.next;
            return n.item;
        }
    }

    public static void main(String[] args) throws Exception {
        TowWayLinkList<String> list = new TowWayLinkList<>();
        list.insert("乔峰");
        list.insert("虚竹");
        list.insert("段誉");
        list.insert(1, "鸠摩智");
        list.insert(3, "叶二娘");
        for (String str : list) {
            System.out.println(str);
        }
        System.out.println("----------------------");
        String tow = list.get(2);
        System.out.println(tow);
        System.out.println("-------------------------");
        String remove = list.remove(3);
        System.out.println(remove);
        System.out.println(list.length());
        System.out.println("--------------------");
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
    }
}

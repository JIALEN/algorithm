package com.alen.algorithm.table;

import java.util.Iterator;

/**
 * @author lijialun
 * @Desc
 * @create 2020-10-03 9:33
 **/
public class Queue<T> implements Iterable<T> {
    //记录首结点
    private Node head;
    //记录最后一个结点
    private Node last;
    //记录队列中元素的个数
    private int N;

    public Queue() {
        head = new Node(null, null);
        last = null;
        N = 0;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return N == 0;
    }

    //返回队列中元素的个数
    public int size() {
        return N;
    }

    public void enqueue(T t) {
        if (last == null) {
            Node lastNode = new Node(t, null);
            this.last = lastNode;
            head.next = lastNode;
        } else {
            Node oldNode = last.next;
            Node newNode = new Node(t, null);
            oldNode.next = newNode;
        }
        //个数+1
        N++;
    }

    //从队列中拿出一个元素
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        Node oldFirst = head.next;
        head.next = oldFirst.next;
        N--;
        if (isEmpty()) {
            last = null;
        }
        return oldFirst.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new QIterator();
    }

    private class QIterator implements Iterator<T> {
        private Node n = head;

        @Override
        public boolean hasNext() {
            return n.next != null;
        }


        @Override
        public T next() {
            Node node = head.next;
            n = n.next;
            return node.item;
        }
    }

    private class Node {
        public T item;
        public Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public static void main(String[] args) throws Exception {
        Queue<String> queue = new Queue<>();
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
        for (String str : queue) {
            System.out.print(str + " ");
        }
        System.out.println("-----------------------------");
        String result = queue.dequeue();
        System.out.println("出列了元素：" + result);
        System.out.println(queue.size());
    }
}

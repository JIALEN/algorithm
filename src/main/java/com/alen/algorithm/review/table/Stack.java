package com.alen.algorithm.review.table;

import java.util.Iterator;

/**
 * @author lijialun
 * @Desc
 * @create 2020-10-03 9:19
 **/
public class Stack<T> implements Iterable<T> {

    private Node head;

    private int N;

    public Stack() {
        this.head = new Node(null, null);
    }

    //判断当前栈中元素个数是否为0
    public boolean isEmpty() {
        return N == 0;
    }

    //把t元素压入栈
    public void push(T t) {
        Node oldNode = head.next;
        Node newNode = new Node(t, oldNode);
        head.next = newNode;
//        个数+1
        N++;
    }

    //弹出栈顶元素
    public T pop() {
        Node oldNode = head.next;
        if (oldNode == null) {
            return null;
        }
        head.next = head.next.next;
        N--;
        return oldNode.item;
    }

    //获取栈中元素的个数
    public int size() {
        return N;
    }

    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator<T> {
        private Node n = head;

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public T next() {
            Node node = n.next;
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
        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");

        stack.push("c");
        stack.push("d");
        for (String str : stack) {
            System.out.print(str + " ");
        }
        System.out.println("-----------------------------");
        String result = stack.pop();
        System.out.println("弹出了元素：" + result);
        System.out.println(stack.size());
    }

}


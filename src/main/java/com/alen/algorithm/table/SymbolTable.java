package com.alen.algorithm.table;

/**
 * @author lijialun
 * @Desc
 * @create 2020-10-03 9:58
 **/
public class SymbolTable<Key, Value> {
    //记录首结点
    private Node head;
    //记录符号表中元素的个数
    private int N;

    public SymbolTable() {
        head = new Node(null, null, null);
        N = 0;
    }

    //获取符号表中键值对的个数
    public int size() {
        return N;
    }

    //往符号表中插入键值对
    public void put(Key key, Value value) {
        Node n = head;
        while (n.next != null) {
            n = n.next;
            if (n.key.equals(key)) {
                n.value = value;
                return;
            }
        }
        Node oldNode = n.next;
        Node newNode = new Node(key, value, oldNode);
        oldNode.next = newNode;
        N++;

    }

    //删除符号表中键为key的键值对
    public void delete(Key key) {
        Node n = head;
        while (n.next != null) {
            if (n.next.key.equals(key)) {
                n.next = n.next.next;
                N--;
                return;
            }
            n = n.next;
        }
    }

    //从符号表中获取key对应的值
    public Value get(Key key) {
        Node n = head;
        while (n.next != null) {
            n = n.next;
            if (n.key.equals(key)) {
                return n.value;
            }
        }
        return null;
    }

    private class Node {
        //键
        public Key key; //值
        public Value value;
        public Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}

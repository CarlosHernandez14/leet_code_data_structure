package datastructures;

public class LinkedList <T> {

    static class Node <T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int length;

    public LinkedList(T value) {
        Node<T> node = new Node<T>(value);
        this.head = node;
        this.tail = node;
        this.length = 1;
    }

    public void printList() {
        Node<T> temp = head;
        while(temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void append(T value) {
        Node<T> newNode = new Node<T>(value);
        if (length <= 0) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }

        this.tail.next = newNode;
        this.tail = newNode;
        this.length++;
    }

    public void prepend(T value) {
        Node<T> newNode = new Node<>(value);
        if (this.length == 0) this.head = this.tail = newNode;

        newNode.next = this.head;
        this.head = newNode;
        this.length++;
    }

    public T removeFirst() {
        if (this.length == 0) return null;
        if (this.length == 1) this.head = this.tail = null;

        Node<T> removedNode = this.head;
        this.head = this.head.next;
        removedNode.next = null;
        this.length--;
        return removedNode.value;
    }

    public T removeLast() {
        if (this.length == 0) return null;
        if (this.length == 1) return this.head.value;

        Node<T> temp = this.head, pre = this.head;

        while(temp.next != null) {
            pre = temp;
            temp = temp.next;
        }

        // Remove the reference to the last node from the pre node
        pre.next = null;

        return temp.value;
    }

    public T get(int index) {
        if (index < 0 || index >= this.length) return null;

        Node<T> temp = this.head;
        for (int i = 0; i < this.length; i++) {
            if (i == index) break;
            temp = temp.next;
        }

        return temp.value;
    }

    public boolean set(int index, T value) {
        if (this.length == 0) return false;
        Node<T> temp = this.head;

        for (int i = 0; i < this.length; i++) {
            if (i == index) {
                temp.value = value;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public T getHead() {
        return (T) this.head.value;
    }

    public T getTail() {
        return this.tail.value;
    }

    public int getLength() {
        return this.length;
    }

}


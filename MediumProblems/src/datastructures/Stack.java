package datastructures;

public class Stack <T> {

    static class Node <T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
        }
    }

    private Node<T> top;
    private int height;

    public Stack(T value) {
        this.top = new Node<T>(value);
        this.height = 1;
    }


    public void push(T value) {
        Node<T> newNode = new Node<>(value);
        if (this.height == 0) {
            this.top = newNode;
            height++;
            return;
        }

        newNode.next = this.top;
        this.top = newNode;
        this.height++;
    }

    public T pop() {
        if (this.height == 0) return null;

        Node<T> removedNode = this.top;
        this.top = this.top.next;
        removedNode.next = null;
        this.height--;
        return removedNode.value;
    }

    public void printStack() {
        Node<T> temp = top;
        while(temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public int getHeight() {
        return height;
    }

    public Node<T> getTop() {
        return top;
    }
}

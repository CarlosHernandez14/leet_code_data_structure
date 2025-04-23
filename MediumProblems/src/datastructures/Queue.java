package datastructures;

public class Queue <T> {

    static class Node <T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
        }
    }

    public Queue(T value) {
        Node<T> node = new Node<>(value);
        this.first = node;
        this.last = node;
        this.length = 1;
    }

    private Node<T> first;
    private Node<T> last;
    private int length;


    public void enqueue(T value) {
        Node<T> newNode = new Node<>(value);
        if (length <= 0) {
            this.first = newNode;
            this.last = newNode;
            this.length = 1;
            return;
        }

        this.last.next = newNode;
        this.last = newNode;
        this.length++;
    }

    public void printQueue() {
        Node<T> temp = first;
        while(temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }



}

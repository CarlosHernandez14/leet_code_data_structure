package datastructures;

import java.util.ArrayList;

public class DynamicCircularQueue <T> {

    private ArrayList<T> buffer;
    private int head = 0;
    private int size = 0;

    public DynamicCircularQueue() {
        buffer = new ArrayList<>();
    }

    public void enqueue(T value) {
        if (size == buffer.size())
            buffer.add(null); // Resize the arraylist

        int tailList = (this.head + this.size) % this.buffer.size();

        this.buffer.set(tailList, value);
        this.size++;
    }

    public T dequeue() {
        // Dequeue the first value of the list
        if (size == 0) return null;

        T removedValue = this.buffer.get(this.head);
        this.buffer.set(this.head, null);
        this.head = (this.head + 1) % buffer.size();
        size--;

        return removedValue;
    }

    public void printQueue() {
        for (int i = 0; i < this.size; i++) {
            int valIndex = (this.head + i) % this.buffer.size();
            System.out.println(this.buffer.get(valIndex));
        }
    }

    public T get(int index) {
        if (index < 0 || index >= this.size)
            throw new IndexOutOfBoundsException("Index (" + index + ") out of bounds for length: " + this.size);

        int actualIndex = (this.head + index) % this.buffer.size();
        return this.buffer.get(actualIndex);
    }


}

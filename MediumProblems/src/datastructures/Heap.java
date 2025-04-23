package datastructures;

import java.util.ArrayList;
import java.util.List;

public class Heap {

    private List<Integer> heap;

    public Heap() {
        this.heap = new ArrayList<Integer>();
    }

    public int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    public int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    public int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    public void swap(int index1, int index2) {
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    public void insert(int value) {

        // Add the value to the end of the list
        heap.add(value);
        // Check for parent nodes in case we need to swap it
        int currentIndex = heap.size() - 1;
        while (currentIndex > 0) {
            int parentInd = this.getParentIndex(currentIndex);

            if (parentInd < 0) break;

            if (this.heap.get(currentIndex) > this.heap.get(parentInd)) {
                // Swap them
                this.swap(currentIndex, parentInd);
                currentIndex = parentInd;
            } else break;

        }

    }

    public Integer remove() {
        if (this.heap.isEmpty()) return null;
        if (this.heap.size() == 1) return this.heap.remove(0);

        // Remove the top element of the list and replace it with the last one
        int removedValue = this.heap.get(0);
        this.heap.set(0, this.heap.remove(this.heap.size() - 1)); // Replace the head with the last element
        int currentIndex = 0, maxIndex = 0;
        // Start comparing
        while (currentIndex < this.heap.size()) {
            int leftChildInd = this.getLeftChildIndex(currentIndex);
            int rightChildInd = this.getRightChildIndex(currentIndex);

            if (leftChildInd < this.heap.size() && this.heap.get(leftChildInd) > this.heap.get(maxIndex)) {
                maxIndex = leftChildInd;
            }

            if (rightChildInd < this.heap.size() && this.heap.get(rightChildInd) > this.heap.get(maxIndex)) {
                maxIndex = rightChildInd;
            }

            if (maxIndex != currentIndex) {
                // Swap the nodes
                this.swap(currentIndex, maxIndex);
                currentIndex = maxIndex;
            } else break;
        }

        return removedValue;
    }

    public void printHeap() {
        System.out.println(this.heap);
    }

}

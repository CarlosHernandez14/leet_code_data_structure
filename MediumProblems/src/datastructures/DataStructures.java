package datastructures;

import java.util.Queue;

public class DataStructures {

    public static void main(String[] args) {


        Heap heap = new Heap();

        heap.insert(95);
        heap.insert(75);
        heap.insert(80);
        heap.insert(55);
        heap.insert(60);
        heap.insert(50);
        heap.insert(65);

        heap.printHeap();

        heap.remove();

        heap.printHeap();

        heap.remove();

        heap.printHeap();

    }

}

package datastructures;

import java.util.ArrayList;

public class HashTable <K, V> {

    static class Node <K, V> {
        K key;
        V value;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int size = 7;
    private Node<K, V>[] dataMap;

    @SuppressWarnings("unchecked")
    public HashTable() {
        this.dataMap = (Node<K, V>[]) new Node[this.size];
    }

    public V get(K key) {
        int index = this.hash(key);

        Node<K, V> temp = this.dataMap[index];
        while(temp != null) {
            if (temp.key.equals(key)) return temp.value;
            temp = temp.next;
        }

        return null;
    }

    public ArrayList<K> keys() {
        ArrayList<K> allKeys = new ArrayList<>();

        for (int i = 0; i < this.dataMap.length; i++) {
            Node<K, V> temp = this.dataMap[i];
            while(temp != null) {
                allKeys.add(temp.key);
                temp = temp.next;
            }
        }
        return allKeys;
    }

    public void printHashTable() {
        Node<K, V> temp;

        for (int i = 0; i < this.dataMap.length; i++) {
            System.out.print(i + ": ");
            temp = dataMap[i];
            while(temp != null) {
                System.out.print(temp.key + " = " + temp.value + ", ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    public void set(K key, V value) {
        int index = this.hash(key);
        // Set the value if exists
        if (dataMap[index] == null) {
            dataMap[index] = new Node<>(key, value);
            return;
        }

        // Iterate over the linked list
        Node<K, V> temp = dataMap[index];
        while(true) {
            // if key already exists, overwrite value and return
            if (temp.key.equals(key)) {
                temp.value = value;
                return;
            }
            // if we're at the tail, append a new node here and return
            if (temp.next == null) {
                temp.next = new Node<>(key, value);
                return;
            }
            // otherwise move on to the next node
            temp = temp.next;
        }
    }

    public int hash(K key) {
        return Math.abs(key.hashCode() % this.dataMap.length);
    }

}

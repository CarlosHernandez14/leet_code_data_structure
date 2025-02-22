package com.charly;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class DataStructuresJava {

    public static void main(String[] args) {

        LinkedList<String> lista = new LinkedList<>();
        lista.add("Java");
        lista.add("Python");

        System.out.println(lista); // Java, Python


        //  Pilas
        Stack<Integer> pila = new Stack<>();
        pila.push(1);
        pila.push(2);
        System.out.println(pila.pop()); // 2

        // Queue
        Queue<String> cola = new LinkedList<>();
        cola.add("Primero");
        cola.add("Segundo");

        System.out.println(cola.poll()); // Imprime primero

        // Deque
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(1);
        deque.addLast(2);
        System.out.println(deque); // Imprime [1, 2]


        // Hashset
        HashSet<String> conjunto = new HashSet<>();
        conjunto.add("Java");
        conjunto.add("Python");
        conjunto.add("Java"); // No agrega duplicado
        System.out.println(conjunto); // Imprime [Java, Python]

        // TreeSet
        TreeSet<Integer> arbol = new TreeSet<>();
        arbol.add(5);
        arbol.add(2);
        arbol.add(10);
        System.out.println(arbol); //  Imprime [2, 5, 10]


        // Priority Queue
        PriorityQueue<Integer> colaPrioridad = new PriorityQueue<>();
        colaPrioridad.add(10);
        colaPrioridad.add(5);
        colaPrioridad.add(20);
        System.out.println(colaPrioridad.poll()); // Imprime 5(menor prioridad)


        // HastTable
        Hashtable<Integer, String> tablaHash = new Hashtable<>();
        tablaHash.put(1, "Java");
        tablaHash.put(2, "Python");
        tablaHash.put(3, "C++");
        System.out.println(tablaHash.get(1)); // Imprime Java
        System.out.println(tablaHash); // Imprime {3=C, 2=Python, 1=Java}


        ConcurrentHashMap<Integer, String>  mapaConcurrente = new ConcurrentHashMap<>();
        mapaConcurrente.put(1, "HTML");
        mapaConcurrente.put(2, "CSS");
        mapaConcurrente.put(3, "JavaScript");
        System.out.println(mapaConcurrente.get(2)); // Imprime CSS
        System.out.println(mapaConcurrente); // {1=HTML, 2=CSS, 3=JavaScript}
    }

}

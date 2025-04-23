package datastructures;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

    private HashMap<String, ArrayList<String>> adjList;

    public Graph() {
        this.adjList = new HashMap<>();
    }

    public boolean addVertex(String vertex) {
        // { "A" = [], "B" = [] }
        if (!adjList.containsKey(vertex)){
            adjList.put(vertex, new ArrayList<String>());
            return true;
        }
        return false;
    }

    public boolean addEdge(String vertex1 , String vertex2) {
        if (adjList.containsKey(vertex1) && adjList.containsKey(vertex2)) {
            adjList.get(vertex1).add(vertex2);
            adjList.get(vertex2).add(vertex1);
            return true;
        }
        return false;
    }

    public boolean removeEdge(String vertex1, String vertex2) {
        if (adjList.containsKey(vertex1) && adjList.containsKey(vertex2)) {
            adjList.get(vertex1).remove(vertex2);
            adjList.get(vertex2).remove(vertex1);
            return true;
        }
        return false;
    }

    public boolean removeVertex(String vertex) {
        if (adjList.containsKey(vertex)) {
            ArrayList<String> vEdges = adjList.get(vertex);
            for (String currVertex : vEdges) {
                adjList.get(currVertex).remove(vertex);
            }
            // Remove the vertex
            this.adjList.remove(vertex);
            return true;
        }
        return false;
    }

    public void printGraph() {
        System.out.println(this.adjList);
    }



}

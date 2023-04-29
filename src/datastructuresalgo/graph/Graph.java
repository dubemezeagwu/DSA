package datastructuresalgo.graph;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
    private HashMap<String, ArrayList<String>> adjacentList = new HashMap<>();

    public void printGraph (){
        System.out.println(adjacentList);
    }

    public boolean addVertex (String vertex) {
        // Check if the vertex already exists in the graph
        if (adjacentList.get(vertex) == null) {
            // If it does not exist, add it to the graph with an empty adjacency list
            adjacentList.put(vertex, new ArrayList<String>());
            // Return true to indicate that the vertex was added successfully
            return true;
        }
        // If the vertex already exists, return false to indicate that it was not added
        return false;
    }

    public boolean addEdge (String vertexOne, String vertexTwo) {
        // Check if both vertices exist in the graph
        if (adjacentList.get(vertexOne) != null && adjacentList.get(vertexTwo) != null) {
            // If both vertices exist, add an edge between them in both directions
            adjacentList.get(vertexOne).add(vertexTwo);
            adjacentList.get(vertexTwo).add(vertexOne);
            // Return true to indicate that the edge was added successfully
            return true;
        }
        // If at least one vertex does not exist, return false to indicate that the edge was not added
        return false;
    }

    public boolean removeEdge (String vertexOne, String vertexTwo) {
        // Check if both vertices exist in the graph
        if (adjacentList.get(vertexOne) != null && adjacentList.get(vertexTwo) != null) {
            // If both vertices exist, remove the edge between them in both directions
            adjacentList.get(vertexOne).remove(vertexTwo);
            adjacentList.get(vertexTwo).remove(vertexOne);
            // Return true to indicate that the edge was removed successfully
            return true;
        }
        // If at least one vertex does not exist, return false
        // to indicate that the edge was not removed
        return false;
    }

    public boolean removeVertex(String vertex) {
        // Check if the vertex exists in the adjacency list
        if (adjacentList.get(vertex) == null) {
            // Vertex not found, return false
            return false;
        }
        // Iterate over all vertices adjacent to the given vertex
        for (String otherVertex : adjacentList.get(vertex)) {
            // Remove the given vertex from the adjacency list of each adjacent vertex
            adjacentList.get(otherVertex).remove(vertex);
        }
        // Remove the vertex from the adjacency list
        adjacentList.remove(vertex);
        // Return true to indicate successful removal
        return true;
    }

}

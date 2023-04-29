package datastructuresalgo.graph;

public class Main {
    public static void main(String[] args) {
        Graph myGraph = new Graph();
        myGraph.addVertex("C");
        myGraph.addVertex("D");

        myGraph.printGraph();

        myGraph.addEdge("C", "D");
        myGraph.printGraph();
    }
}

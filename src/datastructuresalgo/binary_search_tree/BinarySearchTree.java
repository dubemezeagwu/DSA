package datastructuresalgo.binary_search_tree;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    Node root;

    class Node {
        int value;
        Node left;
        Node right;

        Node (int value){
            this.value = value;
        }
    }

//    // Constructor where we have to set the root to a value on the creation of the BST
//    public BinarySearchTree (int value){
//        Node newNode = new Node(value);
//    }

    public boolean insert (int value){
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        }

        Node temp = root;
        while (true) {
            if (newNode.value == temp.value) return false;
            if (newNode.value < temp.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    public boolean contains (int value) {
        if (root == null) return false;

        Node temp = root;
        while (temp != null) {
            if (value < temp.value) {
                temp = temp.left;
            } else if (value > temp.value){
                temp = temp.right;
            } else {
                return true;
            }
        }
        return false;
    }

    // Recursive contains method
    private boolean recursiveContains (Node currentNode, int value){
        if (currentNode == null) return false;

        if (currentNode.value == value) return true;

        if (value < currentNode.value) {
            return recursiveContains(currentNode.left,value);
        } else {
            return recursiveContains(currentNode.right, value);
        }
    }

    public boolean recursiveContains (int value){
        return recursiveContains(root, value);
    }

    // Recursive insert method
    private Node recursiveInsert (Node currentNode, int value){
        if (currentNode == null) return new Node(value);

        if (value < currentNode.value) {
            currentNode.left = recursiveInsert(currentNode.left,value);
        } else {
            currentNode.right = recursiveInsert(currentNode.right, value);
        }
        return currentNode;
    }

    public void recursiveInsert (int value) {
        if (root == null) root = new Node(value);
        recursiveInsert(root,value);
    }

    // Recursive delete method
    private Node recursiveDelete (Node currentNode, int value){
        if (currentNode == null) return null;

        if (value < currentNode.value) {
            currentNode.left = recursiveDelete(currentNode.left,value);
        } else if (value > currentNode.value){
            currentNode.right = recursiveDelete(currentNode.right, value);
        } else {
            if (currentNode.left == null && currentNode.right == null) {
                return null;
            } else if (currentNode.left == null) {
                currentNode = currentNode.right;
            } else if (currentNode.right == null) {
                currentNode = currentNode.left;
            } else {
                int subTreeMin = minValue(currentNode.right);
                currentNode.value = subTreeMin;
                currentNode.right = recursiveDelete(currentNode.right, subTreeMin);
            }
        }
        return currentNode;
    }

    public void recursiveDelete (int value){
        recursiveDelete(root,value);
    }

    // Minimum value helper method
    private int minValue (Node currentNode) {
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }

    public ArrayList<Integer> breadthFirstSearch() {
        // Initialize currentNode with the root of the tree
        Node currentNode = root;

        // Create a queue to store nodes for BFS traversal
        Queue<Node> queue = new LinkedList<>();

        // Initialize an ArrayList to store visited node values
        ArrayList<Integer> results = new ArrayList<>();

        // Add the root node to the queue
        queue.add(currentNode);

        // Main loop for BFS traversal, continues until the queue is empty
        while (queue.size() > 0) {
            // Remove the first node from the queue and set it as currentNode
            currentNode = queue.remove();

            // Add the value of currentNode to the results ArrayList
            results.add(currentNode.value);

            // If currentNode has a left child, add it to the queue
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }

            // If currentNode has a right child, add it to the queue
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }

        // Return the results ArrayList containing the values of visited nodes in BFS order
        return results;
    }

    public ArrayList<Integer> depthFirstSearchPreOrder() {
        // Create an ArrayList to store the node values in the traversal order
        ArrayList<Integer> results = new ArrayList<>();

        // Define a local inner class named Traverse for recursive traversal
        class Traverse {
            // Constructor for Traverse class taking a Node as an argument
            Traverse(Node currentNode) {
                // Add the current node's value to the results list
                results.add(currentNode.value);

                // If the current node has a left child, recursively
                // traverse the left subtree
                if (currentNode.left != null) {
                    new Traverse(currentNode.left);
                }

                // If the current node has a right child, recursively
                // traverse the right subtree
                if (currentNode.right != null) {
                    new Traverse(currentNode.right);
                }
            }
        }

        // Start the pre-order traversal by creating a new
        // instance of Traverse with the root node
        new Traverse(root);

        // Return the results list containing the node values
        // in the pre-order traversal order
        return results;
    }


    public ArrayList<Integer> depthFirstSearchPostOrder() {
        // Initialize an empty ArrayList to store the post-order traversal result
        ArrayList<Integer> results = new ArrayList<>();

        // Define an inner class Traverse to perform the post-order traversal recursively
        class Traverse {
            // Constructor takes a Node as input and performs the traversal
            Traverse(Node currentNode) {
                // Recursively traverse the left subtree if the left child exists
                if (currentNode.left != null) {
                    new Traverse(currentNode.left);
                }
                // Recursively traverse the right subtree if the right child exists
                if (currentNode.right != null) {
                    new Traverse(currentNode.right);
                }
                // After traversing left and right subtrees, add the current node value to the results list
                results.add(currentNode.value);
            }
        }

        // Start the traversal with the root node of the tree
        new Traverse(root);
        // Return the post-order traversal result as an ArrayList of integers
        return results;
    }

    public ArrayList<Integer> depthFirstSearchInOrder() {
        // Create an ArrayList to store the in-order traversal results
        ArrayList<Integer> results = new ArrayList<>();

        // Define a nested class Traverse to perform the in-order traversal
        class Traverse {
            // Constructor for the Traverse class
            Traverse(Node currentNode) {
                // If the current node has a left child, explore the left subtree
                if (currentNode.left != null) {
                    new Traverse(currentNode.left);
                }
                // Add the current node's value to the results list
                results.add(currentNode.value);
                // If the current node has a right child, explore the right subtree
                if (currentNode.right != null) {
                    new Traverse(currentNode.right);
                }
            }
        }

        // Start the in-order traversal by creating a new Traverse object with the root node
        new Traverse(root);

        // Return the ArrayList containing the in-order traversal results
        return results;
    }

}

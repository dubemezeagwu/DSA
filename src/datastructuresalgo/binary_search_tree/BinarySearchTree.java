package datastructuresalgo.binary_search_tree;

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
}

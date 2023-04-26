package datastructuresalgo.stack;


public class Stack {
    private Node top;
    private int height;

    class Node {
        Node next;
        int value;

        Node (int value){
            this.value = value;
        }
    }

    public Stack (int value){
        Node newNode = new Node (value);
        this.top = newNode;
        this.height = 1;
    }

    public void printStack (){
        Node temp = top;
        while (temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getTop (){
        System.out.println("Top: " + top.value);
    }

    public void getHeight (){
        System.out.println("Height: " + height);
    }

    public void push(int value) {
        // Create a new node with the given value
        Node newNode = new Node(value);
        // If the stack is empty, set the new node as the top
        if(height == 0) {
            top = newNode;
        } else {
            // Otherwise, set the next node of the new node as the current top node,
            // and then set the new node as the new top node
            newNode.next = top;
            top = newNode;
        }
        // Increase the height of the stack by 1
        height++;
    }

    public Node pop() {
        // if the stack is empty, return null
        if(height == 0) return null;

        // create temporary variable that points to top node
        Node temp = top;
        // set the new top to point to the next node in the stack
        top = top.next;
        // set the next pointer of the temporary node to null
        temp.next = null;

        // decrease the height of the stack
        height--;
        // return the popped node
        return temp;
    }
}

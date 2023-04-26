package datastructuresalgo.queue;

public class Queue {
    private Node first;
    private Node last;
    private int length;


    class Node{
        int value;
        Node next;

        Node(int value){
            this.value = value;
        }
    }

    public Queue (int value){
        Node newNode = new Node(value);
        first = newNode;
        last = newNode;
        length = 1;
    }

    public void printQueue (){
        Node temp = first;
        while (temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getFirst (){
        System.out.println("First: " + first.value);
    }

    public void getLast (){
        System.out.println("Last: " + last.value);
    }

    public void getLength (){
        System.out.println("Length: " + length);
    }

    public void enqueue(int value) {
        // Create a new node with the given value
        Node newNode = new Node(value);
        // If the queue is empty, set the new node to be both the first and last element
        if (length == 0) {
            first = newNode;
            last = newNode;
        }
        // Otherwise, add the new node to the end of the queue
        else {
            // Set the next pointer of the current last node to the new node
            last.next = newNode;

            // Update the last pointer to point to the new node
            last = newNode;
        }
        // Increment the length of the queue to reflect the addition of the new element
        length++;
    }

    public Node dequeue() {
        // If the queue is empty, return null
        if(length == 0) return null;
        // Save a reference to the first node
        Node temp = first;
        // If there is only one node in the queue, set both first and last to null
        if(length == 1) {
            first = null;
            last = null;
        } else {
            // Otherwise, set the first node to be the next node in the queue
            first = first.next;
            // Set the next pointer of the removed node to null
            temp.next = null;
        }
        // Decrease the length of the queue by 1
        length--;
        // Return the removed node
        return temp;
    }
}

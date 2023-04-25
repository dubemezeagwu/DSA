package datastructuresalgo.doubly_linked_list;



public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;

     class Node {
        int value;
        Node next;
        Node prev;

        Node (int value){
            this.value = value;
        }
    }

    public DoublyLinkedList (int value){
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;
        length = 1;
    }

    public void printList (){
        Node temp = head;
        while (temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getHead (){
        System.out.println("Head: " + head.value);
    }

    public void getTail (){
        System.out.println("Tail: " + tail.value);
    }

    public void getLength (){
        System.out.println("Length: " + length);
    }

    public void append (int value) {
        // Create a new node with the given value.
        Node newNode = new Node(value);
        if(length == 0) {
            // If the list is empty, set both the head and tail to the new node.
            head = newNode;
            tail = newNode;
        } else {
            // Otherwise, add the new node to the end of the list by updating the `next` and `prev` fields of the relevant nodes.
            // Set the `next` field of the current tail node to the new node.
            tail.next = newNode;
            // Set the `prev` field of the new node to the current tail node.
            newNode.prev = tail;
            // Set the `tail` member variable to the new node.
            tail = newNode;
        }
        // Increment the `length` member variable by 1 to indicate that the list has one more node.
        length++;
    }

    public Node removeLast() {
        // If the list is empty, return null.
        if(length == 0) return null;
        // Create a new node `temp` to hold the value of the last node.
        Node temp = tail;
        // If the list contains only one node, set both `head` and `tail` to null.
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            // Otherwise, update the `tail` and `prev` fields of the second-to-last node
            // and the `next` and `prev` fields of the last node.
            // Set the `tail` to the previous node of the current tail.
            tail = tail.prev;
            // Set the `next` field of the new tail to `null`.
            tail.next = null;
            // Set the `prev` field of `temp` to `null`.
            temp.prev = null;
        }
        // Decrement the `length` by 1 to indicate that the list has one less node.
        length--;
        // Return the `temp` node, which holds the value of the removed last node.
        return temp;
    }

    public void prepend(int value) {
        // Create a new node with the given value.
        Node newNode = new Node(value);

        // If the list is empty, set both head and tail to the new node.
        if(length == 0) {
            head = newNode;
            tail = newNode;
        }
        // If the list is not empty, insert the new node at the head of the list.
        else {
            // Set the next field of the new node to point to the current head.
            newNode.next = head;
            // Set the prev field of the current head to point to the new node.
            head.prev = newNode;
            // Set the head of the list to be the new node.
            head = newNode;
        }
        // Increment the length of the list.
        length++;
    }

    public Node removeFirst() {
        // If the list is empty, return null
        if(length == 0) return null;

        // Get the first node
        Node temp = head;

        if(length == 1) { // If there is only one node in the list
            head = null;
            tail = null;
        } else { // If there are more than one nodes in the list
            // Set the head to the next node
            head = head.next;
            // Set the previous pointer of the new head to null
            head.prev = null;
            // Set the next pointer of the removed node to null
            temp.next = null;
        }

        // Decrease the length of the list
        length--;

        // Return the removed node
        return temp;
    }

    public Node get(int index) {
        // check if the index is out of bounds, return null if true
        if (index < 0 || index >= length) return null;
        // initialize a temporary node with the value of the head
        Node temp = head;
        // if the index is in the first half of the list
        if (index < length/2) {
            // iterate through the list from the head to the index
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            // if the index is in the second half of the list
            // initialize the temporary node with the value of the tail
            temp = tail;
            // iterate through the list from the tail to the index
            for (int i = length - 1; i > index; i--) {
                temp = temp.prev;
            }
        }
        // return the node at the given index
        return temp;
    }

    public boolean set(int index, int value) {
        // Get the node at the specified index
        Node temp = get(index);
        // If the node exists, set its value to the given value and return true
        if(temp != null) {
            temp.value = value;
            return true;
        }
        // If the node does not exist, return false
        return false;
    }

    public boolean insert(int index, int value) {
        // Return false if the index is out of range
        if(index < 0 || index > length) return false;
        // If index is 0, prepend the new value to the list
        if(index == 0) {
            prepend(value);
            return true;
        }
        // If index is equal to length, append the new value to the list
        if(index == length) {
            append(value);
            return true;
        }
        // Otherwise, create a new node with the given value
        Node newNode = new Node(value);
        // Get the node before the specified index
        Node before = get(index - 1);
        // Get the node after the specified index
        Node after = before.next;
        // Set the new node's previous and next pointers to the before and after nodes
        newNode.prev = before;
        newNode.next = after;
        // Update the next pointer of the before node and the previous pointer of the after node to point to the new node
        before.next = newNode;
        after.prev = newNode;
        // Increment the length of the linked list
        length++;
        // Return true to indicate that the value was successfully inserted
        return true;
    }

    public Node remove(int index) {
        // Check if index is out of range.
        if(index < 0 || index >= length) return null;

        // If index is the first element, remove it.
        if(index == 0) return removeFirst();

        // If index is the last element, remove it.
        if(index == length - 1) return removeLast();

        // Get the node to remove.
        Node temp = get(index);

        // Update the prev and next pointers to remove the node from the linked list.
        temp.next.prev = temp.prev;
        temp.prev.next = temp.next;

        // Set the next and prev pointers of the removed node to null.
        temp.next = null;
        temp.prev = null;

        // Decrement the length of the linked list.
        length--;

        // Return the removed node.
        return temp;
    }


    public void swapFirstAndLast () {
         // If there are less than 2 nodes in the list, there is nothing to swap
         if(length < 2) return;

         // Swap the values of the tail and the head nodes
         int temp = head.value;
         head.value = tail.value;
         tail.value = temp;

    }

    public void reverse (){
         Node current = head;
         Node temp = null;

         while (current != null){
             // swap the prev and next pointers of the current node
             temp = current.prev;
             current.prev = current.next;
             current.next = temp;
             // move to the next node
             current = current.prev;
         }
        // swap the head and tail pointers
         temp = head;
         head = tail;
         tail = temp;
    }

    public boolean isPalindrome (){
        // if the list has only 1 or 0 nodes, it's automatically a palindrome
        if (length <= 1) return true;

        // set up two pointers starting from opposite ends of the list
        Node forward = head;
        Node backward = tail;

        // iterate through the list until the two pointers meet in the middle
        for (int i = 0; i < length/2; i++){
            // if the values at the two pointers don't match, the list is not a palindrome
            if (forward.value != backward.value) return false;
            // move the pointers toward the center of the list
            forward = forward.next;
            backward = backward.prev;
        }
        // if the loop completes without returning false, the list is a palindrome
        return true;
    }

    public void swapPairs() {
        // Create a dummy node to keep track of the new head
        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;

        // Iterate through the list while there are
        // at least two nodes left to swap
        while (head != null && head.next != null) {
            // Identify the two nodes to be swapped
            Node firstNode = head;
            Node secondNode = head.next;

            // Swap the nodes and update connections
            prev.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            // Update prev pointers for the doubly linked list
            secondNode.prev = prev;
            firstNode.prev = secondNode;
            if (firstNode.next != null) {
                firstNode.next.prev = firstNode;
            }

            // Move to the next pair in the list
            head = firstNode.next;
            prev = firstNode;
        }

        // Update the head of the list to the new head
        head = dummy.next;
    }
}

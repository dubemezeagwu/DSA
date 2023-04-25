package datastructuresalgo.linked_list;

import java.util.HashSet;
import java.util.Set;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;

        Node (int value){
            this.value = value;
        }
    }

    public LinkedList (int value){
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
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

    public void append(int value) {
        // Create a new node with the given value
        Node newNode = new Node(value);
        // If the list is empty, have both head and tail
        // point at the new node.
        // The LL could become empty if the original node was removed.
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            // If the list is not empty, set the next node of the
            // current tail to the new node
            // and update the tail to be the new node
            tail.next = newNode;
            tail = newNode;
        }
        // Increment the length of the list
        length++;
    }

    public Node removeLast() {
        // if the length of the linked list is 0, return null
        if (length == 0) return null;

        // start at the head node
        Node temp = head;
        Node pre = head;
        // iterate through the linked list until the last node is reached
        while(temp.next != null) {
            pre = temp;  // keep track of the second-to-last node
            temp = temp.next;
        }
        // set the new tail node to be the second-to-last node
        tail = pre;
        // remove the reference to the former tail node
        tail.next = null;
        // decrement the length of the linked list
        length--;
        // if the linked list is now empty, set head and tail to null
        if (length == 0) {
            head = null;
            tail = null;
        }
        // return the removed node
        return temp;
    }


    public void prepend(int value) {
        // create a new node with the specified value
        Node newNode = new Node(value);
        // if the linked list is currently empty
        if (length == 0) {
            // set the new node as both the head and tail of the linked list
            head = newNode;
            tail = newNode;
        } else {
            // set the new node's next reference to the current head node
            newNode.next = head;
            // set the new node as the new head node of the linked list
            head = newNode;
        }
        // increment the length of the linked list
        length++;
    }

    public Node removeFirst() {
        // if the length of the linked list is 0, return null
        if (length == 0) return null;
        // save a reference to the current head node
        Node temp = head;
        // set the new head node to be the next node in the linked list
        head = head.next;
        // remove the reference to the former head node
        temp.next = null;
        // decrement the length of the linked list
        length--;
        // if the linked list is now empty, set tail to null
        if (length == 0) {
            tail = null;
        }
        // return the removed node
        return temp;
    }

    public Node get(int index) {
        // if the index is less than 0 or greater than or equal to the length of the linked list, return null
        if (index < 0 || index >= length) return null;
        // start at the head of the linked list
        Node temp = head;
        // traverse the linked list until the desired node is reached
        for(int i = 0; i < index; i++) {
            temp = temp.next;
        }
        // return the pointer to the node at the desired index
        return temp;
    }

    public boolean set(int index, int value) {
        // retrieve the node at the specified index
        Node temp = get(index);
        // if the index is out of bounds, return false
        if (temp != null) {
            // if the node is found, set the value of the node
            temp.value = value;
            // return true to indicate that the value was set successfully
            return true;
        }
        // return false if the index is out of bounds
        return false;
    }

    public boolean insert(int index, int value)  {
        // Check if the index is valid
        if (index < 0 || index > length) return false;

        // If the index is 0, insert at the beginning of the list
        if (index == 0) {
            prepend(value);
            return true;
        }

        // If the index is at the end, insert at the end of the list
        if (index == length) {
            append(value);
            return true;
        }

        // If the index is in the middle, insert the node
        // Create the new node
        Node newNode = new Node(value);

        // Get a pointer to the node at the previous index
        Node temp = get(index - 1);

        // Insert the new node by updating the next pointers
        newNode.next = temp.next;
        temp.next = newNode;

        // Update the length of the list
        length++;

        // Return true to indicate successful insertion
        return true;
    }

    // Remove the node at the specified index in the list
    public Node remove(int index) {
        // Check if the index is out of bounds
        if (index < 0 || index >= length) return null;
        // If the index is 0, remove the first node in the list
        if (index == 0) return removeFirst();
        // If the index is the last one in the list, remove the last node
        if (index == length - 1) return removeLast();

        // Get the previous node of the one to be removed
        Node prev = get(index - 1);
        // Get the node to be removed
        Node temp = prev.next;

        // Update the previous node's pointer to skip over the removed node
        prev.next = temp.next;
        // Detach the removed node from the list
        temp.next = null;
        // Decrease the length of the list
        length--;
        // Return the removed node
        return temp;
    }

    public void reverse() {
        // Set temp to the current head of the linked list
        Node temp = head;
        // Set the new head to be the current tail
        head = tail;
        // Set the new tail to be the previous head (stored in temp)
        tail = temp;

        // Set after to be the next node after the current head
        Node after = temp.next;
        // Initialize before to null, as the first node in the reversed list will not have a previous node
        Node before = null;

        // Loop through the linked list, reversing the order of the nodes
        for (int i = 0; i < length; i++) {
            // Set after to be the next node after the current node
            after = temp.next;
            // Set the current node's next pointer to the previous node
            temp.next = before;
            // Set before to be the current node, as it will be the previous node in the next iteration of the loop
            before = temp;
            // Set temp to be the next node in the linked list
            temp = after;
        }
    }

    // Find the middle node in a linked-list without using the length attribute.
    public Node findMiddleNode() {
        // Initialize slow pointer to the head of the linked list
        Node slow = head;

        // Initialize fast pointer to the head of the linked list
        Node fast = head;

        // Traverse the linked list with two pointers: slow and fast
        // slow moves one node at a time, while fast moves two nodes at a time
        while (fast != null && fast.next != null) {
            // Move slow pointer to the next node
            slow = slow.next;

            // Move fast pointer to the next two nodes
            fast = fast.next.next;
        }

        // Return the Node object representing the middle node of the linked list
        return slow;
    }

    public boolean hasLoop() {
        // Initialize slow pointer to the head of the linked list
        Node slow = head;

        // Initialize fast pointer to the head of the linked list
        Node fast = head;

        // Traverse the linked list with two pointers: slow and fast
        // slow moves one node at a time, while fast moves two nodes at a time
        while (fast != null && fast.next != null) {
            // Move slow pointer to the next node
            slow = slow.next;

            // Move fast pointer to the next two nodes
            fast = fast.next.next;

            // If slow pointer meets fast pointer, then there is a loop in the linked list
            if (slow == fast) {
                return true;
            }
        }

        // If the loop has not been detected after the traversal, then there is no loop in the linked list
        return false;
    }


    public void merge( LinkedList otherList) {
        Node l1 = head;
        Node l2 = otherList.head;
        Node dummy = new Node(0);
        Node curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.value < l2.value) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        if (l1 != null) {
            curr.next = l1;
        } else if (l2 != null) {
            curr.next = l2;
            tail = otherList.tail;
        }

        head = dummy.next;
        length += otherList.length;
    }

    public Node findKthFromEnd(int k) {
        Node slow = head; // Initialize slow pointer at head
        Node fast = head; // Initialize fast pointer at head

        // Move fast pointer k steps ahead
        for (int i = 0; i < k; i++) {
            if (fast == null) { // If k is out of bounds, return null
                return null;
            }
            fast = fast.next; // Move the fast pointer to the next node
        }

        // Move both pointers until fast reaches the end
        while (fast != null) {
            slow = slow.next; // Move the slow pointer to the next node
            fast = fast.next; // Move the fast pointer to the next node
        }

        return slow; // Return the kth node from the end (slow pointer)
    }

    public void reverseBetween(int m, int n) {
        // Return if the list is empty
        if (head == null) return;

        // Create a dummy node and connect it to the head
        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;

        // Move prev to the node just before the sublist
        for (int i = 0; i < m; i++) {
            prev = prev.next;
        }

        // Set current to the first node of the sublist
        Node current = prev.next;

        // Reverse the sublist iteratively
        for (int i = 0; i < n - m; i++) {
            // Save the next node in the original order
            Node temp = current.next;
            // Update current's next to skip temp
            current.next = temp.next;
            // Reverse the order of temp and current
            temp.next = prev.next;
            // Update prev's next to maintain reversed order
            prev.next = temp;
        }

        // Update the head of the list
        head = dummy.next;
    }


    public void partitionList(int x) {
        // Return if the list is empty
        if (head == null) return;

        // Create two dummy nodes for the new lists
        Node dummy1 = new Node(0);
        Node dummy2 = new Node(0);

        // Initialize pointers for the new lists
        Node prev1 = dummy1;
        Node prev2 = dummy2;

        // Start iterating from the head
        Node current = head;

        // Iterate through the linked list
        while (current != null) {
            // Add nodes to the new lists
            // based on their value
            if (current.value < x) {
                prev1.next = current;
                prev1 = current;
            } else {
                prev2.next = current;
                prev2 = current;
            }

            // Move to the next node
            current = current.next;
        }

        // Mark the end of the second list
        prev2.next = null;

        // Connect the two new lists
        prev1.next = dummy2.next;

        // Update the head of the list
        head = dummy1.next;
    }

    public void removeDuplicates() {
        // Create a set to store unique values
        Set<Integer> values = new HashSet<>();

        // Initialize the previous node as null
        Node previous = null;

        // Start at the head of the linked list
        Node current = head;

        // Iterate through the list until the end
        while (current != null) {
            // Check if the value is a duplicate
            if (values.contains(current.value)) {
                // Remove the current node from the list
                previous.next = current.next;

                // Decrement the list length by 1
                length -= 1;
            } else {
                // Add the unique value to the set
                values.add(current.value);

                // Update previous to the current node
                previous = current;
            }
            // Move to the next node in the list
            current = current.next;
        }
    }


}

package datastructuresalgo.doubly_linked_list;

import datastructuresalgo.linked_list.LinkedList;

public class Main {
    public static void main (String [] args) {
        DoublyLinkedList myDoublyLinkedList = new DoublyLinkedList(12);

        myDoublyLinkedList.getHead();
        myDoublyLinkedList.getTail();
        myDoublyLinkedList.getLength();

        myDoublyLinkedList.printList();
    }
}

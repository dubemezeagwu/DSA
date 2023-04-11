package datastructuresalgo.linked_list;

public class Main {
    public static void main (String[] args){
        LinkedList myLinkedList = new LinkedList(12);

        myLinkedList.append(24);
        myLinkedList.append(36);
        myLinkedList.append(48);
        myLinkedList.append(50);

        myLinkedList.getHead();
        myLinkedList.getTail();
        myLinkedList.getLength();

        System.out.println( myLinkedList.findMiddleNode().value);

        myLinkedList.printList();
    }
}

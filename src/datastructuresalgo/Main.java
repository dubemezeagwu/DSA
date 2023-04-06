package datastructuresalgo;

import datastructuresalgo.linked_list.LinkedList;
import datastructuresalgo.misc.classes.Cookie;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
//        Cookie cookieOne = new Cookie("red");
//        Cookie cookieTwo = new Cookie("purple");
//
//        System.out.println(cookieOne.getColor());
//        System.out.println(cookieTwo.getColor());

//        HashMap <String, Integer> hashMapOne = new HashMap<>();
//        HashMap <String, Integer> hashMapTwo = new HashMap<>();
//
//        hashMapOne.put("value", 240);
//        hashMapTwo = hashMapOne;
//
//        System.out.println(hashMapOne);
//        System.out.println(hashMapTwo);

        LinkedList myLinkedList = new LinkedList(12);

        myLinkedList.append(24);
        myLinkedList.append(36);
        myLinkedList.append(48);
        myLinkedList.append(50);

        myLinkedList.getHead();
        myLinkedList.getTail();
        myLinkedList.getLength();

        myLinkedList.printList();
    }
}

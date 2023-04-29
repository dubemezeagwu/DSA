package datastructuresalgo.hash_table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashTable {
    private int size = 7;
    private Node[] dataMap;

    class Node {
        String key;
        int value;
        Node next;

        Node (String key, int value){
            this.key = key;
            this.value = value;
        }
    }

    public HashTable (){
        dataMap = new Node[size];
    }

    public void printTable (){
        for (int i = 0; i < dataMap.length; i++){
            System.out.println(i + ":");
            Node temp = dataMap[i];
            while (temp != null){
                System.out.println("  {" + temp.key + "= " + temp.value + "}");
                temp = temp.next;
            }
        }
    }

    private int hash (String key) {
        int hash = 0;
        char [] keyChars = key.toCharArray();
        for (int i = 0; i < keyChars.length; i++){
            int asciiValue = keyChars[i];
            hash = (hash + asciiValue * 23) % dataMap.length;
        }
        return hash;
    }

    public void set(String key, int value) {
        // Get the index of the node based on the key
        int index = hash(key);

        // Create a new node with the given key and value
        Node newNode = new Node(key, value);

        // If the data map at the index is null, add the new node
        if (dataMap[index] == null) {
            dataMap[index] = newNode;
        } else {
            // If there is already a node at the index, traverse the linked list
            Node temp = dataMap[index];

            // If the first node's key matches the given key, update its value
            if (temp.key == key) {
                temp.value += value;
                return;
            }

            // Traverse the linked list until the end or a node with a matching key is found
            while (temp.next != null) {
                temp = temp.next;
                if (temp.key == key) {
                    temp.value += value;
                    return;
                }
            }

            // Add the new node to the end of the linked list
            temp.next = newNode;
        }
    }

    public int get(String key) {
        // Compute the hash code for the given key.
        int index = hash(key);
        // Get the head node of the linked list at the computed hash code index.
        Node temp = dataMap[index];
        // Traverse the linked list to find the node with the given key.
        while (temp != null) {
            // If we find a node with the given key, return its value.
            if (temp.key == key) return temp.value;
            // Move on to the next node in the linked list.
            temp = temp.next;
        }
        // If the key is not found, return 0.
        return 0;
    }

    public ArrayList keys() {
        // Create a new ArrayList to hold the keys
        ArrayList<String> allKeys = new ArrayList<>();

        // Loop through all the indices in the dataMap array
        for (int i = 0; i < dataMap.length; i++) {
            // Get the head node of the linked list at the current index
            Node temp = dataMap[i];

            // Loop through the linked list at the current index
            while (temp != null) {
                // Add the key of the current node to the allKeys ArrayList
                allKeys.add(temp.key);

                // Move to the next node in the linked list
                temp = temp.next;
            }
        }

        // Return the ArrayList containing all the keys
        return allKeys;
    }

    public static boolean itemInCommon (int[] arrayOne, int[] arrayTwo) {
        for (int i : arrayOne){
            for (int j : arrayTwo) {
                if (i == j) return true;
            }
        }
        return false;
    }

    public static boolean itemInCommonEfficient(int[] arrayOne, int[] arrayTwo) {
        HashMap <Integer, Boolean> myHashMap = new HashMap<>();
        for (int i : arrayOne) {
            myHashMap.put(i,true);
        }
        for (int j : arrayTwo) {
            if (myHashMap.get(j) != null) return true;
        }
        return false;
    }

    public static ArrayList<Integer> findDuplicates(int[] nums) {

        // Create a new HashMap to store the count of occurrences
        // of each integer.
        Map<Integer, Integer> numCounts = new HashMap<>();

        // Loop through each integer in the input array and update
        // its count in the HashMap.
        for (int num : nums) {
            numCounts.put(num, numCounts.getOrDefault(num, 0) + 1);
        }

        // Create a new ArrayList to store the duplicate integers.
        List<Integer> duplicates = new ArrayList<>();

        // Loop through each entry in the HashMap and check if the
        // count of occurrences is greater than 1.
        for (Map.Entry<Integer, Integer> entry : numCounts.entrySet()) {
            if (entry.getValue() > 1) {
                duplicates.add(entry.getKey());
            }
        }

        // Return the ArrayList of duplicate integers.
        return (ArrayList<Integer>) duplicates;
    }
}

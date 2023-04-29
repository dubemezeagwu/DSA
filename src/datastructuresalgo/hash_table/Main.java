package datastructuresalgo.hash_table;

public class Main {
    public static void main (String[] args){
        HashTable myHashTable = new HashTable();

        myHashTable.set("nails", 50);
        myHashTable.set("pens", 67);
        myHashTable.set("bikes", 41);
        myHashTable.set("knives", 74);
        myHashTable.set("bags", 39);
        myHashTable.set("ropes", 2);

        myHashTable.printTable();
        System.out.println(myHashTable.keys());
    }
}

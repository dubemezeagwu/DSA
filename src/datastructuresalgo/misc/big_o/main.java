package datastructuresalgo.misc.big_o;

class Main {
    // This code here is O(n), because it will give us n operations from our for-loop.
    public static void printItemsA (int n){
        for (int i = 0; i < n; i++){
            System.out.println("Number: " + i);
        }
    }


    // This code here is O(2n), because it will give us n+n operations for our two for-loops.
    // Although, O(2n) = O(n)
    public static void printItemsB (int n){
        for (int i = 0; i < n; i++){
            System.out.println("Number: " + i);
        }

        for (int j = 0; j < n; j++){
            System.out.println("Number: " + j);
        }
    }

    // This code here is O(n^2), because it will give us n*n operations for our nested for-loop.
    public static void printItemsC (int n){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                System.out.println("Numbers: " + i +" " + j);
            }
        }
    }

    // This code here is O(n^3), because it will give us n*n*n operations for our nested for-loop.
    // Although, O(n^3) = O(n^2)
    public static void printItemsD (int n){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                for (int k = 0; k < n; k++){
                    System.out.println("Numbers: " + i + " " + j + " " + k);
                }
            }
        }
    }

    // This code here is O(n^2 + n), because it will give us n*n operations + n operations
    // for our nested for-loop and another for-loop. Although O(n^2 + n) = O(n^2)
    public static void printItemsE (int n){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                System.out.println("Numbers: " + i + " " + j);
            }
        }

        for (int k = 0; k < n; k++){
            System.out.println("Numbers: " + k);
        }
    }

    public static void main (String [] args){
//        printItemsD(10);
//        printItemsC(10);
//        printItemsB(10);
//        printItemsA(10);
    }

}

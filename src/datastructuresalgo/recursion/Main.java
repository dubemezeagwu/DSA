package datastructuresalgo.recursion;

public class Main {
    public static void methodThree(){
        System.out.println("Three");
    }
    public static void methodTwo(){
        methodThree();
        System.out.println("Two");
    }
    public static void methodOne(){
        methodTwo();
        System.out.println("One");
    }
    public static void main(String[] args) {
        methodOne();
    }

    public static int factorial (int num){
        if (num == 1) return 1;
        return num * factorial(num - 1);
    }
}

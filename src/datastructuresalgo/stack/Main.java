package datastructuresalgo.stack;

public class Main {

    public static void main (String[] args){
        Stack myStack = new Stack(4);

        myStack.printStack();
        myStack.push(15);
        myStack.printStack();
        myStack.getTop();
        myStack.getHeight();
    }
}

package datastructuresalgo.linked_list;

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

    public void append (int value){
        Node newNode = new Node(value);
        if (length == 0){
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        length++;
    }

    public Node removeLast (){
        if (length == 0) return null;
        Node pre = head;
        Node temp = head;

        while (temp.next != null){
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;

        if(length == 0){
            head = null;
            tail = null;
        }

        return temp;
    }

    public void prepend (int value){
        Node newNode = new Node(value);

        if (length == 0){
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node removeFirst (){
        if (length == 0) return null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;

        if (length == 0){
            tail = null;
        }

        return temp;
    }

    public Node get (int index){
        if (index < 0 || index >= length){
            return null;
        }
        Node temp = head;
        for (int i = 0; i < index; i++){
            temp = temp.next;
        }
        return temp;
    }

    public boolean set (int index, int value){
        Node temp = get(index);
        if (temp != null){
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert (int index, int value){
        if (index < 0 || index > length ) return false;
        if (index == 0){
            prepend(value);
            return true;
        }
        if (index == length){
            append(value);
            return true;
        }

        Node newNode = new Node(value);
        Node temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        length ++;
        return true;
    }

    public Node remove (int index){
        if (index < 0 || index >= length) return null;
        if (index == 0) return removeFirst();
        if (index == length - 1) return removeLast();


        Node pre = get(index - 1);
        Node temp = pre.next;
        pre.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

    public void reverse (){
        Node temp = head;
        head = tail;
        tail = temp;
        Node after = temp.next;
        Node before = null;
        for (int i = 0; i < length; i++){
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;

        }
    }

    // Find the middle node in a linked-list without using the length attribute.
    public Node findMiddleNode (){
        if (head == null) return null;

        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public boolean hasLoop (){
        if (head == null) return false;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true;
        }

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

    public Node findKthFromEnd(int k){
        if (k <= 0 || k > length ) return null;

        Node slow = head;
        Node fast = head;

        for (int i = 0; i < k; i++) {
            if (fast == null) return null;
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

}

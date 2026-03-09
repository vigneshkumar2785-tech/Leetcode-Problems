package LeetCode.Linkedlist;

class MyLinkedList {
    class Node {
        int val;
        Node next;
        Node prev;
        public Node(int val) {
            this.val = val;
        }
    }

    int size;
    Node head;
    Node tail;

    public MyLinkedList() {
        head = tail = null;
        size = 0;
    }
    
    public int get(int index) {
        if(index < 0 || index >= size) {
            return -1;
        }
        Node temp = head;
        for(int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.val;
    }
    
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        if(head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }
    
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if(tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index < 0 || index > size) {
            return;
        }
        if(index == 0) {
            addAtHead(val);
            return;
        }
        if(index == size) {
            addAtTail(val);
            return;
        }
        Node temp = head;
        for(int i = 0; i < index; i++) {
            temp = temp.next;
        }
        Node newNode = new Node(val);
        newNode.prev = temp.prev;
        newNode.next = temp;
        temp.prev.next = newNode;
        temp.prev = newNode;
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size) {
            return;
        }
        if(index == 0) {
            head = head.next;
            if(head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
        } else if(index == size - 1) {
            tail = tail.prev;
            tail.next = null;
        } else {
            Node temp = head;
            for(int i = 0; i < index; i++) {
                temp = temp.next;
            }
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
        size--;
    }
}

public class DesignLinkedList {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        // Add elements
        list.addAtHead(10);
        list.addAtTail(20);
        list.addAtHead(5);

        // Print values
        System.out.println("Element at index 0: " + list.get(0)); // 5
        System.out.println("Element at index 1: " + list.get(1)); // 10
        System.out.println("Element at index 2: " + list.get(2)); // 20

        // Insert at index
        list.addAtIndex(1, 15);
        System.out.println("Element at index 1 after insertion: " + list.get(1)); 

        // Delete at index
        list.deleteAtIndex(2);
        System.out.println("Element at index 2 after deletion: " + list.get(2)); 

        // Traverse the list
        System.out.print("Final List: ");
        for (int i = 0; i < list.size; i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}


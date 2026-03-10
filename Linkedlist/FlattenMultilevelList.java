class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node(int _val) {
        val = _val;
    }
};

public class FlattenMultilevelList {
    
    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }

        Node cur = head;
        while (cur != null) {
            if (cur.child != null) {
                Node next = cur.next;
                
                cur.next = flatten(cur.child);
                cur.next.prev = cur;
                cur.child = null; 
                
                while (cur.next != null) {
                    cur = cur.next;
                }
                
                if (next != null) {
                    cur.next = next;
                    next.prev = cur;
                }
            }
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        
        n1.next = n2; n2.prev = n1;
        n2.next = n3; n3.prev = n2;
        n3.next = n4; n4.prev = n3;

        Node n7 = new Node(7);
        Node n8 = new Node(8);
        n7.next = n8; n8.prev = n7;

        n3.child = n7;

        FlattenMultilevelList solution = new FlattenMultilevelList();
        Node flattenedHead = solution.flatten(n1);

        System.out.println("Flattened List:");
        printList(flattenedHead);
    }

    // Helper method to print the doubly linked list
    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.val + (curr.next != null ? " <-> " : ""));
            curr = curr.next;
        }
        System.out.println();
    }
}

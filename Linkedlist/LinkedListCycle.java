package LeetCode.Linkedlist;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        ListNode falcone = head;
        ListNode captain = head;

        while (captain.next != null && captain.next.next != null) {
            falcone = falcone.next;
            captain = captain.next.next;

            if (falcone == captain) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        // Create nodes
        ListNode head = new ListNode(3);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(0);
        ListNode fourth = new ListNode(-4);

        // Link nodes
        head.next = second;
        second.next = third;
        third.next = fourth;

        // Create cycle (fourth -> second)
        fourth.next = second;

        LinkedListCycle obj = new LinkedListCycle();

        boolean result = obj.hasCycle(head);

        if (result) {
            System.out.println("Cycle detected in the linked list.");
        } else {
            System.out.println("No cycle in the linked list.");
        }
    }
}
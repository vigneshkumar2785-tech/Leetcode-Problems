package LeetCode.Linkedlist;
import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        // Dummy node to handle removing head
        ListNode dummy = new ListNode(0, head);

        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move fast pointer n steps
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // Move both pointers
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Remove target node
        slow.next = slow.next.next;

        return dummy.next;
    }
}

public class RemoveNthNodeFromEnd {

    public static ListNode createList(int n, Scanner sc) {

        ListNode head = new ListNode(sc.nextInt());
        ListNode temp = head;

        for (int i = 1; i < n; i++) {
            temp.next = new ListNode(sc.nextInt());
            temp = temp.next;
        }

        return head;
    }

    public static void printList(ListNode head) {

        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        System.out.println("Enter node values:");
        ListNode head = createList(n, sc);

        System.out.print("Enter N (node to remove from end): ");
        int remove = sc.nextInt();

        Solution obj = new Solution();

        head = obj.removeNthFromEnd(head, remove);

        System.out.println("Updated Linked List:");
        printList(head);
    }
}
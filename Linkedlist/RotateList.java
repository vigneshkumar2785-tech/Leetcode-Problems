package LeetCode;
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

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Find length and tail
        ListNode tail = head;
        int length = 1;

        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Adjust k
        k = k % length;
        if (k == 0) return head;

        // Make circular
        tail.next = head;

        int stepsToNewTail = length - k;
        ListNode newTail = tail;

        for (int i = 0; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }

        // New head
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}

public class RotateList {

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

        System.out.print("Enter k (number of rotations): ");
        int k = sc.nextInt();

        Solution obj = new Solution();

        ListNode result = obj.rotateRight(head, k);

        System.out.println("Rotated List:");
        printList(result);
    }
}

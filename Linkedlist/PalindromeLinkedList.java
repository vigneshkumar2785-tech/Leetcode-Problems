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

    public static ListNode reverseList(ListNode head) {

        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }

        ListNode falcone = head;
        ListNode captain = head;

        // Find middle of list
        while (captain.next != null && captain.next.next != null) {
            falcone = falcone.next;
            captain = captain.next.next;
        }

        // Split list
        ListNode secondhalf = falcone.next;
        falcone.next = null;

        // Reverse second half
        ListNode p1 = head;
        ListNode p2 = reverseList(secondhalf);

        // Compare both halves
        while (p2 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return true;
    }
}

public class PalindromeLinkedList {

    public static ListNode createList(int n, Scanner sc) {

        ListNode head = new ListNode(sc.nextInt());
        ListNode temp = head;

        for (int i = 1; i < n; i++) {
            temp.next = new ListNode(sc.nextInt());
            temp = temp.next;
        }

        return head;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        System.out.println("Enter node values:");
        ListNode head = createList(n, sc);

        Solution obj = new Solution();

        boolean result = obj.isPalindrome(head);

        if (result) {
            System.out.println("Linked List is Palindrome");
        } else {
            System.out.println("Linked List is NOT Palindrome");
        }
    }
}
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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode();
        ListNode current = dummy;

        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }

            current = current.next;
        }

        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        return dummy.next;
    }
}

public class MergeTwoSortedLists {

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

        System.out.print("Enter number of nodes in list1: ");
        int n1 = sc.nextInt();

        System.out.println("Enter sorted values for list1:");
        ListNode list1 = createList(n1, sc);

        System.out.print("Enter number of nodes in list2: ");
        int n2 = sc.nextInt();

        System.out.println("Enter sorted values for list2:");
        ListNode list2 = createList(n2, sc);

        Solution obj = new Solution();

        ListNode merged = obj.mergeTwoLists(list1, list2);

        System.out.println("Merged Linked List:");
        printList(merged);
    }
}
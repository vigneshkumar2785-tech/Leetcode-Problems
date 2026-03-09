package LeetCode.Linkedlist;
import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class MiddleOfLinkedList {

    public ListNode middleNode(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode falcone = head;
        ListNode captain = head;

        while (captain.next != null && captain.next.next != null) {
            falcone = falcone.next;
            captain = captain.next.next;
        }

        if (captain.next == null) {
            return falcone;
        }

        return falcone.next;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        if (n == 0) {
            System.out.println("List is empty");
            return;
        }

        System.out.print("Enter node values: ");

        ListNode head = new ListNode(sc.nextInt());
        ListNode temp = head;

        for (int i = 1; i < n; i++) {
            temp.next = new ListNode(sc.nextInt());
            temp = temp.next;
        }

        MiddleOfLinkedList obj = new MiddleOfLinkedList();

        ListNode middle = obj.middleNode(head);

        System.out.println("Middle Node Value: " + middle.val);
    }
}
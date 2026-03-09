package LeetCode;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class Solution {

    public void deleteNode(ListNode node) {

        // Copy value of next node
        node.val = node.next.val;

        // Skip the next node
        node.next = node.next.next;
    }
}

public class DeleteNodeInLinkedList {

    public static void printList(ListNode head) {

        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);

        System.out.println("Original List:");
        printList(head);

        // Node to delete (value = 5)
        ListNode nodeToDelete = head.next;

        Solution obj = new Solution();
        obj.deleteNode(nodeToDelete);

        System.out.println("After Deletion:");
        printList(head);
    }
}
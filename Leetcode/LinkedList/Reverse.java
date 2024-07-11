package Leetcode.LinkedList;

public class Reverse {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode tail = new ListNode(6);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = tail;

        System.out.println("Current sorted order:");
        ListNode dummy = head;
        while (dummy != null) {
            System.out.println(dummy.val);
            dummy = dummy.next;
        }

        System.out.println("Reversed sorted order:");
        ListNode ans = reverseList(head);

        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }

    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode (int val) {
            this.val = val;
        }

        ListNode (int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //Runtime O(n)
    //Space O(1) because we're using only pointers
    private static ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        //Each operation inside the while is O(1)
        while (current != null) {
            ListNode nextNode = current.next; // Save next node.
            current.next = previous; // Change pointer to point the previous node.
            previous = current; // Forward previous node one step.
            current = nextNode; // Forward current node one step.
        }
        return previous;
    }
}

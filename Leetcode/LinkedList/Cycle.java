package Leetcode.LinkedList;

import java.util.HashSet;
import java.util.Set;

public class Cycle {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node.next = node2;
        node2.prev = node;
        node2.next = node3;
        node3.prev = node2;
        node3.next = node4;
        node4.prev = node3;
        node4.next = node5;
        node5.prev = node4;
        // node5.next = node; //uncomment to create a cycle.

        System.out.println("Has the Linked List cycle?:");
        boolean ans = hasCycle(node);
        System.out.println(ans);
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode prev;
        ListNode (int val) {
            this.val = val;
        }
    }

    //If it's infinite fast pointer will reach slow pointer at some point.
    //Space complexity O(1).
    //Time complexity O(n).
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        
        return false;
    }

    //Space complexity O(n).
    //Time complexity O(n).
    //This solution is added for the sake of completeness - the first one is better as it uses less space.
    public boolean detectCycle(ListNode head) {
        Set<ListNode> seen = new HashSet<>();
        while (head != null) {
            if (seen.contains(head)) {
                return true;
            }
            seen.add(head);
            head = head.next;
        }
        return false;
    }
}

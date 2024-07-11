package Leetcode.LinkedList;

public class DeleteDuplicatesNode {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);
        node.next = node2;
        node2.prev = node;
        node2.next = node3;
        node3.prev = node2;
        node3.next = node4;
        node4.prev = node3;
        node4.next = node5;
        node5.prev = node4;

        ListNode ans = deleteDuplicates(node);
        System.out.println(ans);
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode prev;
        ListNode (int val) {
            this.val = val;
        }
        ListNode (int val, ListNode next) {
            this.next = next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = head;

        while (dummy != null && dummy.next != null) {
            if (dummy.val == dummy.next.val) {
                dummy.next = dummy.next.next;
            } else {
                dummy = dummy.next;
            }
        }

        return head;
    }
}

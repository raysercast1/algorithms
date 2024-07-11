package Leetcode.LinkedList;

public class Middle {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        node.next = node2;
        node2.prev = node;
        node2.next = node3;
        node3.prev = node2;
        node3.next = node4;
        node4.prev = node3;
        node4.next = node5;
        node5.prev = node4;
        // node5.next = node6;
        // node6.prev = node5;

        ListNode ans = middleNode(node);
        System.out.println("Ans is: ");
        System.out.println(ans);
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode prev;

        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.next = next;
        }
    }


    private static ListNode middleNode(ListNode head) {
        ListNode dummy = head;
        int length = 0;
        while (dummy != null) {
            length++;
            dummy = dummy.next;
        }

        int rightMiddle = length / 2;

        int j = 0;
        while (head != null && head.next != null && j < rightMiddle) {
            head = head.next;
            j++;
        }

        return head;
    }
}

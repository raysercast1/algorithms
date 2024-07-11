package Leetcode.LinkedList;

public class DoubleLinkedList {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node.next = node2;
        node2.prev = node;
        node2.next = node3;
        node3.prev = node2;

        System.out.println("From head to next node value:");
        System.out.println(node.next.val);
        System.out.println("From node 2 to prev node value:");
        System.out.println(node2.prev.val);
        System.out.println("From node 2 to next node value:");
        System.out.println(node2.next.val);
        System.out.println("From node 3 to prev node");
        System.out.println(node3.prev.val);

    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode prev;
        ListNode (int val) {
            this.val = val;
        }
    }
}

package Leetcode.LinkedList;

public class FindNode {
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

        System.out.println("Find node #:");
        int ans = findNode(node, 2);
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

    //Given the head of a linked list and an integer k, return the 𝑘𝑡ℎ node from the end.
    // Space Complexity O(1).
    // Time Complexity O(n).
    public static int findNode(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow.val;
    }

    // Let prevNode be the node at position i - 1
    void addNode(ListNode prevNode, ListNode nodeToAdd) {
        nodeToAdd.next = prevNode.next;
        prevNode.next = nodeToAdd;
    }

    // Let prevNode be the node at position i - 1
     /* prevNode.next is the node being deleted.
     * prevNode.next.next is the node after that which should be kept.
     * We change the next pointer of prevNode to point at that node instead of the one being deleted.
     */
    void deleteNode(ListNode prevNode) {
        prevNode.next = prevNode.next.next;
    }
}

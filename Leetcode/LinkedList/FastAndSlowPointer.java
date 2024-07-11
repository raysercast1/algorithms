package Leetcode.LinkedList;

public class FastAndSlowPointer {
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

        int ans =  getMiddle(node);
        System.out.println("Getting the middle with dummy pointer:");
        System.out.println(ans);

        System.out.println("Getting the middle with Slow and Fast pointer:");
        int slowAndFastP =  getMiddleFastAndSlowPointer(node);
        System.out.println(slowAndFastP);
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode prev;
        ListNode (int val) {
            this.val = val;
        }
    }

    private static int getMiddle(ListNode head) {
        int length = 0;
        ListNode dummy = head;
        while (dummy != null) {
            length++;
            dummy = dummy.next;
        }
        for (int i = 0; i < length / 2; i++) {
            head = head.next;
        }

        return head.val;
    }

    /*
     * Remember that slow and fast are completely independent of each other.
     * In each while loop iteration we move fast forward two steps, so it will take n / 2 iterations
     * for it to reach the end. In each iteration, slow moves forward one step, so after n /2 iterations, 
     * slow will be at the middle, which is exactly what we want. Don't forget that when using
     * fast.next.next, you should also make sure fast.next is not null to avoid any errors.
     */
    private static int getMiddleFastAndSlowPointer(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.val;
    }
}

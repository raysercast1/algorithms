package Leetcode.LinkedList;

public class ReverseBetween {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        // ListNode node3 = new ListNode(3);
        // ListNode node4 = new ListNode(4);
        // ListNode node5 = new ListNode(5);
        // ListNode tail = new ListNode(6);

        head.next = node2;
        // node2.next = node3;
        // node3.next = node4;
        // node4.next = node5;
        // node5.next = tail;

        System.out.println("Reversed order now is:");
        ListNode ans = reverseBetween(head, 1, 2);

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
    }

    /*
     * Given the head of a singly linked list and two integers left and right where left <= right,
     * reverse the nodes of the list from position left to position right, and return the reversed list.
    */
    private static ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;
        ListNode slowP = head;
        ListNode fastP = head;

        for (int i = 1; i < left; i++) {
            slowP = slowP.next;
        }
        for (int j = 1; j < right; j++) {
            fastP = fastP.next;
        }

        ListNode previous = fastP.next;
        int limit;

        if (fastP.next != null) {
            limit = fastP.next.val;
        } else {
            limit = fastP.val + 1;
        }

        //TO DO: fix it 
        while (slowP != null) {
            if (slowP.val == limit) {
                head.next = previous;
                break;
            }
            ListNode nextNode = slowP.next; //1: 2->3 //2: 3->4 //3: 4->5
            slowP.next = previous; //1: 2->null //2: 3->2 //3: 4->3
            previous = slowP; //1: p=2 //2: p=3 //3: p=4
            slowP = nextNode;//1: slowP=3 //2: slowP=4 //3: slowP=5
        }

        
        return head;
    }
}

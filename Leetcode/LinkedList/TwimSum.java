package Leetcode.LinkedList;

public class TwimSum {
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

        System.out.println("The highest sum of twims node is:");
        int ans = pairSum(head);
        System.out.println(ans);
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode (int val) {
            this.val = val;
        }
    }

    /*
     * Maximum Twin Sum of a Linked List asks for the maximum pair sum. 
     * The pairs are the first and last node, second and second last node, third and third last node, etc.
     */
    private static int pairSum(ListNode head) {
        ListNode dummy = head;
        int length = 0;
        int ans = 0;

        while (dummy != null) {
            length++;
            dummy = dummy.next;
        }

        ListNode slowP = head;
        ListNode fastP = head; // n / 2 ahead of his pair twim.
        for (int i = 0; i < length / 2; i++) {
            fastP = fastP.next;
        }

        ListNode current = fastP;
        ListNode previous = null;
        //Reverse 2nd half so that every node is spaced n / 2 apart from its pair node. (fastP pointer)
        while (current != null) {
            ListNode nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }
        
        //Let's sum and after that let's calculate the highest result.
        //previous is now reversed; 6->5->4->null and slowP 1->2->3->4.
        //So it'll be 1+6, 2+5, 3+6.
        while (slowP != null && slowP.next != null) {
            ans = Math.max(ans, slowP.val + previous.val);
            slowP = slowP.next;
            previous = previous.next;
        }
        return ans;
    }
}

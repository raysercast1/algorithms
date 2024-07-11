package Leetcode.LinkedList;

public class SwapPairs {
    public static void main(String[] args) {
        ListNode head = new ListNode('A');
        ListNode node2 = new ListNode('B');
        ListNode node3 = new ListNode('C');
        ListNode node4 = new ListNode('D');
        ListNode node5 = new ListNode('E');
        ListNode tail = new ListNode('F');

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = tail;

        System.out.println("Input: ");
        ListNode dummy = head;
        while (dummy != null) {
            System.out.println(dummy.val);
            dummy = dummy.next;
        }

        System.out.println("Answer is: ");
        ListNode ans = swapPairs(head);
    
        while (ans != null && ans.next != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
    public static class ListNode {
        char val; 
        ListNode next;
        ListNode (char val) {
            this.val = val;
        }
    }

    //Time O(n). Numbers of nodes in the list.
    //Space O(1). We only use pointers.
    private static ListNode swapPairs(ListNode head) {
        // Check edge case: linked list has 0 or 1 nodes, just return
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode current = head;
        ListNode dummy = current.next; // Saving 2nd reference. (N)

        //Time O(n). Each op inside run at O(1).
        while (current != null && current.next != null) {
            if (prev != null) {
                prev.next = current.next; // Point previous node to the last node of the next pair. (X -> N')  <**
            }
            prev = current; //Save current reference. (X)
            ListNode nextNode = current.next.next; //Save the value where node points to. (N')
            current.next.next = current; // Reverse the arrow to points back. (X <- N)
            
            current.next = nextNode; //To avoid when X' -> null. So we set X -> (X' -> N')  <**
            current = nextNode; //Move to next pair. (X' -> N')
        }

        return dummy;
    }
}


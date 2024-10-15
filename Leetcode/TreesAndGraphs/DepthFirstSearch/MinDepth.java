package Leetcode.TreesAndGraphs.DepthFirstSearch;

public class MinDepth {
    public static class Node {
        int val;
        Node left;
        Node right;

        Node() {}

        Node (int val) {
            this.val = val;
        }

        Node (int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
     }

    public static void main(String[] args) {
        Node zero = new Node(0);
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        Node eight = new Node(8);
        Node nine = new Node(9);
        Node ten = new Node(10);
        Node eleven = new Node(11);
        Node twelve = new Node(12);
        Node thirdteen = new Node(13);
        Node fourteen = new Node(14);
        Node fifteen = new Node(15);
        Node sixteen = new Node(16);


        three.left = nine;
        three.right = thirdteen;
        thirdteen.left = ten;
        thirdteen.right = seven;

        int ans = minDepth(three);
        System.out.println("Min Depth is: ");
        System.out.println(ans);


        zero.left = one;
        zero.right = two;
        one.left = four;
        one.right = five;
        five.right = six;
        two.left = eight;

        int ans2 = minDepth(zero);
        System.out.println("Min Depth 2nd try is: ");
        System.out.println(ans2);
        
        eleven.right = twelve;
        twelve.right = fourteen;
        fourteen.right = fifteen;
        fifteen.right = sixteen;

        int ans3 = minDepth(eleven);
        System.out.println("Min Depth 3er try is: ");
        System.out.println(ans3);
       
    }

    private static int minDepth(Node root) {
        if (root == null) {
            return 0;
        }
        
        int left = minDepth(root.left);
        int right = minDepth(root.right);
       
        if (left == 0 && right == 0) {
            return 1;
        }

        if (left == 0 && right != 0) {
            return right + 1; 
        }

        if (right == 0 && left != 0) {
            return left + 1;
        }

        return Math.min(left, right) + 1;
    }
}

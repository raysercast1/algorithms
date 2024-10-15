package Leetcode.TreesAndGraphs.DepthFirstSearch;

public class CountGoodNodes {
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
        Node one = new Node(1);
        Node two = new Node(2);
        Node four = new Node(4);
        Node fourInRight = new Node(4);
        Node five = new Node(5);
        Node seven = new Node(7);
        Node eight = new Node(8);
        Node eleven = new Node(11);
        Node thirdteen = new Node(13);

        five.left = four;
        four.left = eleven;
        eleven.left = seven;
        eleven.right = two;

        five.right = eight;
        eight.left = thirdteen;
        eight.right = fourInRight;
        fourInRight.right = one;

        int ans = goodNodes(five, 0);
        System.out.println("Ans is: ");
        System.out.println(ans);
        
    }
   
    private static int goodNodes(Node node, int maxSoFar) {
        if (node == null) {
            return 0;
        }
        
        System.out.printf("Node #: %d%n", node.val);
        System.out.printf("For the LEFT side the max value seen is: %d %n", Math.max(maxSoFar, node.val));
        int left = goodNodes(node.left, Math.max(maxSoFar, node.val));

        System.out.printf("Node #: %d%n", node.val);
        System.out.printf("For the RIGHT side the max value seen is: %d %n", Math.max(maxSoFar, node.val));
        int right = goodNodes(node.right, Math.max(maxSoFar, node.val));

        int ans = left + right;

        if (node.val >= maxSoFar) {
            ans += 1;
        }
        
        return ans;
    
    }

}

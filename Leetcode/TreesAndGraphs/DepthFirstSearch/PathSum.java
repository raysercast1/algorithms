package Leetcode.TreesAndGraphs.DepthFirstSearch;

public class PathSum {
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

        zero.left = one;
        zero.right = two;
        one.left = three;
        one.right = four;
        four.right = six;
        two.right = five;

        boolean ans = pathSumCheck(zero);
        System.out.println("Ans is: ");
        System.out.println(ans);

    }
    
    static int target;

    private static boolean pathSumCheck(Node root) {
        target = 7;
        return dfs(root, 0); 
    }

    /*
     * Pre order counting current val and when in a leaf check the total sum*/
    private static boolean dfs(Node node, int curr) {
        if (node == null) {
            return false;
        }
        
        if (node.left == null && node.right == null) {
            System.out.printf("In leaf node %s, current sum is: %n", node.val);
            System.out.println(curr);

            return (curr + node.val) == target;
        }

        curr += node.val;
        
        System.out.println("In node : ");
        System.out.println(node.val);
        boolean left = dfs(node.left, curr);
        boolean right = dfs(node.right, curr);
        
        return left || right;
    
    }
}

package Leetcode.TreesAndGraphs.DepthFirstSearch;

public class MaxDiffBtwNodeAndAncestor {
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
        Node three = new Node(3);
        Node four = new Node(4);
        Node six = new Node(6);
        Node seven = new Node(7);
        Node eight = new Node(8);
        Node ten = new Node(10);
        Node thirdteen = new Node(13);
        Node fourteen = new Node(14);

        /*
           8
         /   \
        3     10
       / \      \
      1   6     14
         / \   /
        4   7 13
          */        
        eight.left = three;
        eight.right = ten;
        three.left = one;
        three.right = six;
        ten.right = fourteen;
        six.left = four;
        six.right = seven;
        fourteen.right = thirdteen;

        int ans = maxAncestorDiff(eight);
        System.out.println("Ans: ");
        System.out.println(ans);

    }
    //TODO: Fix this function. It is not giving the correct answer.
    private static int maxAncestorDiff(Node root) {
        if (root == null) return 0;

        System.out.printf("Current Node: #%d%n", root.val);

        int lowest = dfsLowestNode(root.left, root.val);
        System.out.printf("DFS: Lowest in Subtree is: %d%n", lowest);
        System.out.println(); 


        int l = maxAncestorDiff(root.left);
        System.out.printf("Main: LEFT is: %d for node: #%d%n", l, root.val);
        System.out.println(); 

        int r = maxAncestorDiff(root.right);
        System.out.printf("Main: RIGHT is: %d for node: #%d%n", r, root.val);
        

        int ans = Math.max(l, r);

        System.out.println();
        System.out.printf("Node:#%d%n", root.val);

       // return Math.abs(root.val - lowestInSubTree);
       return ans;
    }

    private static int dfsLowestNode(Node n, int prevN) {
        if (n == null) return 0;
        
        //System.out.println(String.format("When current is: %d and prevN is:%d", n.val, prevN));
        if (n.left == null && n.right == null) {
            return Math.min(n.val, prevN);
        }
        
        int l = dfsLowestNode(n.left, n.val);
        //System.out.println(String.format("Left in DFS is: %d", l));

        int r = dfsLowestNode(n.right, n.val);
        //System.out.println(String.format("Right in DFS is: %d", r));

        return Math.min(l,r);
    }
}

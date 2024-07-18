public class LowestCommonAncestor {
    public static class Node {
        int val;
        Node left;
        Node right;

        Node() {};

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
        Node fourInRight = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        Node eight = new Node(8);
        Node nine = new Node(9);
        Node ten = new Node(10);
        Node eleven = new Node(11);
        Node twelve = new Node(12);
        Node thirdteen = new Node(13);

        five.left = four;
        four.left = eleven;
        eleven.left = seven;
        eleven.right = two;

        five.right = eight;
        eight.left = thirdteen;
        eight.right = fourInRight;
        fourInRight.right = one;
        
        /*
         * TreeNode:
            5
           / \
          4   8  
         /   / \
        11  13  4
       /  \      \
      7    2      1
                     */
        
       
        Node firstCaseAns = lowestCommonAncestor(five, seven, two);
        System.out.println(String.format("ANSWER: case one, LCA is: %d", firstCaseAns.val));

        Node secondCaseAns = lowestCommonAncestor(five, eleven, one);
        System.out.println(String.format("ANSWER: case two, LCA is: %d", secondCaseAns.val));

        Node thirdCaseAns = lowestCommonAncestor(five, eight, five);
        System.out.println(String.format("ANSWER: case third, LCA is: %d", thirdCaseAns.val));
 
        
    }   

    /*How can we tell if a node is the LCA?. Let's say that we're at the root, then there are 3 possibilities.
     * 1. The root node is targetNode1 (t1) or targetNode2 (t2). The answer cannot be below the root node (t1 or t2),
     *  because then it would be missing the root (which is either t1 or t2) as a descendant.
     *
     * 2. One of t1 or t2 is in the left subtree, and the other one is in the right subtree. 
     *  The root must be the answer because it is the connection point between the two subtrees,
     *  and thus the lowest node to have both t1 and t2 as descendants.
     *
     * 3. Both t1 and t2 are in one of the subtrees. In that case, the root is not the answer 
     *  because we could look inside the subtree and find a "lower" node.
     *
     * In the first case, if we see that the current node is either t1 or t2, we don't need to worry about the subtrees at all,
     * because we know the answer cannot be in them. Therefore, we can return something (non-null) right away. 
     * In the base case, we return null. Therefore, a call to a subtree returns a non-null value only if one of t1 or t2
     * is in that subtree. We should return null for a subtree that contains neither t1 nor t2.
     * Then, the second case is implied if both calls to the left and right subtrees return something non-null,
     * and the third case is implied if only one of the calls returns something.*/
    private static Node lowestCommonAncestor(Node root, Node t1, Node t2) {
        if (root == null) {
            return null;
        }
        
        System.out.println(String.format("LEFT: Root #: %d", root.val));
        System.out.println(String.format("Pre-order, t1 is: %d and t2 is: %d", t1.val, t2.val));
        //first case
        if (root == t1 || root == t2) {
            return root;
        }
        
        Node left = lowestCommonAncestor(root.left, t1, t2);

        System.out.println(String.format("RIGHT: Root #: %d", root.val));
        Node right  = lowestCommonAncestor(root.right, t1, t2);
        
        System.out.println(String.format("Pos-order, left is: %d and right is: %d", (left != null) ? left.val : 000, (right != null) ? right.val : 000));
        //second case
        if (left != null && right != null) {
            return root;
        } 
        

        //third case
        if (left != null) {
            return left;
        }


        return right;

    }
}

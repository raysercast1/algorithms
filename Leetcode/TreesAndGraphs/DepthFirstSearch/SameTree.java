public class SameTree {
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
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);

        Node zeroC = new Node(0);
        Node oneC = new Node(1);
        Node twoC = new Node(2);
        Node threeC = new Node(3);
        Node fourC = new Node(4);
        Node fiveC = new Node(5);
        Node sixC = new Node(6);
        Node sevenC = new Node(7);
       
        zero.left = one;
        one.left = two;
        two.left = three;
        one.right = four;
        four.right = five;
        five.left = six;
        five.right = seven; 

        zeroC.left = oneC;
        oneC.left = twoC;
        twoC.left = threeC;
        oneC.right = fourC;
        fourC.right = fiveC;
        fiveC.left = sixC;
        fiveC.right = sevenC; 
        


        boolean  ans = isSameTree(zero, zeroC);
        System.out.println("Ans is: ");
        System.out.println(ans);
    }

    private static boolean isSameTree(Node root1, Node root2) {
        if (root1 == null && root2 == null) return true;

        if (root1 == null || root2 == null) return false;

        if (root1.val != root2.val) return false;

        System.out.println(String.format("Current values in LEFT of root1 is: %d and root2 is: %d", root1.val, root2.val));
        boolean left = isSameTree(root1.left, root2.left);

        System.out.println(String.format("Current values in RIGHT of root1 is: %d and root2 is: %d", root1.val, root2.val));
        boolean right = isSameTree(root1.right, root2.right);

        return left && right;
    }
}

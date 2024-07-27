public class CountGoodNodes {
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

        int ans = goodNodes(five, 0);
        System.out.println("Ans is: ");
        System.out.println(ans);
        
    }
   
    private static int goodNodes(Node node, int maxSoFar) {
        if (node == null) {
            return 0;
        }
        
        System.out.println(String.format("Node #: %d", node.val));
        System.out.println(String.format("For the LEFT side the max value seen is: %d ", Math.max(maxSoFar, node.val))); 
        int left = goodNodes(node.left, Math.max(maxSoFar, node.val));

        System.out.println(String.format("Node #: %d", node.val));
        System.out.println(String.format("For the RIGHT side the max value seen is: %d ", Math.max(maxSoFar, node.val))); 
        int right = goodNodes(node.right, Math.max(maxSoFar, node.val));

        int ans = left + right;

        if (node.val >= maxSoFar) {
            ans += 1;
        }
        
        return ans;
    
    }

}

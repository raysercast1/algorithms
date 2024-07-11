package Leetcode.Stack;
import java.util.Stack;

public class StackSample {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        
        System.out.println("Push on stack");
        stack.push(1);
        System.out.println(stack.peek());
        System.out.println("Push on stack");
        stack.push(2);
        System.out.println(stack.peek());
        System.out.println("Push on stack");
        stack.push(3);
        System.out.println(stack.peek());

        System.out.println("Pop:");
        System.out.println(stack.pop());

        System.out.println("Pop:");
        System.out.println(stack.pop());

        System.out.println("Check if empty:");
        System.out.println(stack.empty());

        System.out.println("Size is:");
        System.out.println(stack.size());

        System.out.println("Value is:");
        System.out.println(stack.peek());
    }
}

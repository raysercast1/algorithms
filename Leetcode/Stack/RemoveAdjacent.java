package Leetcode.Stack;

import java.util.Stack;

public class RemoveAdjacent {
    public static void main(String[] args) {
        System.out.println("Input: abbaca");
        String ans = removeDuplicateAdjacent("abbaca");
        String ansOne = removeDuplicateAdjacentChars("abbaca");
        System.out.println("Stack Implementation:");
        System.out.println(ans);
        System.out.println("Stack interface with StringBuilder impl:");
        System.out.println(ansOne);

        System.out.println("Input: abccba");
        String ans2 = removeDuplicateAdjacent("abccba");
        String ansTwo = removeDuplicateAdjacentChars("abccba");
        System.out.println("Stack Implementation:");
        System.out.println(ans2);
        System.out.println("Stack interface with StringBuilder impl:");
        System.out.println(ansTwo);
    }
    private static String removeDuplicateAdjacent(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (stack.empty()) {
                stack.push(c);
            } else if (stack.peek() != c) {
                stack.push(c);
            } else {
                stack.pop();
            }
        }

        return stack.toString();
    }

    //Stacks are defined by their interface - we just need to add and remove from the same end.
    private static String removeDuplicateAdjacentChars(String s) {
        StringBuilder stack = new StringBuilder();
        for (char c: s.toCharArray()) {
            if (stack.length() > 0 && stack.charAt(stack.length() - 1) == c) {
                stack.deleteCharAt(stack.length() - 1);
            } else {
                stack.append(c);
            }
        }
        
        return stack.toString();
    }
}

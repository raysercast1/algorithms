package Leetcode.Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println("Let's match ((([[{ vs }]]))) and expect true");
        boolean ans = isValidMatch("((([[{}]])))");
        System.out.println(ans);

        System.out.println("Now let's match (([ vs }] and expect false:");
        boolean ans2 = isValidMatch("(([}]");
        System.out.println(ans2);

    }

    //Time O(n)
    //Space O(n) because stack size can grow linearly with the input size.
    private static boolean isValidMatch(String s) {
        Map<Character, Character> matching = new HashMap<>();
        matching.put('(', ')');
        matching.put('{', '}');
        matching.put('[', ']');

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (matching.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.empty()) return false;
                char lastInChar = stack.pop();
                if (matching.get(lastInChar) != c) {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
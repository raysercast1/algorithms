package Leetcode;
/**
 * This is a TWO POINTERS example.
 * Start the pointers at the edges of the input. Move them towards each other until they meet.
 * Or move one of them to accomplish the goal.
 */
public class Palindrome {
    public static void main(String[] args) {
        checkPalindrome("abcdcba");
        checkPalindrome("racecar");
        checkPalindrome("rayser");
    }

    private static boolean checkPalindrome(String str) {
        int leftIdx = 0;
        int rightIdx = str.length() - 1;

        while (leftIdx < rightIdx) {
            if (str.charAt(leftIdx) != str.charAt(rightIdx)) {
                System.out.println("FALSE");
                return false;
            }
            leftIdx++;
            rightIdx--;
        }
        System.out.println("TRUE");
        return true;
    }
}

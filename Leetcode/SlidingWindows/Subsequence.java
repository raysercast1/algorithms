package Leetcode.SlidingWindows;

/**
 * O(n) Time Complexity.
 * O(1) Space Complexity.
 */
public class Subsequence {
    public static void main(String[] args) {
        String originalString = "abcde";
        String subSequence = "aec";
        boolean isSubSequence = findSubSequence(originalString, subSequence);
        if (isSubSequence) {
            System.out.println("input string is subsequence!");
        } else {
            System.out.println("input string is NOT subsequence");
        }
    }

    private static boolean findSubSequence(String originalString, String subSequence) {
        int firstPointer = 0;
        for (int j = 0; j < originalString.length(); j++) {
            if (subSequence.charAt(firstPointer) == originalString.charAt(j)) {
                firstPointer++;
            }
        }
        return firstPointer == subSequence.length();
    }
}

package Leetcode.Hashing;

import java.util.HashSet;
import java.util.Set;

public class RepeatedCharacter {
    public static void main(String[] args) {
        char ans = repeatedCharacter("This is a character string");
        System.out.println(ans);
    }

    //O(n^2) Time Complexity
    private static char repeatedCharacter(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            System.out.println("When i is: ");
            System.out.println(i);
            for (int j = 0; j < i; j++) {
                System.out.println("Then j is: ");
                System.out.println(j);
                if (s.charAt(j) == c) {
                    return c;
                }
            }
        }
        
        return ' ';
    }

    // O(n) Time Complexity
    /**O(1) Because the input can only have characters from english alphabet, which is bounded by a constant of 26 chars.
     * This is very common with string problems and technically correct.
     * In an interview setting, this is probably a safe answer, but you should also note that the space complexity could be O(m),
     * where m is the number of allowable characters in the input. This is a more general answer and also technically correct.
     * @param s
     * @return
     */
    private static char repeatedCharacterSet(String s) {
        Set<Character> seen = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (seen.contains(c)) {
                return c;
            }
            seen.add(c);
        }
        return ' ';
    }
}
package Leetcode.Hashing.MoreHashingExamples;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public static void main(String[] args) {
        boolean ans = canConstruct("aa", "ab");
        System.out.println(ans);
    }

    //O(n) runtime complexity
    //O(n) space complexity
    private static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> countingWords = new HashMap<>();
        int occurrences = 0;
        for (int i = 0; i < magazine.length(); i++) {
            countingWords.put(
                magazine.charAt(i), countingWords.getOrDefault(magazine.charAt(i), 0) + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            if (countingWords.get(ransomNote.charAt(i)) != null) {
                occurrences += 1;
                countingWords.put(ransomNote.charAt(i), countingWords.get(ransomNote.charAt(i)) - 1);
                if (countingWords.get(ransomNote.charAt(i)) == 0) countingWords.remove(ransomNote.charAt(i));
            }
        }
        if (occurrences == ransomNote.length()) return true;
        return false;
    }
}

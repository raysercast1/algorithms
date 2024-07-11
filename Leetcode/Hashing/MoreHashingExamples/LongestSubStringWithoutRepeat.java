package Leetcode.Hashing.MoreHashingExamples;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutRepeat {
    public static void main(String[] args) {
        int ans = longestSubString("pwwkew");
        System.out.println(ans);
    }
    private static int longestSubString(String str) {
        Map<Character, Integer> subStringsMap = new HashMap<>();
        int leftP = 0;
        int ans = 0;

        for (int rightP = 0; rightP < str.length(); rightP++) {
            if (subStringsMap.getOrDefault(str.charAt(rightP), 0) > 0) {
                ans = Math.max(ans, rightP - leftP);
                leftP++;
            }

            subStringsMap.put(str.charAt(rightP), subStringsMap.getOrDefault(str.charAt(rightP), 0) + 1);
        }
        return ans;
    }
}

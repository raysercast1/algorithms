package Leetcode.Hashing;

import java.util.HashMap;
import java.util.Map;

public class CountingMultipleElements {
    public static void main(String[] args) {
        int ans = countingMultipleElements("eceba", 2);
        System.out.println(ans);
    }

    private static int countingMultipleElements(String s, int k) {
        Map<Character, Integer> m = new HashMap<>();
        int left = 0;
        int ans = 0;

        for (int right = 0; right < s.length() -1; right++) {
            char c = s.charAt(right);
            if (m.containsKey(c)) {
                m.put(c, m.get(c) + 1);
            } else {
                m.put(c,0);
            }

            while (m.size() > k) {
                char e = s.charAt(left);
                if (m.containsKey(e) && m.get(e) > 0) {
                    m.put(e, m.get(e) - 1);
                } else if (m.containsKey(e)) {
                    m.remove(e);
                }
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}

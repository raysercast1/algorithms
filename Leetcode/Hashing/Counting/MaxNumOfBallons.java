package Leetcode.Hashing.Counting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxNumOfBallons {
    public static void main(String[] args) {
        int ans = numOfBallonStringBuilder("loonbalxballpoon");
        System.out.println(ans);
    }

    private static int numOfBallonStringBuilder(String str) {
        Map<Character, Integer> stringCounts = new HashMap<>();
        StringBuilder balloonBuilder = new StringBuilder();
        List<String> numberOfText = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            stringCounts.put(str.charAt(i), stringCounts.getOrDefault(str.charAt(i), 0) + 1);
        }

        String t = "balloon";
        int p = 0;   
        for (int j = 0; j < str.length(); j++) {
            if (p < t.length() && stringCounts.get(t.charAt(p)) != null) {
                balloonBuilder.append(t.charAt(p));
                stringCounts.put(t.charAt(p), stringCounts.getOrDefault(t.charAt(p), 0) - 1);
            } else if (p == t.length() && balloonBuilder.length() == t.length()) {
                p = 0;
                numberOfText.add(balloonBuilder.toString());
                balloonBuilder.delete(0, t.length() - 1);
            } else {
                return 0;
            }
            p++;
        }

        return numberOfText.size();
    }
}

package Leetcode.Hashing.Counting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZeroOrOneLosses {
    public static void main(String[] args) {
        int[][] matches = {{1,3}, {2,3}, {3,6}, {5,6}, {5,7}, {4,5}, {4,8}, {4,9}, {10,4}, {10,9}};
        List<List<Integer>> ans = findZeroOrOneLosses(matches);
        System.out.println("Flawless victories:");
        System.out.println(Arrays.toString(ans.get(0).toArray()));
        System.out.println("Loosers:");
        System.out.println(Arrays.toString(ans.get(1).toArray()));


    }

    private static List<List<Integer>> findZeroOrOneLosses(int[][] matches) {
        Map<Integer,Integer> lossCounter = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> invictus = new ArrayList<>();
        List<Integer> oneTimeLoss = new ArrayList<>();

        for (int[] match : matches) {
            lossCounter.put(match[1], lossCounter.getOrDefault(match[1], 0) + 1);
        }

        for (Map.Entry<Integer,Integer> entry: lossCounter.entrySet()) {
            int k = entry.getKey();
            int v = entry.getValue();
            if (v == 1) oneTimeLoss.add(k);
        }

        for (int[] match : matches) {
            if (lossCounter.get(match[0]) == null) {
                invictus.add(match[0]);
            }
        }
        
        ans.add(invictus);
        ans.add(oneTimeLoss);

        return ans;
    }
}

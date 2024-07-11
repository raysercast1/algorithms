package Leetcode.Hashing.MoreHashingExamples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimunCardPickup {
    public static void main(String[] args) {
        int[] input = {1, 2, 6, 2, 1};
        System.out.println("For regular function ans is:");
        int ans = minimunCardPickUp(input);
        System.out.println(ans);
        System.out.println("For optimized function ans is:");
        int ans1 = minimunCardPickUpOptimized(input);
        System.out.println(ans1);
    }

    //O(n) runtime complexity
    //O(n) space complexity
    private static int minimunCardPickUp(int[] cards) {
        Map<Integer, List<Integer>> dic = new HashMap<>();
        for (int i = 0; i < cards.length; i++) {
            int num = cards[i];
            if (!dic.containsKey(num)) {
                dic.put(num, new ArrayList<>());
            }
            
            dic.get(num).add(i);
        }
        
        int ans = Integer.MAX_VALUE;
        for (int key: dic.keySet()) {
            List<Integer> arr = dic.get(key);
            for (int i = 0; i < arr.size() - 1; i++) {
                ans = Math.min(ans, arr.get(i + 1) - arr.get(i) + 1); //Comparing adjacent elements + 1 to find the minimun distance in the sorted values.
            }
        }
        
        if (ans == Integer.MAX_VALUE) {
            return -1;
        }
        
        return ans;
    }

    private static int minimunCardPickUpOptimized(int[] cards) {
        Map<Integer, Integer> dic = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        
        for (int i = 0; i < cards.length; i++) {
            int num = cards[i];
            if (dic.containsKey(num)) { //If exists is because it's duplicated
                ans = Math.min(ans, i - dic.get(num) + 1);
            }
            
            dic.put(num, i);
        }
        
        if (ans == Integer.MAX_VALUE) {
            return -1;
        }
        
        return ans;
    }
}

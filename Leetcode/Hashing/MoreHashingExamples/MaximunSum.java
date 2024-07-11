package Leetcode.Hashing.MoreHashingExamples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MaximunSum {
    public static void main(String[] args) {
        int[] a = {18,43,36,13,7};
        int ans = findMaxSumDigits(a);
    }
    
    public static int findMaxSumDigits(int[] nums) {
        Map<Integer, List<Integer>> dic = new HashMap<>();
        for (int n: nums) {
            int digitSum = getDigitSum(n);
            if (!dic.containsKey(digitSum)) {
                dic.put(digitSum, new ArrayList<>());
            }
            dic.get(digitSum).add(n);
        }

        System.out.println("HashMap is: ");
        System.out.println(dic);
        
        System.out.println("dic.get(keySet) is:");
        int ans = -1;
        for (int key: dic.keySet()) {
            System.out.println("KeySet is:");
            System.out.println(key);
            List<Integer> curr = dic.get(key);
            System.out.println(curr);
            if (curr.size() > 1) {
                Collections.sort(curr, Collections.reverseOrder());
                ans = Math.max(ans, curr.get(0) + curr.get(1));
            }
        }
        
        return ans;

    }

    public static int getDigitSum(int num) {
        int digitSum = 0;
        while (num > 0) {
            digitSum += num % 10;
            num /= 10;
        }
        
        return digitSum;
    }

    private static int findMaxSumDigitsOptimized(int[] nums) {
        Map<Integer, Integer> dic = new HashMap<>();
        int ans = -1;
        for (int num: nums) {
            int digitSum = getDigitSum(num);
            if (dic.containsKey(digitSum)) {
                ans = Math.max(ans, num + dic.get(digitSum));
            }
            
            dic.put(digitSum, Math.max(dic.getOrDefault(digitSum, 0), num));
        }
        
        return ans;
    }
}

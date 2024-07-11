package Leetcode.Hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {5,2,7,10,3,9};
        int target = 8;
        int[] ans = twoSum(nums, target);
        System.out.println("Answer is: ");
        System.out.println(Arrays.toString(ans));
    }

    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int complement = target - num;
            if (hashMap.containsKey(complement)) { // This operation is O(1)!
                return new int[] {i, hashMap.get(complement)};
            }
            hashMap.put(num, i);
        }

        return new int[] {-1, -1};
    }
}
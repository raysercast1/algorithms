package Leetcode.Hashing;

import java.util.HashSet;
import java.util.Set;

public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = {9,6,4,2,3,5,7,0,1};
        int ans = missingNumber(nums);
        System.out.println(ans);
    }

    private static int missingNumber(int[] nums) {
        Set<Integer> nSet = new HashSet<>();
        int n = nums.length;
        for (int num: nums) {
            nSet.add(num);
        }
        for (int j = 0; j < n; j++) {
            if (!nSet.contains(n - j)) {
                return n - j;
            }
        }
        return 0;
    }
}

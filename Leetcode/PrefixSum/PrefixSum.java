package Leetcode.PrefixSum;

import java.util.Arrays;

public class PrefixSum {
    public static void main(String[] args) {
        int[] nums = {1, 6, 3, 2, 7, 2};
        int[][] queries = {{0,3}, {2,5}, {2,4}};
        int constraint = 13;
        System.out.println("Boolean array for the answer");
        boolean[] ans = answerQueries(nums, queries, constraint);
        System.out.println(Arrays.toString(ans));

        System.out.println("Split array in N numbers of way");
        int[] splitArrInput = {10,4,-8,7};
        int splitArrAnswer = splitArrayAndSum(splitArrInput);
        System.out.println(splitArrAnswer);

        System.out.println("Split array in N numbers of way using Integer as prefix instead of array");
        int splitArrAnswerWithIntegerAsPrefix = waysToSplitArray(splitArrInput);
        System.out.println(splitArrAnswerWithIntegerAsPrefix);

        System.out.println("PREFIX INTEGER");
        int[] prefixInt = {-3,2,-3,4,2};
        int anss = prefixInteger(prefixInt);
        System.out.println(anss);
    }

    private static int[] prefixSum(int[] arr) {
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = arr[i] + prefix[i - 1];
        }
        return prefix;
    }

    private static boolean[] answerQueries(int[] nums, int[][] queries, int limit) {
        int[] prefix = prefixSum(nums);
        boolean[] ans = new boolean[queries.length];
        for (int i = 0; i < ans.length; i++) {
            int x = queries[i][0];
            int y = queries[i][1];
            int curr = prefix[y] - prefix[x] + nums[x];
            ans[i] = curr < limit;
        }
        return ans;
    } 

    private static int splitArrayAndSum(int[] nums) {
        int n = nums.length;
        long[] prefix = new long[n];
        prefix[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = nums[i] + prefix[i - 1];
        }

        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            long leftSection = prefix[i];
            long rightSection = prefix[n - 1] - prefix[i];
            if (leftSection >= rightSection) {
                ans++;
            }
        }
        return ans;
    }

    private static int waysToSplitArray(int[] nums) {
        int ans = 0;
        long leftSection = 0;
        long total = 0;
        
        for (int num: nums) {
            total += num;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            leftSection += nums[i];
            long rightSection = total - leftSection;
            if (leftSection >= rightSection) {
                ans++;
            }
        }
        
        return ans;
    }

    private static int prefixInteger(int[] nums) {
        int total = 0;
        int startValue = 3;
        total = startValue;
        
        for (int num : nums) {
            total += num;
        }
        return total;
    }

    public int[] getAverages(int[] nums, int k) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        int[] avg = new int[nums.length];
        
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = nums[i] + prefix[i - 1];
        }
        
        for (int j = 0; j < nums.length; j++) {
            if (j >= k && (nums.length - j) > k) {
                avg[j] = prefix[j] / (j + 1);
            } else {
                avg[j] = - 1;
            }
        }
        return avg;
    }
}

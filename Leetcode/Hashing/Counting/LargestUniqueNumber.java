package Leetcode.Hashing.Counting;

import java.util.HashMap;
import java.util.Map;

public class LargestUniqueNumber {
    public static void main(String[] args) {
        int[] a = {5,7,3,9,4,9,8,3,1};
        int ans = largestUniqueNumber(a);
        System.out.println("Largest number in array is: ");
        System.out.println(ans);
    }

    private static int largestUniqueNumber(int[] arr) {
        Map<Integer,Integer> collector = new HashMap<>();
        int len = arr.length;
        for (int j = 1; j < len; j++) {
            int c = arr[j];
            int p = j - 1;
            while (p >= 0 && c < arr[p]) { 
                arr[p + 1] = arr[p];
                p = p - 1;
            }
            arr[p + 1] = c;
        }
    
        for (int i = 0; i < len; i++) {
            collector.put(arr[i], collector.getOrDefault(arr[i], 0) + 1);
        }

        for (int idx = len - 1; idx >= 0; idx--) {
            if (collector.get(arr[idx]) == 1) return arr[idx];
        }

        return -1;
    }
}

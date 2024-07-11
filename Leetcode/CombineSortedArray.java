package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombineSortedArray {
    public static void main(String[] args) {
       Integer[] firstHalf = {1,4,7,20};
       Integer[] secondHalf = {3,5,6};
       List<Integer> answer = combineSortedArrays(firstHalf, secondHalf);
       System.out.println("Sorted array:");
       System.out.println(Arrays.toString(answer.toArray()));
    }

    //O(n) Time Complexity because only received sortedArray and O(1) Space Complexity.
    private static List<Integer> combineSortedArrays(Integer[] firstHalf, Integer[] secondHalf) {
        int leftIdx = 0;
        int rightIdx = 0;
        List<Integer> ans = new ArrayList<>();

        while (leftIdx < firstHalf.length && rightIdx < secondHalf.length) {
            if (firstHalf[leftIdx] < secondHalf[rightIdx]) {
                ans.add(firstHalf[leftIdx]);
                leftIdx++;
            } else {
                ans.add(secondHalf[rightIdx]);
                rightIdx++;
            }
        }

        while (leftIdx < firstHalf.length) {
            ans.add(firstHalf[leftIdx]);
            leftIdx++;
        }
        while (rightIdx < secondHalf.length) {
            ans.add(secondHalf[rightIdx]);
            rightIdx++;
        }
        return ans;
    }
}

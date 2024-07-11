package Leetcode.Hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindUniqueNumbers {
    public static void main(String[] args) {

    }

    //O(n) Time Complexity because each for loop iteration runs in constant time.
    //O(n) Space Complexity because set occupy n size.
    private static List<Integer> findNumbers(int[] n) {
        List<Integer> ans = new ArrayList<>();
        Set<Integer> nSet = new HashSet<>();
        
        for (int num: n) {
            nSet.add(num); //O(1)
        }

        for (int num: nSet) {
            if (!nSet.contains(num + 1) && !nSet.contains(num - 1)) {// O(1) each.
                ans.add(num); //O(1)
            }
        }

        return ans;
    }
}

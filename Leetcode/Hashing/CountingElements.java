package Leetcode.Hashing;

import java.util.HashSet;
import java.util.Set;

public class CountingElements {
    public static void main(String[] args) {
        int[] a = {1,1,3,3,5,5,7,7};
        int ans = countingElements(a);
        System.out.println(ans);
    };

    private static int countingElements(int[] a) {
        Set<Integer> nSet = new HashSet<>();
        int c = 0;
        for (int n: a) {
            nSet.add(n);
        }
        for (int j = 0; j < a.length; j++) {
            if (nSet.contains(a[j] + 1)) {
                c++;
            }
        }
        return c;
    }
}

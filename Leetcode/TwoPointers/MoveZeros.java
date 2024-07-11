package Leetcode.TwoPointers;

import java.util.Arrays;

public class MoveZeros {
    public static void main(String[] args) {
        System.out.println("Array input:");
        int[] input = {0,1,0,3,12};
        System.out.println(Arrays.toString(input));
        moveZeros(input);
    }

    private static void moveZeros(int[] n) {
        int sp = 0;
        while (sp < n.length - 1) {
            int k = n[sp];
            if (k == 0) {
                int p = n.length - 1;
                int t = n[p];
                while ((p - sp) > 0) {
                    int j = n[p - 1];
                    n[p - 1] = t;
                    t = j;
                    p--;
                }
                n[n.length - 1] = k;
            }
            sp++;
        }
        System.out.println("Mutated in-place array");
        System.out.println(Arrays.toString(n));
    }
}

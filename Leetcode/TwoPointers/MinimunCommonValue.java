package Leetcode.TwoPointers;

public class MinimunCommonValue {
    public static void main(String[] args) {
        int[] A = {0,4,5,6,8,10,11};
        int[] N = {1,2,3,4,6,15};
        System.out.println("The minimun common number is: ");
        int ans = minimunCommonValue(A, N);
        System.out.println(ans);

    }

    private static int minimunCommonValue(int[] A, int[] N) {
        int ans = 0;
        int sp = 0;
        int p = 0;
        int largestArray = A.length < N.length ? N.length : A.length;

        for (int i = 0; i < largestArray; i++) {
            int k = A[sp];
            int z = N[p];
            if (k == z) {
                ans = z;
                return z;
            }
            if (k < z) {
                sp++;
            } else {
                p++;
            }
        }
        ans = -1;
        return ans;
    }
}


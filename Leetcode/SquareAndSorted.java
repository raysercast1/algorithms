package Leetcode;

import java.util.Arrays;

public class SquareAndSorted {
    public static void main(String[] args) {
        Integer[] array = {-4,-1,0,3,10};
        System.out.println("Original array: ");
        System.out.println(Arrays.toString(array));
        Integer[] ans = sortArray(array);
        System.out.println("Squared and sorted array: ");
        System.out.println(Arrays.toString(ans));
    }

    private static Integer square(Integer number) {
        return number * number;
    }

    //Not working properly if the first elemnent is the smallest
    private static Integer[] sortArray(Integer[] arr) {
        int sp = 1;
        while (sp < arr.length) {
            Integer k = square(arr[sp]);
            int p = sp - 1;
            while (p >= 0 && arr[p] > k) {
                arr[p + 1] = arr[p];
                p--;
            }
            arr[p + 1] = k;
            sp++;
        }
        return arr;
    }
}

package Leetcode.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RevertArray {
    public static void main(String[] args) {
        char[] charArr = {'h', 'e', 'l', 'l', 'o'};
        String[] strArr = {"r", "a", "y", "s", "e"};
        List<String> ans = reversedString(strArr);
        System.out.println("Original Array String:");
        System.out.println(Arrays.toString(strArr));
        System.out.println("Reversed Array String:");
        System.out.println(Arrays.toString(ans.toArray()));

        reverseChar(charArr);
        String reversedString = reverseString( "Let's take LeetCode contest");
        System.out.println(reversedString);
    }

    private static List<String> reversedString(String[] strArr) {
        List<String> newArr = new ArrayList<>();
        for (int sp = strArr.length -1; sp >= 0; sp--) {
            newArr.add(strArr[sp]);
        }
        return newArr;
    }

    private static void reverseChar(char[] s) {
        String str = new String(s);
        char[] newArr = new char[s.length];
        int p = 0;
        for (int sp = str.length() - 1; sp >= 0; sp--) {
            newArr[p] = str.charAt(sp);
            p++;
        }
        System.out.println(Arrays.toString(newArr));
    }

    /*
     * Input example: "Let's take LeetCode contest"
     * Output example: "s'teL ekat edoCteeL tsetnoc"
     */
    private static String reverseString(String s) {
        StringBuilder subStringBuilder = new StringBuilder();
        StringBuilder sBuilderReverted = new StringBuilder();
        for (int sp = 0; sp < s.length(); sp++) {
            subStringBuilder.append(s.charAt(sp));
            if (s.charAt(sp) == ' ') {
                for (int i = subStringBuilder.length() - 1; i >= 0; i--) {
                    sBuilderReverted.append(subStringBuilder.charAt(i));
                    subStringBuilder.deleteCharAt(i);
                }
            }
        }

        if (subStringBuilder.length() > 0) {
            int j = subStringBuilder.length() - 1;
            sBuilderReverted.append(' ');
            while (j >= 0) {
                sBuilderReverted.append(subStringBuilder.charAt(j));
                j--;
            }
        }
        return sBuilderReverted.toString().trim();
    }
}

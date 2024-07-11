package Leetcode.TwoPointers;

public class ReverseOnlyLetters {
    public static void main(String[] args) {
        String ans = reverseOnlyLetters("Test1ng-Leet=code-Q!");
        System.out.println(ans);
    }

    private static String reverseOnlyLetters(String n) {
        StringBuilder ts = new StringBuilder();
        StringBuilder rs = new StringBuilder();
        int i = 0;

        while (i < n.length()) {
            if (!Character.isLetter(n.charAt(i))) {
                int j = ts.length() - 1;
                while (j >= 0) {
                    rs.append(ts.charAt(j));
                    ts.deleteCharAt(j);
                    j--;
                }
                rs.append(n.charAt(i));
                i++;
            }
            ts.append(n.charAt(i));
            i++;
        }

        return rs.toString().trim();
    }
}

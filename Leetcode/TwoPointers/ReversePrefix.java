package Leetcode.TwoPointers;

public class ReversePrefix {
    static public void main(String[] args) {
        System.out.println("Reversing string:");
        String word = "abcd";
        char target = 'z';
        System.out.println(word);
        System.out.println("Target:");
        System.out.println(target);
        String ans = reversePrefixStr(word, target);
        System.out.println("Result:");
        System.out.println(ans);
    }

    static private String reversePrefixStr(String w, char c) {
        int sp = 0;
        int p = 0;

        while (sp < w.length() - 1) {
            if (w.charAt(sp) != c) {
                p++;
                sp++;
            } else {
                break;
            }
        }
        if (sp == w.length() - 1) {
            System.out.println("Target character not found");
            return w;
        }

        StringBuilder finalString = new StringBuilder();
        while (p >= 0) {
            finalString.append(w.charAt(p));
            p--;
        }

        sp++;
        while (sp < w.length()) {
            finalString.append(w.charAt(sp));
            sp++;
        }

        return finalString.toString();
    }
}

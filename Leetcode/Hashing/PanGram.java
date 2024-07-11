package Leetcode.Hashing;

import java.util.HashSet;
import java.util.Set;

public class PanGram {
    public static void main(String[] args) {
        boolean ans = panGram("thequickbrownfoxjumpsoverthelazydog");
        System.out.println(ans);
    }
    
    private static boolean panGram(String sentence) {
        Set<Character> nSet = new HashSet<>();

        for (int i = 0; i < sentence.length(); i++) {
            nSet.add(sentence.charAt(i));
        }

        if (nSet.size() > 25) {
            return true;
        }
        return false;
    }
}

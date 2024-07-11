package Leetcode.Hashing.MoreHashingExamples;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*You're given strings jewels representing the types of stones that are jewels, 
and stones representing the stones you have. Each character in stones is a type of stone you have.
 You want to know how many of the stones you have are also jewels. */
public class JewelsAndStones {
    public static void main(String[] args) {
        int ans1 = numJewelsInStones("aA", "aAAbbbb");
        System.out.println("Expected answer: 3");
        System.out.println(ans1);
        int ans2 = numJewelsInStones("zB", "bbbbbbbbZZZZZz");
        System.out.println("Expected answer: 1");
        System.out.println(ans2);

    }
    private static int numJewelsInStones(String jewels, String stones) {
        Set<Character> jewelsSet = new HashSet<>();
        int jewelsAcquisition = 0;
            
        for (int i = 0; i < jewels.length(); i++) {
            jewelsSet.add(jewels.charAt(i));
        }
        for (int i = 0; i < stones.length(); i++) {
            if (jewelsSet.contains(stones.charAt(i))) {
                jewelsAcquisition += 1;
            }
        }
        return jewelsAcquisition;
    }
}
 
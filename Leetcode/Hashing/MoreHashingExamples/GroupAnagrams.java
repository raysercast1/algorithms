package Leetcode.Hashing.MoreHashingExamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] arr = {"eat","tea","tan","ate","nat","bat"};
        List<ArrayList<String>> ans = groupingAnagrams(arr);
        System.out.println("Anagrams are:");
        System.out.println(ans);
    }

    private static List<ArrayList<String>> groupingAnagrams(String[] strs) {
        Map<String, ArrayList<String>> groups = new HashMap<>();
        for (String s: strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            
            if (!groups.containsKey(key)) {
                groups.put(key, new ArrayList<String>());
            }
            
            groups.get(key).add(s);
        }
        
        return new ArrayList(groups.values());
    }
}

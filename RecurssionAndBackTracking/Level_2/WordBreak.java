package RecurssionAndBackTracking.Level_2;

import java.util.*;

public class WordBreak {

    public static void main(String[] args) {
        try (Scanner scn = new Scanner(System.in)) {
            int n = scn.nextInt();
            HashSet<String> dict = new HashSet<>();
            for (int i = 0; i < n; i++) {
                dict.add(scn.next());
            }
            String sentence = scn.next();
            wordBreak(sentence, "", dict);
        }
    }

    public static void wordBreak(String str, String ans, HashSet<String> dict) {

        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            String left = str.substring(0, i + 1);
            String right = str.substring(i + 1);

            if (dict.contains(left)) {
                wordBreak(right, ans + left + " ", dict);
            }
        }
    }
}

// LeetCode - 139 - TLE
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        HashSet<String> dict = new HashSet<>();
        for(int i = 0 ; i < wordDict.size() ; i++){
            dict.add(wordDict.get(i));
        }
        boolean[] ans = new boolean[1];
        
        wordBreak_(s, ans, dict);
        return ans[0];
    }
    
    public static void wordBreak_(String str, boolean[] ans, HashSet<String> dict) {

        if (str.length() == 0) {
            // System.out.println(ans);
            ans[0] = true;
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            String left = str.substring(0, i + 1);
            String right = str.substring(i + 1);

            if (dict.contains(left)) {
                wordBreak_(right, ans, dict);
            }
        }
    }
}

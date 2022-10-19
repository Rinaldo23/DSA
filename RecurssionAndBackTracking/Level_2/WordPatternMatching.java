package RecurssionAndBackTracking.Level_2;

import java.util.*;

// LeetCode - 290 --- fails for one TC 
// pattern = "abba"
// String = "dogdogdogdog"
// output - false 
class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        String str = "";
        String[] ss = s.split(" ");
        for (String ele : ss) {
            str += ele;
        }
        boolean[] ans = new boolean[1];

        wordPattern_(str, pattern, map, pattern, ans);
        return ans[0];
    }

    public void wordPattern_(String str, String pattern, HashMap<Character, String> map, String op, boolean[] ans) {

        if (pattern.length() == 0) {
            if (str.length() == 0) {
                ans[0] = true;
            }
            return;
        }

        char ch = pattern.charAt(0);
        String rop = pattern.substring(1);

        if (map.containsKey(ch)) {

            String previousMapping = map.get(ch);

            if (str.length() >= previousMapping.length()) {
                String left = str.substring(0, previousMapping.length());
                String right = str.substring(previousMapping.length());

                if (previousMapping.equals(left)) {
                    wordPattern_(right, rop, map, op, ans);
                }
            }

        } else {
            for (int i = 0; i < str.length(); i++) {

                String left = str.substring(0, i + 1);
                String right = str.substring(i + 1);

                map.put(ch, left);
                wordPattern_(right, rop, map, op, ans);
                map.remove(ch);
            }
        }
    }
}
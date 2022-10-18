package RecurssionAndBackTracking.Level_2;

import java.util.*;

public class PalindromicPermutationsOfString {

    public static void generatepw(int cs, int ts, HashMap<Character, Integer> fmap, Character oddc, String asf) {

        if (cs > ts) {
            String rev = "";
            for (int i = asf.length() - 1; i >= 0; i--) {
                rev += asf.charAt(i);
            }
            String res = "";
            res += asf;

            if (oddc != null) {
                res += oddc;
            }

            res += rev;
            System.out.println(res);

            return;
        }

        for (Character ch : fmap.keySet()) {
            int freq = fmap.get(ch);
            if (freq > 0) {
                fmap.put(ch, freq - 1);
                generatepw(cs + 1, ts, fmap, oddc, asf + ch);
                fmap.put(ch, freq);
            }
        }
    }

    public static void main(String[] args) {
        try (Scanner scn = new Scanner(System.in)) {
            String str = scn.next();
            HashMap<Character, Integer> fmap = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);
            }

            Character ch = null;
            int odds = 0;
            int len = 0;

            for (Character c : fmap.keySet()) {
                int freq = fmap.get(c);

                if (freq % 2 == 1) {
                    ch = c;
                    odds++;
                }

                fmap.put(c, freq / 2);
                len += freq / 2;
            }

            if (odds > 1) {
                System.out.println(-1);
                return;
            }
            generatepw(1, len, fmap, ch, "");
        }
    }

}

// GFG - Works but didn't solve for lexicographical order 
class Solution
{
    public List<String> all_palindromes(String s)
    {
        List<String> ans = new ArrayList<>();
        HashMap<Character, Integer> fmap = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);
            }

            Character ch = null;
            int odds = 0;
            int len = 0;

            for (Character c : fmap.keySet()) {
                int freq = fmap.get(c);

                if (freq % 2 == 1) {
                    ch = c;
                    odds++;
                }

                fmap.put(c, freq / 2);
                len += freq / 2;
            }

            if (odds > 1) {
                return ans;
            }
            generatepw(1, len, fmap, ch, "", ans);
            return ans;
    }
    
    public void generatepw(int cs, int ts, HashMap<Character, Integer> fmap, Character oddc, String asf, List<String> ans) {

        if (cs > ts) {
            String rev = "";
            for (int i = asf.length() - 1; i >= 0; i--) {
                rev += asf.charAt(i);
            }
            String res = "";
            res += asf;

            if (oddc != null) {
                res += oddc;
            }

            res += rev;
            ans.add(res);

            return;
        }

        for (Character ch : fmap.keySet()) {
            int freq = fmap.get(ch);
            if (freq > 0) {
                fmap.put(ch, freq - 1);
                generatepw(cs + 1, ts, fmap, oddc, asf + ch, ans);
                fmap.put(ch, freq);
            }
        }
    }
}
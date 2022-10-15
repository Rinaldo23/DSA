package RecurssionAndBackTracking.Level_2;

import java.util.HashMap;

// Time Limit Exceded - But code works
public class Verbal_Arithmetic_Puzzle_1307 {
    public boolean isSolvable(String[] words, String result) {
        return setUp(words, result);
    }

    public boolean setUp(String[] words, String result) {

        HashMap<Character, Integer> mp = new HashMap<>();
        String unique = "";

        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            for (int j = 0; j < s.length(); j++) {
                char ch = s.charAt(j);
                if (!mp.containsKey(ch)) {
                    mp.put(ch, -1);
                    unique += ch;
                }
            }
        }

        for (int k = 0; k < result.length(); k++) {
            char ch = result.charAt(k);
            if (!mp.containsKey(ch)) {
                mp.put(ch, -1);
                unique += ch;
            }
        }

        boolean[] usedNumbers = new boolean[10];
        int[] count = new int[1];
        solution(unique, 0, mp, usedNumbers, words, result, count);
        if (count[0] == 0) {
            return false;
        }
        return true;
    }

    public static void solution(String unique, int idx,
            HashMap<Character, Integer> charIntMap, boolean[] usedNumbers,
            String[] words, String result, int[] count) {

        if (idx == unique.length()) {
            int numLeft = 0;
            for (int i = 0; i < words.length; i++) {
                String str = words[i];
                int a = getNum(str, charIntMap);
                numLeft += a;
            }
            int numRight = getNum(result, charIntMap);

            if (numLeft == numRight) {
                count[0] += 1;
            }
            return;
        }

        char ch = unique.charAt(idx);
        for (int num = 0; num <= 9; num++) {
            if (usedNumbers[num] == false) {
                charIntMap.put(ch, num);
                usedNumbers[num] = true;
                solution(unique, idx + 1, charIntMap, usedNumbers, words, result, count);
                usedNumbers[num] = false;
                charIntMap.put(ch, -1);
            }
        }
    }

    private static int getNum(String s, HashMap<Character, Integer> mp) {

        String num = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (mp.containsKey(ch)) {
                num += mp.get(ch);
            }
        }

        return Integer.parseInt(num);
    }
}

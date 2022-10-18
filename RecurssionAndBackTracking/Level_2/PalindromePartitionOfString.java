package RecurssionAndBackTracking.Level_2;

import java.util.*;

public class PalindromePartitionOfString {

    public static void solution(String str, String asf) {

        if (str.length() == 0) {
            System.out.println(asf);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            String a = str.substring(0, i + 1);
            String ros = str.substring(i + 1);
            if (isPalindrome(a)) {
                solution(ros, asf + "(" + a + ") ");
            }
        }

    }

    public static boolean isPalindrome(String str) {
        int li = 0;
        int ri = str.length() - 1;

        while (li < ri) {
            char left = str.charAt(li);
            char right = str.charAt(ri);

            if (left != right) {
                return false;
            }

            li++;
            ri--;
        }
        return true;
    }

    public static void main(String[] args) {
        try (Scanner scn = new Scanner(System.in)) {
            String str = scn.nextLine();
            solution(str, "");
        }
    }

}

// LeetCode Solution
// class Solution {
//     public List<List<String>> partition(String s) {
//         List<List<String>> ans = new ArrayList<>();
//         solution(s, "", ans);
//         return ans;
//     }
//     public static void solution(String str, String asf, List<List<String>> ans) {
//         if (str.length() == 0) {
//             // System.out.println(asf);
//             List<String> temp = new ArrayList<>();
//             String[] base = asf.split("-");
//             for(String s : base){
//                 temp.add(s);
//             }
//             ans.add(temp);
//             return;
//         }

//         for (int i = 0; i < str.length(); i++) {
//             String a = str.substring(0, i + 1);
//             String ros = str.substring(i + 1);
//             if (isPalindrome(a)) {
//                 solution(ros, asf + a + "-", ans);
//             }
//         }
//     }

//     public static boolean isPalindrome(String str) {
//         int li = 0;
//         int ri = str.length() - 1;

//         while (li < ri) {
//             char left = str.charAt(li);
//             char right = str.charAt(ri);

//             if (left != right) {
//                 return false;
//             }

//             li++;
//             ri--;
//         }
//         return true;
//     }
// }
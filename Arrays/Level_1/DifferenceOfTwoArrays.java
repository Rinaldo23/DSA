package Arrays.Level_1;

import java.util.Scanner;

public class DifferenceOfTwoArrays {
    public static void main(String[] args) {

        try (Scanner scn = new Scanner(System.in)) {
            int n1 = scn.nextInt();
            int[] a1 = new int[n1];
            for (int i = 0; i < n1; i++) {
                a1[i] = scn.nextInt();
            }

            int n2 = scn.nextInt();
            int[] a2 = new int[n2];
            for (int i = 0; i < n2; i++) {
                a2[i] = scn.nextInt();
            }

            int[] diff = new int[n2];
            int carry = 0;

            int i = a1.length - 1;
            int j = a2.length - 1;
            int k = diff.length - 1;

            while (k >= 0) {
                int val = 0;
                int a1Val = i >= 0 ? a1[i] : 0;

                if (a2[j] + carry >= a1Val) {
                    val = a2[j] + carry - a1Val;
                    carry = 0;
                } else {
                    val = a2[j] + carry + 10 - a1Val;
                    carry = -1;
                }

                diff[k] = val;

                i--;
                j--;
                k--;
            }

            int idx = 0;
            while (idx < diff.length) {
                if (diff[idx] == 0) {
                    idx++;
                } else {
                    break;
                }
            }

            while (idx < diff.length) {
                System.out.print(diff[idx]);
                idx++;
            }
        }

    }
}

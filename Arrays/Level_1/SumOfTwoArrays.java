package Arrays.Level_1;

public class SumOfTwoArrays {

    String calc_Sum(int a[], int n, int b[], int m) {

        int[] sum = new int[n > m ? n : m];
        int i = a.length - 1;
        int j = b.length - 1;
        int k = sum.length - 1;
        int carry = 0;

        while (k >= 0) {
            int val = carry;

            if (i >= 0) {
                val += a[i];
            }

            if (j >= 0) {
                val += b[j];
            }

            carry = val / 10;
            val = val % 10;

            sum[k] = val;

            i--;
            j--;
            k--;
        }

        String ans = "";

        if (carry != 0) {
            String str = Integer.toString(carry);
            ans += str;
        }

        for (int l : sum) {
            String str = Integer.toString(l);
            ans += str;
        }

        if (ans.charAt(0) == '0') {
            ans = ans.substring(1);
        }

        return ans;
    }

}

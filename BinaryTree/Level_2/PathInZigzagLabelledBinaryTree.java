package BinaryTree.Level_2;

import java.util.*;

public class PathInZigzagLabelledBinaryTree {
    public List<Integer> pathInZigZagTree(int label) {
        return pathInZigZagTree_(label);
    }

    public List<Integer> pathInZigZagTree_(int n) {

        int llv = 1;
        int sum = 0;
        while (sum < n) {
            sum += llv;
            llv *= 2;
        }
        llv /= 2;

        List<Integer> ans = new ArrayList<>();
        while (n != 1) {
            ans.add(n);
            int comp = (3 * llv) - n - 1;
            int par = comp / 2;
            n = par;
            llv /= 2;
        }
        ans.add(1);
        Collections.reverse(ans);
        return ans;
    }
}

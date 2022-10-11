package RecurssionAndBackTracking.Level_2;

import java.util.*;

public class Lexicographicalnumbers {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            dfs(i, n, ans);
        }
        return ans;
    }

    public void dfs(int i, int n, List<Integer> ans) {
        if (i > n)
            return;

        // System.out.println(i);
        ans.add(i);
        for (int j = 0; j < 10; j++) {
            dfs(10 * i + j, n, ans);
        }
    }
}

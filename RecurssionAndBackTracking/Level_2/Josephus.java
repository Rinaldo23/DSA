package RecurssionAndBackTracking.Level_2;

public class Josephus {
    // LeetCode & gfg - starts from 1
    public int findTheWinner(int n, int k) {
        if (n == 1)
            return 1;

        int x = findTheWinner(n - 1, k);
        int y = (x + k - 1) % n;
        return y + 1;
    }

    // Summeet Sir - starts from 0
    public int findTheWinner2(int n, int k) {
        if (n == 1)
            return 0;

        int x = findTheWinner(n - 1, k);
        int y = (x + k) % n;
        return y;
    }
}

package RecurssionAndBackTracking.Level_1;

import java.util.*;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        String[][] board = new String[n][n];
        List<List<String>> ans = new ArrayList<>();

        solve(board, 0, "", ans);

        return ans;

    }

    public void solve(String[][] board, int row, String asf, List<List<String>> ans) {

        if (row == board.length) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                String str = "";
                for (int j = 0; j < board.length; j++) {
                    if (board[i][j] == "Q") {
                        str += "Q";
                    } else {
                        str += ".";
                    }
                }
                temp.add(str);
            }
            ans.add(temp);
            return;
        }

        for (int col = 0; col < board[0].length; col++) {
            if (isQueenSafe(board, row, col) == true) {

                board[row][col] = "Q";
                solve(board, row + 1, asf + row + "-" + col, ans);
                board[row][col] = "";

            }
        }

    }

    private boolean isQueenSafe(String[][] board, int row, int col) {

        for (int i = row - 1, j = col; i >= 0; i--) {
            if (board[i][j] == "Q") {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == "Q") {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == "Q") {
                return false;
            }
        }

        return true;
    }
}

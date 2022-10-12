package RecurssionAndBackTracking.Level_2;

public class PathWithMaximumGold {
    public int getMaximumGold(int[][] grid) {
        int finalSum = Integer.MIN_VALUE;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int rres = travelAndCollectGold(grid, i, j, visited);
                finalSum = Math.max(finalSum, rres);
            }
        }
        return finalSum;
    }

    public int travelAndCollectGold(int[][] grid, int i, int j, boolean[][] visited) {

        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || visited[i][j] == true)
            return 0;

        visited[i][j] = true;
        int temp = Integer.MIN_VALUE;
        temp = Math.max(temp, grid[i][j] + travelAndCollectGold(grid, i - 1, j, visited));
        temp = Math.max(temp, grid[i][j] + travelAndCollectGold(grid, i + 1, j, visited));
        temp = Math.max(temp, grid[i][j] + travelAndCollectGold(grid, i, j - 1, visited));
        temp = Math.max(temp, grid[i][j] + travelAndCollectGold(grid, i, j + 1, visited));
        visited[i][j] = false;
        return temp;
    }
}

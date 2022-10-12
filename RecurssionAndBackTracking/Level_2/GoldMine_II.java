package RecurssionAndBackTracking.Level_2;

import java.util.ArrayList;

// Wrong -->  For understanding 
public class GoldMine_II {
    public int getMaximumGold(int[][] grid) {
        int finalSum = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[i].length ; j++){
                
                ArrayList<Integer> bag = new ArrayList<>();
                if(grid[i][j] != 0 && visited[i][j] == false){
                    travelAndCollectGold(grid, i, j, visited, bag);
                }
                
                int sum = 0;
                for(int val : bag){
                    sum += val;
                }
                
                if(sum > finalSum){
                    finalSum = sum;
                }
            }
        }
        return finalSum;
    }
    
    public void travelAndCollectGold(int[][] grid, int i, int j, boolean[][] visited, ArrayList<Integer> bag){
        
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || visited[i][j] == true) return;
        
        visited[i][j] = true;
        bag.add(grid[i][j]);
        travelAndCollectGold(grid, i - 1, j, visited, bag);
        travelAndCollectGold(grid, i, j + 1, visited, bag);
        travelAndCollectGold(grid, i, j - 1, visited, bag);
        travelAndCollectGold(grid, i + 1, j, visited, bag);
    }
}

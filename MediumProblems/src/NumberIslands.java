import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NumberIslands {

    public static void main(String[] args) {


        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        System.out.println("Number of islands: " + numIslands(grid));

    }

    public static int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        int numIslands = 0;


        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                if (grid[i][j] == '1') {
                    numIslands++;
                    dfs(grid, i, j);
                }

            }
        }


        return numIslands;
    }

    public static void dfs(char[][] grid, int i, int j) {

        int[][] adjacentSpots = {
                {0, 1},
                {1, 0},
                {0, -1},
                {-1, 0}
        };

        grid[i][j] = '0';
        for (int[] spot : adjacentSpots) {
            if  (
                    !isOutOfBounds(i + spot[0], j + spot[1], grid)
                    && grid[i + spot[0]][j + spot[1]] == '1'
            ) {
                // Visit adjacent spots
                dfs(grid, i + spot[0], j + spot[1]);
            }
        }

    }

    public static boolean isOutOfBounds(int row, int col, char[][] grid) {
        return row < 0 || row >= grid.length || col < 0 || col >= grid[0].length;
    }

}

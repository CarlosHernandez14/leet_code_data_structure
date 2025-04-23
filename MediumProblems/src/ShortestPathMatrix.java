import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathMatrix {

    public static void main(String[] args) {

//        int[][] grid = {
//                {0,0,0},
//                {1,1,0},
//                {1,1,0}
//        };
//        int[][] grid = {
//                {1,0,0},
//                {1,1,0},
//                {1,1,0}
//        };
//        int[][] grid = {
//                {0,0,0},
//                {1,1,0},
//                {1,1,1}
//        };
//        int[][] grid = {
//                {0}
//        };
        int[][] grid = {
                {0,1,1,1,1,1,1,1},
                {0,1,1,0,0,0,0,0},
                {0,1,0,1,1,1,1,0},
                {0,1,0,1,1,1,1,0},
                {0,1,1,0,0,1,1,0},
                {0,1,1,1,1,0,1,0},
                {0,0,0,0,0,1,1,0},
                {1,1,1,1,1,1,1,0}
        };


//        int[][] grid = {
//                {0,1},
//                {1,0}
//        };

        System.out.println("Shortest Path = " + shortestPathBinaryMatrix(grid));

    }

    public static int shortestPathBinaryMatrix(int[][] grid) {

        if (grid[0][0] == 1 || grid[grid.length - 1][grid[0].length -1] == 1) return -1;
        if (grid.length == 1 && grid[0].length == 1 && grid[0][0] == 0) return 1;

        int[][] disMatrix = new int[grid.length][grid[0].length];
        // Fill the matrix with +inf numbers
        for (int[] row : disMatrix) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        disMatrix[0][0] = 0;
        Queue<PairValue> queue = new LinkedList<PairValue>();

        // Adjacency matrix for directions (Can move 8 directions)
        // Coordinates going on clock direction
        int[] rowDis = {0, 1, 1, 1, 0, -1, -1, -1};
        int[] colDis = {1, 1, 0, -1, -1, -1, 0, 1};

        // Push the first pair at 0, 0 index
        queue.add(new PairValue(0, 0, 0));
        while (!queue.isEmpty()) {
            PairValue currentPair = queue.poll();
            // Check the pair for all the directions
            for (int i = 0; i < rowDis.length; i++) {
                int newRow = currentPair.rowInd + rowDis[i];
                int newCol = currentPair.colInd + colDis[i];
                // Check if it's valid to change the distance Matrix
                // First check out of bound, then check if its 0 to move through
                if (!isOutOfBounds(newRow, newCol, grid) && grid[newRow][newCol] == 0) {
                    // Check if the new value it's shorter than the current one in the dis matrix
                    int newDistance = currentPair.distance + 1;
                    disMatrix[newRow][newCol] = Math.min(disMatrix[newRow][newCol], newDistance);
                    if (newRow == grid.length - 1 && newCol == grid[0].length - 1)
                        return disMatrix[newRow][newCol] + 1;
                    // Push the new Distance to the queue
                    queue.add(new PairValue(newDistance, newRow, newCol));
                }
            }
        }

        return -1;
    }

    public static boolean isOutOfBounds(int row, int col, int[][] grid) {
        return row < 0 || row >= grid.length || col < 0 || col >= grid[0].length;
    }

    static class PairValue {
        int distance;
        int rowInd;
        int colInd;

        PairValue(int distance, int rowInd, int colInd) {
            this.distance = distance;
            this.rowInd = rowInd;
            this.colInd = colInd;
        }
    }

}

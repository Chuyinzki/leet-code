public class MinPathSum {

    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        }));
    }

    public static int minPathSum(int[][] grid) {
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (x == 0 && y == 0) continue;
                grid[x][y] += Math.min(x > 0 ? grid[x - 1][y] : Integer.MAX_VALUE, y > 0 ? grid[x][y - 1] : Integer.MAX_VALUE);
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}

public class NumIslands {

    public static void main(String[] args) {
        numIslands(new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}});
    }

    public static int numIslands(char[][] grid) {
        int retIslands = 0;
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (grid[x][y] == '1') {
                    retIslands++;
                    grid = traverse(grid, x, y);
                }
            }
        }
        return retIslands;
    }

    public static char[][] traverse(char[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) return grid;
        char cur = grid[x][y];
        if (cur == '0') return grid;
        grid[x][y] = '0';
        grid = traverse(grid, x - 1, y);
        grid = traverse(grid, x + 1, y);
        grid = traverse(grid, x, y + 1);
        grid = traverse(grid, x, y - 1);
        return grid;
    }
}

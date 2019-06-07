public class KeepingSkyline {

    public static void main(String[] args) {
        System.out.println(maxIncreaseKeepingSkyline(
            new int[][]{{13, 47, 91, 34, 20, 33, 39, 22, 80, 62},
                {73, 97, 88, 51, 38, 36, 52, 75, 25, 99}, {95, 43, 32, 26, 82, 74, 60, 69, 59, 55},
                {20, 41, 77, 95, 79, 46, 70, 50, 17, 51}, {51, 0, 93, 27, 46, 41, 58, 49, 8, 5},
                {92, 58, 38, 56, 73, 93, 34, 47, 23, 62}, {97, 66, 57, 72, 26, 46, 4, 90, 82, 74},
                {7, 44, 67, 96, 0, 82, 75, 22, 53, 100}, {95, 48, 46, 68, 41, 53, 69, 42, 13, 87},
                {79, 48, 96, 39, 21, 35, 3, 12, 22, 42}}));
    }

    public static int maxIncreaseKeepingSkyline(int[][] grid) {
        int[][] curSkyline = new int[2][grid.length]; //first is x, second is y
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                curSkyline[0][x] = Math.max(curSkyline[0][x], grid[x][y]);
                curSkyline[1][y] = Math.max(curSkyline[1][y], grid[x][y]);
            }
        }
        int ret = 0;
        for (int x = 0; x < grid.length; x++) {
            int curX = curSkyline[0][x];
            for (int y = 0; y < grid[0].length; y++) {
                int curY = curSkyline[1][y];
                ret += Math.min(curX, curY) - grid[x][y];
            }
        }
        return ret;
    }
}

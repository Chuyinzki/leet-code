public class UniquePaths {

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7)); // answer should be
    }

    public static int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 0;
        int[][] map = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i + 1 >= map.length || j + 1 >= map[0].length) {
                    map[i][j] = 1;
                } else {
                    map[i][j] = map[i + 1][j] + map[i][j + 1];
                }
            }
        }
        return map[0][0];
    }
}

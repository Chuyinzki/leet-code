public class MinTimeToVisitAllPoints {

    public static void main(String[] args) {
        minTimeToVisitAllPoints(new int[][]{{1, 1}, {3, 4}, {-1, 0}});
    }

    public static int minTimeToVisitAllPoints(int[][] points) {
        int[] curPoint = points[0];
        int secondsTraveled = 0;
        for (int i = 1; i < points.length; i++) {
            int[] nextPoint = points[i];
            secondsTraveled += Math
                .max(Math.abs(nextPoint[0] - curPoint[0]), Math.abs(nextPoint[1] - curPoint[1]));
            curPoint = nextPoint;
        }
        return secondsTraveled;
    }
}

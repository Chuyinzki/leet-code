public class SubtractProductAndSum {

    public int subtractProductAndSum(int n) {
        int sum = 0;
        int mult = 1;
        int rem = n;
        while (rem > 0) {
            int temp = rem % 10;
            sum += temp;
            mult *= temp;
            rem = rem / 10;
        }
        return mult - sum;
    }
}

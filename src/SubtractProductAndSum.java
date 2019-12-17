public class SubtractProductAndSum {
    public int subtractProductAndSum(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        int sum = 0;
        int mult = 1;
        for(int i = chars.length - 1; i >= 0; i--) {
            int val = Integer.parseInt(chars[i] + "");
            sum += val;
            mult *= val;
        }
        return mult - sum;
    }
}

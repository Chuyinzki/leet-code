public class SubtractProductAndSum {
    public int subtractProductAndSum(int n) {
        String str = String.valueOf(n);
        int sum = 0;
        int mult = 1;
        for(int i = 0; i < str.length(); i++) {
            int val = Integer.parseInt(str.charAt(i) + "");
            sum += val;
            mult *= val;
        }
        return mult - sum;
    }
}

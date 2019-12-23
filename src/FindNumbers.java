public class FindNumbers {

    public int findNumbers(int[] nums) {
        int ret = 0;
        for (int num : nums) {
            int length = 0;
            while (num > 0) {
                length++;
                num /= 10;
            }
            if (length % 2 == 0) {
                ret++;
            }
        }
        return ret;
    }
}

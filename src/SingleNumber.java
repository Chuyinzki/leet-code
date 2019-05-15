public class SingleNumber {

    public static void main(String[] args) {
        //[4,1,2,1,2] -> 4
        singleNumber(new int[]{4, 1, 2, 1, 2});
    }

    public static int singleNumber(int[] nums) {
        int ret = 0;
        for (int i : nums)
            ret = ret ^ i;
        return ret;
    }
}

public class FindDuplicate {

    public int findDuplicate(int[] nums) {
        int summation = 0;
        for (int i = 1; i < nums.length; i++)
            summation += i;
        for (int num : nums) summation -= num;
        return Math.abs(summation);
    }
}

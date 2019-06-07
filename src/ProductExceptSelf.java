public class ProductExceptSelf {

    //output = [24,12,8,6]
    public static void main(String[] args) {
        productExceptSelf(new int[]{1, 2, 3, 4});
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] multForward = new int[nums.length];
        multForward[0] = 1;
        int mult = 1;
        for (int i = 1; i < nums.length; i++) {
            mult *= nums[i - 1];
            multForward[i] = mult;
        }

        int[] multBackward = new int[nums.length];
        multBackward[nums.length - 1] = 1;
        mult = 1;
        for (int i = nums.length - 1; i > 0; i--) {
            mult *= nums[i];
            multBackward[i - 1] = mult;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = multForward[i] * multBackward[i];
        }
        return nums;
    }

}

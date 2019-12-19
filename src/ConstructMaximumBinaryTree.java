import Objects.TreeNode;
import java.util.Arrays;

public class ConstructMaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return createMaxTreeHelper(nums);
    }

    private TreeNode createMaxTreeHelper(int[] nums) {
        if(nums.length == 1)
            return new TreeNode(nums[0]);
        int indexOfMax = findMaxIndex(nums);
        TreeNode root = new TreeNode(nums[indexOfMax]);
        if(indexOfMax > 0 && indexOfMax <= nums.length - 1)
            root.left = createMaxTreeHelper(Arrays.copyOfRange(nums, 0, indexOfMax));
        if(indexOfMax <= nums.length - 2)
            root.right = createMaxTreeHelper(Arrays.copyOfRange(nums, indexOfMax + 1, nums.length));
        return root;
    }

    private int findMaxIndex(int[] nums) {
        int maxIndex = 0;
        int maxCurNum = 0;
        for(int i = 0; i < nums.length; i++)
            if(nums[i] > maxCurNum) {
                maxIndex = i;
                maxCurNum = nums[i];
            }
        return maxIndex;
    }
}

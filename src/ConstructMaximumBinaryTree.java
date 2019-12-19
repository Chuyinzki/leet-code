import Objects.TreeNode;
import java.util.Arrays;

public class ConstructMaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return createMaxTreeHelper(nums, 0 , nums.length);
    }

    private TreeNode createMaxTreeHelper(int[] nums, int start, int end) {
        int indexOfMax = findMaxIndex(nums, start, end);
        if(indexOfMax == -1)
            return null;
        TreeNode root = new TreeNode(nums[indexOfMax]);
        if(indexOfMax > start)
            root.left = createMaxTreeHelper(nums, start, indexOfMax);
        if(indexOfMax <= end - 1)
            root.right = createMaxTreeHelper(nums, indexOfMax + 1, end);
        return root;
    }

    private int findMaxIndex(int[] nums, int start, int end) {
        int maxIndex = -1;
        int maxCurNum = -1;
        for(int i = start; i < end; i++)
            if(nums[i] > maxCurNum) {
                maxIndex = i;
                maxCurNum = nums[i];
            }
        return maxIndex;
    }
}

import java.util.ArrayList;
import java.util.List;

public class MoveZeros {

    public static void main(String[] args) {
        moveZeroes(new int[]{0,1,0,3,12});
    }

    public static void moveZeroes(int[] nums) {
        List<Integer> zerosIndex = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(!zerosIndex.isEmpty() && nums[i] != 0) {
                int zeroIndex = zerosIndex.remove(0);
                nums[zeroIndex] = nums[i];
                nums[i] = 0;
                zerosIndex.add(i);
            } else if(nums[i] == 0)
                zerosIndex.add(i);
        }
    }
}

import java.util.ArrayList;
import java.util.List;

public class CountingBits {

    public static void main(String[] args) {
        //2 -> [0,1,1]
        countBits(2);
    }

    public static int[] countBits(int num) {
        List<Integer> retList = new ArrayList<>();
        for (int i = 0; i <= num; i++) {
            retList.add(countBitsHelper(i));
        }

        return retList.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int countBitsHelper(int num) {
        int count = 0;
        while (num > 0) {
            count += num & 1;
            num >>= 1;
        }
        return count;
    }
}

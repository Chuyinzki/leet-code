import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupThePeople {

    public static void main(String[] args) {
        groupThePeople(new int[]{3,3,3,3,3,1,3});
    }

    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> retList = new ArrayList<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];
            List<Integer> temp = map.get(size);
            if(temp == null)
                temp = new ArrayList<>();
            temp.add(i);
            if(temp.size() == size) {
                retList.add(new ArrayList<>(temp));
                temp.clear();
            }
            map.put(size, temp);
        }
        return retList;
    }
}

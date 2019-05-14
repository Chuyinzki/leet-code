import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ReconstructQueue {

    //Output should be [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
    public static void main(String[] args) {
        reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}});
    }

    public static int[][] reconstructQueue(int[][] people) {
        List<Integer[]> ordered = new ArrayList<>();
        List<Integer[]> unordered = new ArrayList<>();

        for (int[] person : people) {
            unordered.add(Arrays.stream(person).boxed().toArray(Integer[]::new));
        }
        int counter = 0;
        while (!unordered.isEmpty()) {
            Iterator<Integer[]> iter = unordered.iterator();
            while (iter.hasNext()) {
                Integer[] person = iter.next();
                if (person[1] != counter) continue;
                int personSize = person[0];
                int greaterThanCounter = 0;
                boolean addedFlag = false;
                for (int j = 0; j < ordered.size(); j++) {
                    if (ordered.get(j)[0] >= personSize)
                        greaterThanCounter++;
                    if (greaterThanCounter > person[1]) {
                        ordered.add(j, person);
                        iter.remove();
                        addedFlag = true;
                        break;
                    }
                }
                if (!addedFlag) {
                    ordered.add(person);
                    iter.remove();
                }
            }
            counter++;
        }
        for (int i = 0; i < people.length; i++) {
            people[i] = Arrays.stream(ordered.get(i)).mapToInt(Integer::intValue).toArray();
        }
        return people;
    }
}

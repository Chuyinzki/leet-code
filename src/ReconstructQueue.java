import javafx.util.Pair;

import java.util.HashSet;

public class ReconstructQueue {
    //Output should be [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
    public static void main(String[] args) {
        reconstructQueue(new int[][]
                {{40,11},{81,12},{32,60},{36,39},{76,19},{11,37},{67,13},{45,39},{99,0},{35,20},{15,3},{62,13},{90,2},{86,0},
                        {26,13},{68,32},{91,4},{23,24},{73,14},{86,13},{62,6},{36,13},{67,9},{39,57},{15,45},{37,26},{12,88},
                        {30,18},{39,60},{77,2},{24,38},{72,7},{96,1},{29,47},{92,1},{67,28},{54,44},{46,35},{3,85},{27,9},{82,14},
                        {29,17},{80,11},{84,10},{5,59},{82,6},{62,25},{64,29},{88,8},{11,20},{83,0},{94,4},{43,42},{73,9},{57,32},
                        {76,24},{14,67},{86,2},{13,47},{93,1},{95,2},{87,8},{8,78},{58,16},{26,75},{26,15},{24,56},{69,9},{42,22},
                        {70,17},{34,48},{26,39},{22,28},{21,8},{51,44},{35,4},{25,48},{78,18},{29,30},{13,63},{68,8},{21,38},{56,20},
                        {84,14},{56,27},{60,40},{98,0},{63,7},{27,46},{70,13},{29,23},{49,6},{5,64},{67,11},{2,31},{59,8},{93,0},{50,39},{84,6},{19,39}});
    }

    public static int[][] reconstructQueue(int[][] people) {
        if(people.length == 0) return people;
        return reconstructQueueHelper(new int[0][0], people);
    }

    public static int[][] reconstructQueueHelper(int[][] orderedPeople, int[][] remainingPeople) {
        int[][] remainingPeopleRunning = new int[remainingPeople.length - 1][2];
        int runningCounter = 0;
        for (int j = 0; j < remainingPeople.length; j++) {
            int[] remainingPerson = remainingPeople[j];
            int size = remainingPerson[0];
            int tallerOrEqual = remainingPerson[1];
            int sizeCounter = 0;
            for (int i = 0; i < orderedPeople.length; i++) {
                if (orderedPeople[i][0] >= size) sizeCounter++;
                if (sizeCounter > tallerOrEqual) break;
            }
            if (sizeCounter != tallerOrEqual) {
                if (runningCounter == remainingPeopleRunning.length) return null;
                remainingPeopleRunning[runningCounter++] = remainingPerson;
                continue;
            }
            int[][] result;
            int[][] newOrderedArray = new int[orderedPeople.length + 1][2];
            int[][] newRemainingArray = new int[remainingPeople.length - 1][2];
            System.arraycopy(orderedPeople, 0, newOrderedArray, 0, orderedPeople.length);
            newOrderedArray[newOrderedArray.length - 1] = remainingPerson;
            if (newRemainingArray.length == 0)
                return newOrderedArray;
            System.arraycopy(remainingPeople, j + 1, newRemainingArray, j, newRemainingArray.length - j);
            System.arraycopy(remainingPeopleRunning, 0, newRemainingArray, 0, j);

            result = reconstructQueueHelper(newOrderedArray, newRemainingArray);
            if (result == null) {
                if (runningCounter == remainingPeopleRunning.length) return null;
                remainingPeopleRunning[runningCounter++] = remainingPerson;
            } else {
                if(result.length == orderedPeople.length + remainingPeople.length)
                    return result;
                int[][] finalResult = new int[orderedPeople.length + result.length][2];
                System.arraycopy(orderedPeople, 0, finalResult, 0, orderedPeople.length);
                System.arraycopy(finalResult, 0, finalResult, orderedPeople.length, finalResult.length);
                return finalResult;
            }
        }
        return null;
    }
}

public class ReconstructQueueRecursive {

    //Output should be [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
    public static void main(String[] args) {
        reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}});
    }

    public static int[][] reconstructQueue(int[][] people) {
        if (people.length == 0) {
            return people;
        }
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
                if (orderedPeople[i][0] >= size) {
                    sizeCounter++;
                }
                if (sizeCounter > tallerOrEqual) {
                    break;
                }
            }
            if (sizeCounter != tallerOrEqual) {
                if (runningCounter == remainingPeopleRunning.length) {
                    return null;
                }
                remainingPeopleRunning[runningCounter++] = remainingPerson;
                continue;
            }
            int[][] result;
            int[][] newOrderedArray = new int[orderedPeople.length + 1][2];
            int[][] newRemainingArray = new int[remainingPeople.length - 1][2];
            System.arraycopy(orderedPeople, 0, newOrderedArray, 0, orderedPeople.length);
            newOrderedArray[newOrderedArray.length - 1] = remainingPerson;
            if (newRemainingArray.length == 0) {
                return newOrderedArray;
            }
            System.arraycopy(remainingPeople, j + 1, newRemainingArray, j,
                newRemainingArray.length - j);
            System.arraycopy(remainingPeopleRunning, 0, newRemainingArray, 0, j);

            result = reconstructQueueHelper(newOrderedArray, newRemainingArray);
            if (result == null) {
                if (runningCounter == remainingPeopleRunning.length) {
                    return null;
                }
                remainingPeopleRunning[runningCounter++] = remainingPerson;
            } else {
                if (result.length == orderedPeople.length + remainingPeople.length) {
                    return result;
                }
                int[][] finalResult = new int[orderedPeople.length + result.length][2];
                System.arraycopy(orderedPeople, 0, finalResult, 0, orderedPeople.length);
                System.arraycopy(finalResult, 0, finalResult, orderedPeople.length,
                    finalResult.length);
                return finalResult;
            }
        }
        return null;
    }
}

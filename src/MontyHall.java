import java.util.ArrayList;
import java.util.Random;

public class MontyHall {

    public static void main(String[] args) {
        long tries = 1000;
        long switchWins = test(tries, true);
        long noSwitchWins = test(tries, false);
        System.out.printf("Switching won %d/%d times which is %%%2f\n", switchWins, tries, 100 * switchWins / (float) tries);
        System.out.printf("Not switching won %d/%d times which is %%%2f\n", noSwitchWins, tries, 100 * noSwitchWins / (float) tries);
    }

    static long test(long attempts, boolean shouldSwitch) {
        final int numOfDoors = 3;
        long wins = 0;
        long i = 0;
        Random rand = new Random();
        while (i++ < attempts) {
            final int correctDoor = rand.nextInt(numOfDoors);

            //populating doors
            ArrayList<Boolean> doors = new ArrayList<>();
            for (int j = 0; j < numOfDoors; j++)
                doors.add(j == correctDoor);
            int selectedDoor = rand.nextInt(numOfDoors);

            //delete wrong door
            for (int j = 0; j < numOfDoors; j++) {
                if (j != selectedDoor && !doors.get(j)) {
                    doors.set(j, null);
                    break;
                }
            }

            //switching if chose to
            if (shouldSwitch) {
                for (int j = 0; j < numOfDoors; j++) {
                    if (j != selectedDoor && doors.get(j) != null) {
                        selectedDoor = j;
                        break;
                    }
                }
            }
            wins += doors.get(selectedDoor) ? 1 : 0;
        }
        return wins;
    }
}

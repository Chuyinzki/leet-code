package Objects;

import java.util.LinkedList;

public class RecentCounter {

    final LinkedList<Integer> pings;

    public RecentCounter() {
        pings = new LinkedList<>();
    }

    public int ping(int t) {
        pings.add(t);
        while (pings.peek() < t - 3000) {
            pings.poll();
        }
        return pings.size();
    }
}

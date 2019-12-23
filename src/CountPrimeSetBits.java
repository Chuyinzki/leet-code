import java.util.Map;

public class CountPrimeSetBits {

    public static void main(String[] args) {
        countPrimeSetBits(990,1048);
    }

    public static int countPrimeSetBits(int L, int R) {
        int primes = 0;
        boolean[] backwardsMap = getBackwardsMap(Integer.toBinaryString(R).length());
        while(L <= R) {
            primes += backwardsMap[Integer.bitCount(L++)] ? 0 : 1;
        }
        return primes;
    }

    private static boolean[] getBackwardsMap(int max) {
        boolean[] primeMap = new boolean[max + 1];
        primeMap[0] = true;
        primeMap[1] = true;
        for(int i = 2; i < primeMap.length; i++) {
            if(primeMap[i]) continue;
            for(int j = i + i; j < primeMap.length; j+=i)
                primeMap[j] = true;
        }
        return primeMap;
    }
}

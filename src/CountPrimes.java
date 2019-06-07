public class CountPrimes {

    //Sieve
    public int countPrimes(int n) {
        if (n < 2) {
            return 0;
        }
        boolean[] arr = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (arr[i]) {
                continue;
            }
            for (int j = i + i; j < arr.length; j += i) {
                arr[j] = true;
            }
        }
        int ret = 0;
        for (int i = 2; i < arr.length; i++) {
            if (!arr[i]) {
                ret++;
            }
        }
        return ret;
    }
}

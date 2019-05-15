public class HammingDistance {
    public static void main(String[] args) {
        /* 1 -> (0 0 0 1)
         *  4 -> (0 1 0 0)
         *  Two of their bits are different, so answer is 2. */
        hammingDistance(1, 4);
    }

    public static int hammingDistance(int x, int y) {
        int diff = x ^ y;
        int ret = 0;
        while (diff > 0) {
            ret += diff & 1;
            diff >>= 1;
        }
        return ret;
    }
}

public class BitManipulation {

    // ---------------------------------------
    // CHECK i-th BIT (0 based index)
    // TC: O(1)
    // ---------------------------------------
    static boolean checkBit(int n, int i) {
        return (n & (1 << i)) != 0;
    }

    // ---------------------------------------
    // SET i-th BIT
    // TC: O(1)
    // ---------------------------------------
    static int setBit(int n, int i) {
        return n | (1 << i);
    }

    // ---------------------------------------
    // CLEAR i-th BIT
    // TC: O(1)
    // ---------------------------------------
    static int clearBit(int n, int i) {
        return n & ~(1 << i);
    }

    // ---------------------------------------
    // TOGGLE i-th BIT
    // TC: O(1)
    // ---------------------------------------
    static int toggleBit(int n, int i) {
        return n ^ (1 << i);
    }
    // ---------------------------------------------
    // UNSET / CLEAR k-th BIT (make it 0)
    // TC: O(1)
    // ---------------------------------------------
    static int unsetKthBit(int n, int k) {
        return n & ~(1 << k);
    }

    // ---------------------------------------------
    // TOGGLE k-th BIT
    // TC: O(1)
    // ---------------------------------------------
    static int toggleKthBit(int n, int k) {
        return n ^ (1 << k);
    }
    // ---------------------------------------------
    // FIND x % (2^k)
    // TC: O(1)
    // ---------------------------------------------
    static int modPowerOf2(int x, int k) {

        // mask with k lowest bits set
        return x & ((1 << k) - 1);
    }

    // ---------------------------------------------
    // MULTIPLY BY 2^k
    // TC: O(1)
    // ---------------------------------------------
    static int multiplyByPowerOf2(int x, int k) {
        return x << k;
    }
    // ---------------------------------------------
    // DIVIDE BY 2^k
    // TC: O(1)
    // ---------------------------------------------
    static int divideByPowerOf2(int x, int k) {
        return x >> k;
    }
    // ---------------------------------------------
    // CHECK IF ALL BITS ARE SAME (all 0 or all 1s)
    // Works for numbers like: 0, 1, 3, 7, 15, 31...
    // TC: O(1)
    // ---------------------------------------------
    static boolean areAllBitsSame(int n) {

        // n is of form 2^k - 1  OR  n == 0
        return n == 0 || ( (n & (n + 1)) == 0 );
    }

    // ---------------------------------------------
    // REMOVE LOWEST SET BIT
    // TC: O(1)
    // ---------------------------------------------
    static int removeLowestSetBit(int n) {
        return n & (n - 1);
    }


    // ---------------------------------------
    // COUNT SET BITS (FASTEST)
    // TC: O(1)
    // ---------------------------------------
    static int countSetBits(int n) {
        return Integer.bitCount(n);
    }

    // ---------------------------------------
    // CHECK POWER OF 2
    // TC: O(1)
    // ---------------------------------------
    static boolean isPowerOf2(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }


    // ---------------------------------------
    // GET LOWEST SET BIT VALUE
    // TC: O(1)
    // ---------------------------------------
    static int lowestSetBit(int n) {
        return n & -n;
    }

    // ---------------------------------------
    // FIND SINGLE NUMBER (others appear twice)
    // TC: O(n)
    // ---------------------------------------
    static int singleNumber(int[] arr) {
        int xor = 0;
        for (int x : arr) xor ^= x;
        return xor;
    }

    // ---------------------------------------
    // SWAP WITHOUT TEMP
    // TC: O(1)
    // ---------------------------------------
    static void swap(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
    }

    // ---------------------------------------
    // MAX XOR IN RANGE [L, R]
    // TC: O(1)
    // ---------------------------------------
    static int maximizingXOR(int l, int r) {

        int x = l ^ r;   // find highest differing bit
        int pos = 0;

        while (x > 0) {
            pos++;
            x >>= 1;
        }

        // answer is all 1s till that position
        return (1 << pos) - 1;
    }

    // ---------------------------------------
    // CHECK EVEN / ODD
    // TC: O(1)
    // ---------------------------------------
    static boolean isEven(int n) {
        return (n & 1) == 0;
    }

    // ---------------------------------------
    // MULTIPLY BY 2
    // TC: O(1)
    // ---------------------------------------
    static int multiplyBy2(int n) {
        return n << 1;
    }

    // ---------------------------------------
    // DIVIDE BY 2
    // TC: O(1)
    // ---------------------------------------
    static int divideBy2(int n) {
        return n >> 1;
    }

    // ---------------------------------------
    // LARGEST POWER OF 2 ≤ N
    // TC: O(1)
    // ---------------------------------------
    static int largestPowerOf2(int n) {
        return Integer.highestOneBit(n);
    }

    // ---------------------------------------
    // NEXT POWER OF 2 ≥ N
    // TC: O(1)
    // ---------------------------------------
    static int nextPowerOf2(int n) {
        if (n <= 1) return 1;
        return Integer.highestOneBit(n - 1) << 1;
    }

    public static void main(String[] args) {

        System.out.println(checkBit(10,1)); // true

        System.out.println(setBit(10,2));   // 14

        System.out.println(clearBit(10,1)); // 8

        System.out.println(toggleBit(10,1)); // 8

        System.out.println(countSetBits(29));

        System.out.println(isPowerOf2(16));

        System.out.println(removeLowestSetBit(12));

        System.out.println(lowestSetBit(12));

        System.out.println(maximizingXOR(5,12));
    }
}

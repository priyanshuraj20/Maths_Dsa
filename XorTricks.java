import java.util.*;
public class XorTricks {



    // -------------------------------------------------
    // BUILD PREFIX XOR ARRAY
    // prefix[i] = arr[0] ^ arr[1] ^ ... ^ arr[i]
    // TC: O(n)
    // -------------------------------------------------
    static int[] buildPrefixXor(int[] arr) {

        int n = arr.length;
        int[] pref = new int[n];

        pref[0] = arr[0];

        for (int i = 1; i < n; i++) {
            pref[i] = pref[i - 1] ^ arr[i];
        }

        return pref;
    }

    // -------------------------------------------------
    // RANGE XOR QUERY [L, R]
    // Using prefix XOR
    // TC: O(1)
    // -------------------------------------------------
    static int rangeXor(int[] pref, int L, int R) {

        // if range starts from 0
        if (L == 0)
            return pref[R];

        // XOR cancels left part
        return pref[R] ^ pref[L - 1];
    }

    // -------------------------------------------------
    // XOR FROM 1 TO N (PATTERN BASED)
    // TC: O(1)
    // -------------------------------------------------
    static int xorTillN(int n) {

        // pattern repeats every 4
        if (n % 4 == 0) return n;
        if (n % 4 == 1) return 1;
        if (n % 4 == 2) return n + 1;
        return 0;
    }

    // -------------------------------------------------
    // XOR IN RANGE [L, R] USING MATH TRICK
    // xor(L,R) = xorTillN(R) ^ xorTillN(L-1)
    // TC: O(1)
    // -------------------------------------------------
    static int xorRangeFast(int L, int R) {

        return xorTillN(R) ^ xorTillN(L - 1);
    }

    // -------------------------------------------------
    // FIND SINGLE NUMBER (others appear twice)
    // TC: O(n)
    // -------------------------------------------------
    static int findSingle(int[] arr) {

        int xor = 0;

        for (int x : arr)
            xor ^= x;   // duplicates cancel

        return xor;
    }

    // -------------------------------------------------
    // FIND TWO SINGLE NUMBERS (others appear twice)
    // TC: O(n)
    // -------------------------------------------------
    static int[] findTwoSingles(int[] arr) {

        int xor = 0;

        // XOR of two unique numbers
        for (int x : arr)
            xor ^= x;

        // get rightmost set bit (where two numbers differ)
        int diffBit = xor & -xor;

        int a = 0, b = 0;

        // divide numbers into two groups
        for (int x : arr) {

            if ((x & diffBit) == 0)
                a ^= x;
            else
                b ^= x;
        }

        return new int[]{a, b};
    }

    // -------------------------------------------------
    // COUNT SUBARRAYS WITH XOR = K (IMPORTANT!)
    // Uses prefix XOR + HashMap
    // TC: O(n)
    // -------------------------------------------------
    static int countSubarraysWithXorK(int[] arr, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int prefXor = 0;
        int count = 0;

        map.put(0, 1);  // base case

        for (int x : arr) {

            prefXor ^= x;

            // if prefXor ^ k existed before -> valid subarray found
            int need = prefXor ^ k;

            count += map.getOrDefault(need, 0);

            map.put(prefXor, map.getOrDefault(prefXor, 0) + 1);
        }

        return count;
    }

    // -------------------------------------------------
    // CHECK IF XOR OF ARRAY IS ZERO
    // TC: O(n)
    // -------------------------------------------------
    static boolean isXorZero(int[] arr) {

        int xor = 0;
        for (int x : arr) xor ^= x;

        return xor == 0;
    }

    public static void main(String[] args) {

        int[] arr = {3, 8, 2, 6, 4};

        // Build prefix XOR
        int[] pref = buildPrefixXor(arr);

        // Range XOR
        System.out.println(rangeXor(pref, 1, 3));

        // Fast math range XOR
        System.out.println(xorRangeFast(3, 9));

        // Single number
        int[] a1 = {2, 3, 5, 2, 3};
        System.out.println(findSingle(a1));

        // Two single numbers
        int[] a2 = {1, 2, 3, 2, 1, 4};
        System.out.println(Arrays.toString(findTwoSingles(a2)));

        // Count subarrays with XOR = K
        int[] a3 = {4, 2, 2, 6, 4};
        System.out.println(countSubarraysWithXorK(a3, 6));
    }
}



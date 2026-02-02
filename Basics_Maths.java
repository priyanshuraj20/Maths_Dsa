import java.util.*;

public class Basics_Maths {

    // -------------------------------------------------
    // DIGIT EXTRACTION
    // TC: O(log10 N) → number of digits
    // -------------------------------------------------
    private static void extraction(int n) {
        while (n > 0) {
            int lastDigit = n % 10;   // get last digit
            System.out.print(lastDigit + " ");
            n /= 10;                 // remove last digit
        }
        System.out.println();
    }

    // -------------------------------------------------
    // ARMSTRONG NUMBER (3 digit based)://Armstrong strong:Taking cube of each and sum up its the number its self than its armstromng num
    // TC: O(log N)
    // -------------------------------------------------
    private static boolean armstrong(int n) {
        int original = n;
        int sum = 0;

        while (n > 0) {
            int d = n % 10;
            sum += d * d * d;
            n /= 10;
        }
        return sum == original;
    }

    // -------------------------------------------------
    // PRINT ALL DIVISORS
    // TC: O(√N)
    // -------------------------------------------------
    private static void divisors(int n) {
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                System.out.println(i);

                // avoid duplicate when i*i == n(// eliminating the case where same happens i.e Math.sqrt(n))
                if (n / i != i)
                    System.out.println(n / i);
            }
        }//you can use list add all element sort and than print for correct sequence
    }

    // -------------------------------------------------
    // PRIME CHECK (Optimal)://check for prime: Number which has exactly two factors i.e: 1 and number itself   (sqrt method)
    // TC: O(√N)
    // -------------------------------------------------
    private static boolean isPrime(int n) {
        if (n <= 1) return false;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    // -------------------------------------------------
    // SIEVE OF ERATOSTHENES (print primes till N)
    // TC: O(N log log N)
    // -------------------------------------------------
    private static void sieve(int n) {

        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);

        prime[0] = prime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (prime[i])
                System.out.print(i + " ");
        }
        System.out.println();
    }

    // -------------------------------------------------
    // GCD BRUTE FORCE
    // TC: O(min(a,b))
    // -------------------------------------------------
    private static int gcdBrute(int a, int b) {

        for (int i = Math.min(a, b); i >= 1; i--) {
            if (a % i == 0 && b % i == 0)
                return i;
        }
        return 1;
    }

    // -------------------------------------------------
    // EUCLIDEAN GCD (BEST)
    // TC: O(log min(a,b))
    // -------------------------------------------------
    private static int gcdEuclid(int a, int b) {

        while (b != 0) {
            int rem = a % b;
            a = b;
            b = rem;
        }
        return a;
    }

    // -------------------------------------------------
    // PRIME FACTORIZATION://print prime factors of a number: a number which is divisor and prime among them :  Tc:it will approximate as inside primecheck is not always = approx O(root n * 2 * root)
    // TC: O(√N)
    // -------------------------------------------------
    private static void primeFactors(int n) {

        for (int i = 2; i * i <= n; i++) {

            while (n % i == 0) {
                System.out.print(i + " ");
                n /= i;
            }
        }

        // remaining prime > √n
        if (n > 1)
            System.out.print(n);

        System.out.println();
    }

    // -------------------------------------------------
    // POWER OF TWO CHECK (BEST BIT TRICK)
    // TC: O(1)
    // -------------------------------------------------
    //Given number is power of two or not :  using count of setbits :if count of setbit == 1 than it is a power of 2 else not    
     private static boolean isPowOF2(int n){   // TC: O(log n ) 
          if (n <= 0)
            return false;
        int count =0;
        while(n > 0){
            if((n&1) == 1){
                count++;
            }
            n = n>>1;
        }
        if(count == 1) return true;
        return false;
     } 
     //using AND operator : TC O(1);
     private static boolean isPower2(int n){
           return (n > 0) && ((n & (n - 1)) == 0);
     }

    // -------------------------------------------------
    // LARGEST POWER OF 2 ≤ N:// n se chhota (or equal) sabse bada power of 2 nikalna:
    // TC: O(1)
    // -------------------------------------------------
    private static int largestPowerOf2(int n) {

        return Integer.highestOneBit(n);
    }

    // -------------------------------------------------
    // NEXT POWER OF 2 ≥ N (IMPORTANT!)
    // TC: O(1)
    // -------------------------------------------------
    private static int nextPowerOf2(int n) {

        if (n <= 1) return 1;

        return Integer.highestOneBit(n - 1) << 1;
    }

    // -------------------------------------------------
    // COUNT SET BITS
    // TC: O(1)
    // -------------------------------------------------
    private static int countSetBits(int n) {

        return Integer.bitCount(n);
    }

    // -------------------------------------------------
    // LCM USING GCD
    // TC: O(log n)
    // -------------------------------------------------
    private static int lcm(int a, int b) {

        return (a / gcdEuclid(a, b)) * b;
    }




    public static void main(String[] args) {

        extraction(5999);

        System.out.println(armstrong(371));

        divisors(45);

        System.out.println(isPrime(23));

        sieve(50);

        System.out.println(gcdBrute(12, 20));
        System.out.println(gcdEuclid(12, 20));

        primeFactors(84);

        System.out.println(isPowOF2(16));

        System.out.println(largestPowerOf2(20));

        System.out.println(nextPowerOf2(20));

        System.out.println(countSetBits(29));

        System.out.println(lcm(12, 20));
    }
}

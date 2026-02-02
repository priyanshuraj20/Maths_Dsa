import java.util.*;
public class Basics_Maths{

    //extraction of digits: Tc : O(log 10 (N)) 
    private static  void extraction(int n){
        while(n > 0){
            int last = n % 10;
            System.out.print(last);
            n/=10;
        }  
    }
    //Armstrong strong:Taking cube of each and sum up its the number its self than its armstromng num
    private static boolean Armstrong(int n){
        int N = n;
        int sum =0;
        while(n > 0){
            int lastDigit = n % 10;
            sum = sum + (lastDigit * lastDigit * lastDigit);
            n/=10;
        }
        return sum == N;
    }

    //Print all divisors:
    private static void divisors(int n){
        for(int i =1; i <= Math.sqrt(n); i++){
            if(n%i ==0){
                System.out.println(i);
                // eliminating the case where same happens i.e Math.sqrt(n)
                if(n/i != i){
                    System.out.println(n/i);
                }
            }//you can use list add all element sort and than print for correct sequence
        }
    }
    //check for prime: Number which has exactly two factors i.e: 1 and number itself   (sqrt method)
     private static boolean isPrime(int n){
        int count =0;
        for(int i = 1; i * i < n; i++){
            if(n%i == 0){
                count++;
                if(n/i != i) count++;
            }
        }
        return count==2? true:false;
     }
     //GCD\\HCF: O(min(a,b))
     private static void gcd1(int a,int b){
        for(int i = Math.min(a,b); i > 0; i++){
        if(a % i==0 && b % i ==0){
            System.out.print(i);
            break;
        }
        }
     }
     //gcd : using euclidean algo.: greater%smaller->go till one of the zero than other is gcd T.C->> O(log fie(min(a,b)));
     private static int gcd2(int a, int b){
        while(a>0 && b >0){
            if(a>b){
                a = a % b;
            }else{
                b = b % a;
            }
        }
        return a==0? b:a;
     }
     //print prime factors of a number: a number which is divisor and prime among them :  Tc:it will approximate as inside primecheck is not always = approx O(root n * 2 * root)
     private static void printPrime(int n){
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= Math.sqrt(n); i++){
            if(n%i == 0){
                if(isPrime(i)){
                    list.add(i);
                }
                if(n/i != i) {
                    if(isPrime(n/i)){
                    list.add(n/i);
                    }
                }
            }
        }
     }
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
    public static void main(String[] args){
        extraction(5999 );
        System.out.println(Armstrong(351));
        divisors(45);
        isPrime(23);
        gcd1(12,20);
        gcd2(5, 8);
        isPowOF2(8);
        isPower2(16);
    }
}
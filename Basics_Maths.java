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
    //check for prime: Number which has exactly two factors i.e: 1 and number itself
    

    public static void main(String[] args){
        extraction(5999 );
        System.out.println(Armstrong(351));
        divisors(45);
    }
}
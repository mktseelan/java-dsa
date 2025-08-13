import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MathsConcepts {

    public static void main(String[] args) {
        //find all prime numbers in the range of 1 to 40;
        //using seive
        int n = 40;
         boolean[] primes = new boolean[n + 1];
         seive(n , primes);

         //find the sqaure root of a number upto 2 decimal places.
        double sqrt = squareRoot(n , 2);
        System.out.println( " squareRoot of " + n +" =" + sqrt );

        //factors O(sqrt(N)) complexity;
        factors(36);

    }

    private static void seive(int n , boolean[] primes){
        if(n <= 1 )
            return;

        for(int i = 2 ; i*i <= n ;i++){

            if(primes[i] == false){

                for(int j = i*2 ;j <= n ; j = j + i) {
                    if (primes[j] == false)
                        primes[j] = true;
                }
            }
        }
        for(int i=2;i<n;i++){
            if(primes[i] == false)
                System.out.print(i + " ");
        }
    }

    public static double squareRoot(int n , int precision){
        int start = 1 , end = n;
        double root = 0.0;

        while(start <= end){
            int mid = start + (end - start)/2;

            if(mid * mid == n) {
                return mid;
            }

            if( mid * mid > n)
                     end = mid - 1;
            else
                start = mid + 1;
        }

        root = start -1;
        double inc = 0.1;

        for(int i = 0;i< precision ;i++){

            while( root * root <= n){
                root = root + inc;
            }

            root-= inc;
            inc = inc/10;
        }

        return root;
    }

    public static void factors(int n){

        for(int i = 1 ;i<=Math.sqrt(n);i++){
            if(n % i == 0){
                if(n/i == i){
                    System.out.println(i);
                }
                else {
                    System.out.println(i);
                    System.out.println(n/i);
                }
            }
        }
    }
}

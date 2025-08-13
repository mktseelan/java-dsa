public class Recursion {
    public static void main(String[] args) {
        //Print message 5 times;
        message(5);

        //print first 5 numbers;
        printNumbersRev(5);

        //fibonacci
        System.out.println(fib(10));

        //print 5,4,3,2,1,1,2,3,4,5
        printAll(5);
        System.out.println();
        //Factorial of a number
        System.out.println(factorial(6 ));

        //sum of all digits of a number
        System.out.println( "Sum of all Digits :" + sumOfAllDigits(12345));

        //reverse a number
        System.out.println(reverseNumber(98765 ));

        //count zeroes in a number;
        System.out.println( countZeroes(890087) ) ;
    }
     public static int countZeroes(int n){
        return helperCount (n , 0);

     }
     public static int helperCount(int n , int count){
        if( n == 0 )
            return count;
        if(n % 10 == 0)
            return helperCount(n/10 , count + 1);
        else
            return helperCount(n/10 , count);
     }

    public static int reverseNumber(int n ){
        if( n % 10 == n )
            return n;

        int digits = (int) (Math.log10( n)) + 1;
         return Helper(n , digits);
    }
    public static int Helper(int n , int digits){
        if(n==0)
            return 0;
        return  ( (n % 10) * (int) (Math.pow(10,digits -1 )) ) + Helper(n/10 , digits - 1);
    }

    public static int sumOfAllDigits(int n){
        if(n == 0)
            return 0;

        return ( n % 10 ) + sumOfAllDigits(n/10);
    }
    public static int factorial(int n){
        if(n == 1)
            return 1;

        return factorial(n-1) * n;
    }
    public static void printNumbersRev(int n ){
        if(n == 0)
            return;
        printNumbersRev(n-1);
        System.out.println(n);

    }
    public static void printAll(int n){
        if(n==0)
            return;
        System.out.print(n);
        printAll(n-1);
        System.out.print(n);

    }
    public static void message(int n){
        if(n==0)
            return;

        System.out.println("Hello world");
        message(n-1);

    }

    public static int fib(int n){
        if(n<2)
            return n;
        else
            return fib(n-1) + fib(n-2);
    }
}

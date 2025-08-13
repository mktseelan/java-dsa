import java.sql.SQLOutput;

public class BitwiseOperators {

    public static void main(String[] args) {
        int a = 10 , b = 51;

        System.out.println( a << 1); //left shift // multiplies by 2;
        System.out.println(b >> 1); //right shift // divides by 2;

        String[] arr = new String[]{"Even" , "Odd"};

        System.out.println(arr[b & 1]); // & operator to find if an number os odd or even

        findOnceRepeatingNumber(new int[]{1,2,3,4,6,1,2,3,4,6,99});

        ithBitOfaNumber(64 , 6);

        //ith bit using Mash
        int n = 32;
        System.out.println(n & (1 << (6)));

        //the magic number
        magicNumber(10);

        calculatePower(5,3);

        setbits(200);
    }
    public static void findOnceRepeatingNumber(int[] arr){
        //use XOR property
        int res = 0;

        for(int num : arr){
            res = res ^ num;
        }

        System.out.printf( "the only once repeating number is %d" , res);
        System.out.println();


    }
    public static void ithBitOfaNumber(int n , int ithBit){
        if(ithBit == 0)
            System.out.println(n & 1);

        n = n>>ithBit;

        System.out.println(n & 1);

    }

    public static void magicNumber(int n ){

        int base = 5 , res = 0;

        while( n > 0 ){

            int lsb = n & 1;
            res += base * lsb;
            n = n>>1;
            base*=5;

        }

        System.out.printf( "the magic number is : %d" , res);
        System.out.println();

    }

    public static void calculatePower(int a , int b){ // a raised to power b
        //normal computation using loop takes O(b) complexity , it can be computed using order of log(b)
        //complexity by comnverting b into binary value and for every set bit (multiplying res with the multiplier)
        int mult = a, res = 1 , pow = b;

        while(b > 0){
            int lsb = b & 1 ;
            if(lsb == 1) {
                res *= (lsb * mult);
            }
            b = b >> 1;
            mult = mult * mult;
        }

        System.out.printf("%d raised to power %d is %d" , a , pow , res );
        System.out.println();
    }

    public static void setbits(int n){
        System.out.println(Integer.toBinaryString(n));
        int count = 0;

        while(n > 0){
            count++;
             n = n & (n-1);
        }

        System.out.println(count);
    }

}

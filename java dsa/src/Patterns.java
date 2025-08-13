public class Patterns {
    public static void main(String[] args) {
        int n =4;
        pattern1(n);
        System.out.println();
        pattern2(5);
        System.out.println();
        pattern3(5);
        System.out.println();
        pattern4(5);
        System.out.println();
        pattern5(5);
        System.out.println();
        pattern6(5);
        System.out.println();
        pattern7(5);
        System.out.println();
        pattern8(5);
        System.out.println();
        pattern9(5);
        System.out.println();
        pattern10(4);

    }
    public static void pattern1(int n){

        for(int i = 0;i<n;i++){
            for(int j = 0 ; j<=i ;j++){
                System.out.print('*');
            }
            System.out.println();
        }
    }
    public static void pattern2(int n){

        for(int i = 0;i<n;i++){
            for(int j = 0 ; j<n ;j++){
                System.out.print('*');
            }
            System.out.println();
        }
    }
    public static void pattern3(int n){

        for(int i = 0;i<n;i++){
            for(int j = 0 ; j<n-i ;j++){
                System.out.print('*');
            }
            System.out.println();
        }
    }
    public static void pattern4(int n){

        for(int i = 1;i<=n;i++){
            for(int j = 1 ; j<=i ;j++){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
    public static void pattern5(int n){

        for(int row = 0;row< (2*n);row++) {
            int totalCol = row < n ? row : n -( row - n ) ;

                for (int col = 0; col < totalCol; col++) {
                    System.out.print("*");
                }
            System.out.println();
        }
    }

    public static void pattern6(int n){

        for(int row = 0;row<n;row++){
            for(int col = 0;col <n-row-1;col++){
                System.out.print(' ');
            }
            for(int col =0 ;col<=row;col++){
                System.out.print('*');
            }
            System.out.println();
        }

    }

    public static void pattern7(int n){

        for(int row = 0; row<(2*n); row++){
            int totalCol = row<n? row : (2*n) -row ;
            int totalSpaces = n - totalCol;

            for(int col = 0;col< totalSpaces;col++)
                System.out.print(" ");

            for(int col =0 ;col<totalCol;col++){
                System.out.print("* ");
            }
            System.out.println();
        }

    }

    public static void pattern8(int n){

        for(int row = 1; row <= n ; row++){
            for(int col = 1;col <= n - row;col++){
                System.out.print(" ");
            }
            for(int col = row ;col >= 1; col --){
                System.out.print(col);
            }
            for(int col = 2;col <= row; col ++){
                System.out.print(col);
            }

            System.out.println();
        }
    }

    public static void pattern9(int n){

        for(int row = 1 ;row <= (2*n)+1 ;row++ ){

            int totalCol = row <= n ? row : n -( row - n);
            int spaces = n-totalCol;

            for(int col = 1;col<=spaces;col++){
                System.out.print(" ");
            }
            for(int col = totalCol;col>=1 ;col--){
                System.out.print(col);
            }
            for(int col = 2 ; col <=totalCol;col++){
                System.out.print(col);
            }

            System.out.println();
        }
    }

    public static void pattern10(int n){
        int OriginalN = n+1;
        n = 2*n;
        for(int row = 1 ; row <n ; row++){
            for(int col = 1 ;col < n ;col ++){
                int atEveryIndex = OriginalN -  Math.min(Math.min(col , row) , Math.min(n - col , n-row));
                System.out.print(atEveryIndex + " ");
            }
            System.out.println();
        }
    }
}

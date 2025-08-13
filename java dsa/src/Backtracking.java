import java.util.Arrays;

public class Backtracking {
    public static void main(String[] args) {
        //n - queens
        int n = 4;
        boolean[][] board = new boolean[n][n];
        int res = nQueens(board  , 0);
        System.out.println(res);

    }
    public static int nQueens(boolean[][] board , int row){
        if(row == board.length){
            display(board);
            return 1;
        }

        int count = 0;
        //for placing queens
        for(int col = 0 ; col < board[0].length ; col ++) {
            //check whether queen can be placed
            if(isSafeToPlace(board , row , col)){
                board[row][col] = true;
                count += nQueens(board , row +1);
                board[row][col] = false;
            }
        }

        return count;
    }
     public static boolean isSafeToPlace(boolean[][] board , int row , int col){

        for(int i = 0  ; i <row ; i ++ ){
            if(board[i][col])
                return false;
        }

        int leftDiagonal = Math.min(row , col);
        for(int i = 1 ; i <= leftDiagonal ;i++){
            if(board[row - i][col - i])
                return false;
        }

        int rightDiagonal = Math.min(row , board.length - col -1);
        for(int i= 1; i<= rightDiagonal;i++){
            if(board[row-i][col + i])
                return false;
        }

        return true;
     }

    public static void display( boolean[][] board){
        for(boolean[] arr : board){
            for(boolean element : arr){
                if(element)
                    System.out.print("Q ");
                else
                    System.out.print("X ");
            }
            System.out.println();
        }

        System.out.println();

    }

}

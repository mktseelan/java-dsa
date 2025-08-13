public class NKnights {
    public static void main(String[] args) {
        //place n-knights in a nxn board.
        int n = 4;
        boolean[][] board = new boolean[n][n];
        System.out.println(NKnights(board ,  0 , 0 ,n ));
    }
    public static int NKnights(boolean[][] board , int row ,int col , int knights){
        if(knights == 0){
            display(board);
            return 1;
        }
        int count = 0;
        if(row == board.length -1 && col == board[0].length ){
            return count;
        }

        if(col == board[0].length ){
            count += NKnights(board , row+1,0 , knights);
            return count ;
        }

        if(isSafeToPlace(board , row , col)){
            board[row][col] = true;
            count += NKnights(board , row , col + 1 , knights - 1);
            board[row][col] = false;
        }

        count += NKnights(board , row , col +1 , knights);

        return count;
    }
    public static boolean isSafeToPlace(boolean[][] board , int row, int col){

        if(isValid(board , row-2,col-1) && board[row-2][col - 1] )
            return false;
        if( isValid(board , row-2,col + 1) && board[row-2][col + 1] )
            return false;
        if(isValid(board , row -1,col + 2) && board[row-1][col+2] )
            return false;
        if(isValid(board , row- 1,col - 2) && board[row-1][col -2] )
            return false;

        return true;
    }

    public static boolean isValid(boolean[][] board , int row ,int col){

        if(row >= 0 && row< board.length && col >=0 && col < board[0].length){
            return true;
        }
            return false;
    }

    public static void display(boolean[][] board){
        for(boolean[] row : board){
            for(boolean val : row){
                if(val){
                    System.out.print("K ");
                }
                else
                    System.out.print("X ");
            }
            System.out.println();
        }
        System.out.println();

    }

}

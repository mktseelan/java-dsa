public class SodokuSolver {
    public static void main(String[] args) {
        int[][] board = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},

                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},

                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        if (sodokuSolver(board)) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static boolean sodokuSolver(int[][] board) {

        int n = board.length;
        int row = -1, col = -1;
        boolean isSodukoSolved = true;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    isSodukoSolved = false;
                    break;
                }
            }
            if (! isSodukoSolved)
                break;
        }
        if (isSodukoSolved) {
            return true;
        }

        for (int i = 1; i <= 9; i++) {
            if (isSafeToPlace(board, row, col, i)) {
                board[row][col] = i;
                if (sodokuSolver(board)) {
                    return true;
                } else
                    board[row][col] = 0;
            }
        }

        return false;
    }

    public static boolean isSafeToPlace(int[][] board, int row, int col, int num) {

        //check row
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }

        //check col
        for (int i = 0; i < board[0].length; i++) {
            if (board[i][col] == num)
                return false;
        }

        int sqrt = (int) (Math.sqrt(board.length));
        int rowStart = (row / sqrt) * sqrt;
        int colStart = (col / sqrt) * sqrt;

        for (int i = rowStart; i < rowStart + sqrt; i++) {
            for (int j = colStart; j < colStart + sqrt; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}

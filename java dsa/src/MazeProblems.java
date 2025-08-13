import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MazeProblems {
    public static void main(String[] args) {
        //consider here target is (3,3)
        //gona print number of ways we can reach the target from (0,0)
        //can move only down or right direction
        int ans = mazePathsCount(0 , 0);
        System.out.println(ans);

        //we are gona print the path
        List<String> res = mazePaths("" , 0 , 0 );
        System.out.println(res);

        //now we can move diagonally also target 2,2
        ans = mazeDiagonal( 0 ,0);
        System.out.println(ans);

        //print paths
        res = mazePathsDiagonal("" , 0 , 0);
        System.out.println(res);

        //with obstacle // place an obstacle at (1,1)
        //consider the position (2,2) as target
        boolean[][] mat = new boolean[][]{
                {true , true ,true},
                {true , false , true},
                {true , true , true}
                };
        res = mazeWithDiagonal("" , 0 , 0 , mat);
        System.out.println(res);

        boolean[][] vis = new boolean[3][3];
        mazeBacktracking("" , 0 , 0, vis);
        System.out.println();

        int[][] path = new int[3][3];
        mazeBacktrackingPathPrint("", 0,0,vis,1,path);
    }

    public static void mazeBacktrackingPathPrint(String ans , int r , int c , boolean[][] vis , int level , int[][] path){

        if(vis[r][c])
            return;

        if(r == vis.length -1 && c == vis[0].length -1 ){
            path[r][c] = level ;
            for(int i = 0;i < path.length ;i++){
                System.out.println(Arrays.toString(path[i]));
            }
            System.out.println(ans);
            System.out.println();
            path[r][c] = 0;
            return;
        }

        path[r][c] = level;
        vis[r][c] = true;

        if(r < vis.length - 1){
            mazeBacktrackingPathPrint(ans + 'D' , r+1 , c , vis , level+1 , path);
        }
        if(c < vis[0].length -1 ){
            mazeBacktrackingPathPrint(ans + 'R' , r , c +1 , vis , level+1 , path);
        }
        if(r > 0){
            mazeBacktrackingPathPrint(ans + 'U' , r - 1 , c  , vis , level+1 , path);
        }
        if(c > 0 ){
            mazeBacktrackingPathPrint(ans + 'L' , r , c-1 , vis , level+1 , path);
        }

        path[r][c] = 0;
        vis[r][c] = false;
    }

    public static void mazeBacktracking(String ans , int r , int c , boolean[][] vis){
        
        if(vis[r][c])
            return;

        if(r == vis.length -1 && c == vis[0].length -1 ){
            System.out.println(ans);
            return;
        }
         vis[r][c] = true;

        if(r < vis.length - 1){
            mazeBacktracking(ans + 'D' , r+1 , c , vis);
        }
        if(c < vis[0].length -1 ){
            mazeBacktracking(ans + 'R' , r , c +1 , vis);
        }
        if(r > 0){
            mazeBacktracking(ans + 'U' , r - 1 , c  , vis);
        }
        if(c > 0 ){
            mazeBacktracking(ans + 'L' , r , c-1 , vis);
        }

        vis[r][c] = false;
    }
    public static List<String> mazeWithDiagonal(String ans , int r , int c , boolean[][] maze){
        List<String> res = new ArrayList<>();
        if(! maze[r][c]){
            return res;
        }
        if(r == maze.length -1 && c == maze[0].length -1){
            res.add(ans);
            return res;
        }
        if(r < maze.length - 1){
            res.addAll(mazeWithDiagonal(ans + "D" , r+1, c , maze));
        }
        if(c < maze[0].length - 1){
            res.addAll(mazeWithDiagonal(ans + "R" , r, c+1 , maze));
        }

        return res;

    }
    public static List<String> mazePathsDiagonal(String ans ,  int r, int c){
        List<String > res = new ArrayList<>();

        if(r == 2 && c == 2){
            res.add(ans);
            return res;
        }
        if( r < 2 && c < 2){
            res.addAll(mazePathsDiagonal( ans + "D",r+1 , c+1 ));
        }
        if( r < 2){
            res.addAll(mazePathsDiagonal( ans + "V",r+1 , c ));
        }
        if( c < 2){
            res.addAll(mazePathsDiagonal(ans + "H",r , c+1 ));
        }

        return res;
    }



    public static int mazeDiagonal( int r, int c){

        if(r == 2 && c == 2){
            return 1;
        }
        int count = 0 ;
        if( r < 2 && c < 2){
            count+= mazeDiagonal(r+1 , c+1 );
        }
        if( r < 2){
            count+= mazeDiagonal(r+1 , c );
        }
        if( c < 2){
            count+= mazeDiagonal(r , c+1 );
        }

        return count;
    }



    public static int mazePathsCount(int r , int c){
        if(r == 3 || c == 3){
            return 1;
        }
        int down = mazePathsCount(r+1 , c);
        int right = mazePathsCount(r, c+1);

        return right + down;
    }

    public static List<String> mazePaths(String ans , int r ,int c){
        List<String> temp = new ArrayList<>();

        if(r == 2 && c == 2 ){
            temp.add(ans);
            return temp;
        }
        if(r < 2)
             temp.addAll(mazePaths(ans + "D" , r+1 , c));

        if(c < 2)
            temp.addAll(mazePaths(ans + "R" , r , c + 1));

        return temp;
    }
}

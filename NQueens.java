import java.util.ArrayList;
import java.util.List;

//TC will be O(n^2), where n is the size of chessboard
//SC will be O(n! * n^2), where n is the size of chessboard
class NQueens {
    List<List<String>> result;
    boolean[][] grid;
    public List<List<String>> solveNQueens(int n){
        if(n == 0){
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        grid = new boolean[n][n];
        backtrack(0);
        return result;
    }

    private void backtrack(int row){
        //base case
        if(row == grid.length){
            List<String> answer = new ArrayList<>();
            for(int i =0; i<grid.length; i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j< grid.length; j++){
                    if(grid[i][j] == true){
                        sb.append('Q');
                    }
                    else
                    {
                        sb.append('.');
                    }
                }
                answer.add(sb.toString());
            }
            result.add(answer);
            return;
        }

        //logic
        for(int i =0; i < grid.length; i++){
            if(isSafe(row, i)){
                //action
                grid[row][i] = true;
                //recurse
                backtrack(row + 1);
                //backtrack
                grid[row][i] = false;
            }
        }
    }


    private boolean isSafe(int row, int col){
        //check if the queen will be attacked by a queen above it
        for(int i = row; i >= 0; i--){
            if(grid[i][col] == true){
                return false;
            }
        }

        //check the upper left diagonal for queen attack
        int i = row;
        int j = col;
        while(i >= 0 && j >=0){
            if(grid[i][j] == true){
                return false;
            }
            i--;
            j--;
        }
        //check the upper right diagonal for queen attack
        i = row;
        j = col;
        while(i >= 0 && j<grid.length){
            if(grid[i][j]==true){
                return false;
            }
            i--;
            j++;
        }
        return true;
    }

    public static void main(String[] args){
        NQueens obj = new NQueens();
        int n = 4;
        System.out.println(obj.solveNQueens(n));
    }
}
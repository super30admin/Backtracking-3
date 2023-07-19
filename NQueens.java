import java.util.ArrayList;
import java.util.List;

public class NQueens {
    //Time complexity: O(N^2 + fact(N))
    //Space complexity: O(N^2)
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {

        result = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        backtrack(0, board, n);

        return result;
    }

    private void backtrack(int index, boolean[][] board, int n){
        if(index == n){
            List<String> current = new ArrayList<>();
            for(int i = 0; i< board.length; i++){
                StringBuilder str = new StringBuilder();
                for(int j = 0; j< board[0].length; j++){
                    str.append(board[i][j] == true? "Q":".");
                }
                current.add(str.toString());
            }
            result.add(current);
            return;
        }

        for(int j = 0; j < n; j++){
            if(isSafe(index,j, board)){
                board[index][j] = true;
                backtrack(index+1, board, n);
                board[index][j] = false;
            }
        }

    }

    private boolean isSafe(int r, int c, boolean[][] board){

        for(int i = 0; i < r; i++ ){
            if(board[i][c]) return false;
        }
        int i=r;
        int j = c;

        while(i >=0 && j >=0){
            if(board[i][j]) return false;
            i--; j--;
        }

        i=r;
        j = c;

        while(i >=0 && j < board[0].length){
            if(board[i][j]) return false;
            i--; j++;
        }

        return true;



    }
}

// Time Complexity: O(n!)
// Space Complexity: O(n^2)


import java.util.ArrayList;
import java.util.List;

class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        boolean[][] board = new boolean[n][n];

        backtrack(board, 0, result);
        return result;
    }

    private void backtrack(boolean[][] board, int r, List<List<String>> result){
        // base
        if(r == board.length){
            List<String> li = new ArrayList<>();
            for(int i = 0; i < board.length; i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < board[0].length; j++){

                    if(board[i][j]){
                        sb.append("Q");
                    }else{
                        sb.append(".");
                    }
                }
                li.add(sb.toString());
            }
            result.add(li);
        }

        // logic
        for(int c = 0; c < board[0].length; c++){
            if(isSafe(board, r, c)){
                board[r][c] = true;
                backtrack(board, r+1, result);
                board[r][c] = false;
            }
        }
    }

    private boolean isSafe(boolean[][] board, int r, int c){
        // columns up
        for(int i = 0; i < r; i++){
            if(board[i][c]){
                return false;
            }
        }


        // diagonal right
        int i = r, j = c;
        while(i >= 0 && j < board[0].length){
            if(board[i][j]){
                return false;
            }
            i--;
            j++;
        }

        // diagonal left
        i = r;
        j = c;
        while(i >= 0 && j >= 0){
            if(board[i][j]){
                return false;
            }
            i--;
            j--;
        }
        return true;

    }
}

//for loop based recursion
// start with row=0, col=0. Go one by one row. 
// Backtrack. Then move to next column.
// Time Complexity = O(n^n) or n factorial
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        boolean [][] board = new boolean[n][n];
        backtrack(board, 0, result);
        return result;
    }
    private void backtrack(boolean [][]board, int r, List<List<String>> result){
        //base
        if(r == board.length){
            List<String> li = new ArrayList<>();
            for(int i=0; i<board.length; i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<board.length; j++){
                    if(board[i][j]){
                        sb.append('Q');
                    } else{
                        sb.append('.');
                    }
                }
                li.add(sb.toString());
            }
            result.add(li);
            return;
        }

        //logic
        for(int c=0; c<board.length; c++){
            if(isSafe(board,r,c)){
                //action
                board[r][c]=true;
                //recurse
                backtrack(board, r+1, result);
                //backtrack
                board[r][c]=false;
            }
        }
    }
    private boolean isSafe(boolean [][]board,int r, int c){
        int n = board.length;
        //column up
        for(int i=0; i<r; i++){
            if(board[i][c]) return false;
        }
        //up left diagonal
        int i=r; int j=c;
        while(i >= 0 && j>=0){
            if(board[i][j]) return false;
            i--;
            j--;
        }
        //up right diagonal
        i = r; j=c;
        while(i>=0 && j<n){
            if(board[i][j]) return false;
            i--;
            j++;
        }
        return true;
    }
}

//Time Complexity: O(N!)
//Space Complexity: O(N^2) without result, O(K*N^2)

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        boolean [][] board = new boolean[n][n];
        backtrack(board, n, 0, result);
        return result;
    }

    

    private void backtrack(boolean[][] board, int n, int r, List<List<String>> result){
            //base
            if(r == n){
                List<String> lis = new ArrayList<>();
                for(int i=0; i< n; i++){
                    StringBuilder sb = new StringBuilder();
                    for(int j=0; j< n; j++){
                        if(board[i][j]){
                            sb.append('Q');
                        }
                        else{
                            sb.append(".");
                        }
                    }
                    lis.add(sb.toString());
                }
                result.add(lis);
                return;
            }

            //logic
            for(int c=0; c<n; c++){
                if(isSafe(board, r, c)){
                    //action
                    board[r][c] = true;
                    //recurse
                    backtrack(board, n, r+1, result);
                    //backtrack
                    board[r][c] = false;
                }
         }
    }

    private boolean isSafe(boolean[][] board, int r, int c){
            //column up
            for(int i = 0; i< r; i++){
                if(board[i][c]){
                    return false;
                }
            }

            //up left diagonal
            int i=r; int j=c;
            while(i >=0 && j >=0){
                if(board[i][j])
                    return false;
                i--;
                j--;
            }

            //up right diagonal
            i=r; j=c;
            while(i >=0 && j<board.length){
                if(board[i][j])
                    return false;
                i--;
                j++;
            }
        return true;
    }
}
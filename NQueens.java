class Solution {
	//Time Complexity: O(N!)
	//Space Complexity: O(N^2)
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        boolean[][]  board= new boolean[n][n];
        recurse (n , board, 0);
       return res; 
    }

    private void recurse (int n, boolean[][] board, int level){
        // base case
        if (n == level){
            res.add (printBoard(board));
            return;
        }
        //logic
        for (int i =0; i < board.length;i++){
           if (isValid(board,level,i)){
            board[level][i] = true;
            recurse (n,board, level+1);
            board[level][i] = false;
           } 
        }
    }
    private boolean isValid(boolean[][] board, int n, int m){
            for (int i =n-1; i >= 0;i--){
                    if(board[i][m] == true)
                    return false;
            }
            int i = n-1, j = m-1;
            while (i >=0 && j >= 0){
                if (board[i][j] ==true)
                return false;
                i--;
                j--;
            }
           i = n-1; j = m+1;
            while (i >=0 && j < board.length){
                if (board[i][j] ==true)
                return false;
                i--;
                j++;
            }
            return true;
    }

    private List<String> printBoard(boolean[][] board){
        List<String> ans = new ArrayList<>();

        for (int i = 0; i<board.length;i++ ){
            StringBuilder sb= new StringBuilder();
        for (int j = 0; j<board[0].length;j++ ){
            if (board[i][j] ==true){
                sb.append('Q');
            } else {
                sb.append('.');

        }
    }
    ans.add (sb.toString());
}
return ans;
}
}

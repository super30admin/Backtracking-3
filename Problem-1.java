class Solution {
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        
        helper(board,n,0);
        
        return result;
    }
    
    private void helper(boolean[][] board,int n,int r) {
        //base
        if(n == r) {
            List<String> str = new ArrayList<>();
            for(int i=0;i<board.length;i++) {
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<board[0].length;j++) {
                    if(board[i][j]) {
                        sb.append("Q");
                    }
                    else {
                        sb.append(".");
                    }
                }
                str.add(sb.toString());
            }
            result.add(new ArrayList(str));
            return; 
        }
        
        //logic
        for(int i=0;i<board[0].length;i++) {
            if(isSafe(board,r,i)) {
                //action
                board[r][i] = true;
                //recurssion
                helper(board,n,r+1);
                //bactrack
                board[r][i] = false;
            }
        }
    }
    
    private boolean isSafe(boolean[][] board, int row, int col) {
        for(int i=0;i<row;i++) {
            if(board[i][col] == true) {
                return false;
            }
        }
        int i=row;
        int j=col;
        while(i>=0 && j>=0) {
            if(board[i][j] == true) {
                return false;
            }
            i--;
            j--;
        }
        i = row;
        j = col;
        while(i>=0 && j<board[0].length) {
            if(board[i][j] == true) {
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
}
class Solution {
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        if(n==0) return res;
        boolean[][] board=new boolean[n][n];
        helper(0,board);
        return res;
    }
    private void helper(int i,boolean[][] board){
        if(i==board.length){
            List<String> li = new ArrayList<>();
            for(i=0;i<board.length;i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<board[0].length;j++){
                    if(board[i][j]){
                        sb.append("Q");
                    }
                    else sb.append(".");
                }
                li.add(sb.toString());
            }
            res.add(li);
            return;
        }

        for(int j=0;j<board[0].length;j++){
            if(isSafe(board,i,j)){
                board[i][j]=true;
                helper(i+1,board);
                board[i][j]=false;
            }
        }
    }
    private boolean isSafe(boolean[][] board, int r, int c){
        for(int i=0;i<r;i++){
            if(board[i][c]){
                return false;
            }
        }

        int i=r-1,j=c-1;
        while(i>=0 && j>=0){
            if(board[i][j]){
                return false;
            }
            i--;j--;
        }
        
        i=r-1;j=c+1;
        while(i>=0 && j<board[0].length){
            if(board[i][j]){
                return false;
            }
            i--;j++;
        }

        return true;
    }
}

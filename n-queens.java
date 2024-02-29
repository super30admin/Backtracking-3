// Time  Not sure
// Space O(mn)
class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        helper(0, board);
        return res;
    }

    public void helper(int i, boolean[][] board){
        //base
        if(i==board.length){
            List<String> s = new ArrayList<>();
            for(int k=0;k<board.length;k++){
                StringBuilder sb = new StringBuilder();
                for(int l=0;l<board[0].length;l++){
                    if(board[k][l]==true){
                        sb.append('Q');
                    }
                    else{
                        sb.append('.');
                    }
                }
                s.add(sb.toString());
            }
            res.add(s);
            return;
        }

        //logic
        for(int j=0;j<board[0].length;j++){
            if(validplace(board, i, j)){
                board[i][j]=true;
                helper(i+1,board);
                board[i][j]=false;
            }
        }
    }

    public boolean validplace(boolean[][] board, int i, int j){
        for(int k=0;k<=i;k++){
            if(board[k][j]==true){
                return false;
            }
        }
        int r = i;
        int c = j;
        while(r>=0 && c>=0){
            if(board[r][c]==true){
                return false;
            }
            r--;
            c--;
        }
        r = i;
        c = j;
        while(r>=0 && c<board[0].length){
            if(board[r][c]==true){
                return false;
            }
            r--;
            c++;
        }
        return true;
    }
}

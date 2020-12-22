/**
 * TC : O(N!) SC : O(N)
 * Approach : we can start form first column of each and every row, then check for all the possible places in the board till the current cell.
 *            finding each possible solution for the given board.   
 */
class Solution {
    List<List<String>> result = new ArrayList<>();
    int[][] board;
    int m;
    public List<List<String>> solveNQueens(int n) {
        m = n;
        board = new int[n][n];
        // board[0][0] = 0;          
        // System.out.println(board[2][3]);
        dfs(0,0);
        return result;
    }
    
    private void dfs(int r, int c){
        if(r == m){
            List<String> temp = new ArrayList<>();
            
            for(int i = 0; i < m; i++){
                StringBuilder s = new StringBuilder();
                for(int j = 0; j < m; j++){
                    if(board[i][j] == 1) {
                        s.append('Q');
                    } else{
                        s.append('.');
                    }
                }
                temp.add(s.toString());
            }
            result.add(temp);
        }
            for(int j = 0; j < m; j++){
                if(isSafe(r,j)){
                    board[r][j] = 1;                    
                    dfs(r+1,0);
                    board[r][j] = 0;
                }
            }

    }
    
    private boolean isSafe(int r, int c){
        if(r<0 || c< 0 || r > m || c > m) return false;
        
        for(int i = 0; i < r; i++){
            if(board[i][c] == 1)return false;
        }
        int i = r; int j = c;
        // System.out.println(board[2][3]);
        while(i>= 0 && j >= 0){
            // System.out.println(i+" "+j);
            if(board[i][j] == 1) return false;
            i--;j--;
        }
        i = r; j = c;
        while(i >= 0 && j < m){
            if(board[i][j] == 1) return false;
            i--;j++;
        }
        return true;        
    }
}
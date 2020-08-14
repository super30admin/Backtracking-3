//Time Complexity: O(N!)
//Space Complexity: O(N)

class Solution {
    int [][] board;
    List<List<String>> result;
    int m;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        m = n;
        board = new int[n][n];
        placeQueens(0);
        return result;
    } 
    
    private void placeQueens(int r){
        //base
        if(r==m){
            List<String> li = new ArrayList<>();
            for(int i=0; i< m; i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0; j< m; j++){
                    if(board[i][j] == 0){
                        sb.append('.');
                    }
                    else{
                        sb.append('Q');
                    }
                }
                li.add(sb.toString());
            }
            result.add(li);
        }
        
        //logic
        for(int i=0; i<m; i++){
            if(isSafe(r,i)){
                //action
                board[r][i] = 1;
                //recurse
                placeQueens(r+1);
                //backtrack
                board[r][i] = 0;
            }
        }
        
    }
    private boolean isSafe(int r, int c)
    {
        // checking for the coloumn
        for(int k=0; k<=r; k++)
        {
            if(board[k][c] == 1)
                return false;
        }
        
        // upper left diagonal;
        int i= r - 1;
        int j= c - 1;
        while(i>=0 && j >= 0){
            if(board[i][j] == 1)
                return false;
            i--; j--;
        }
        
        // upper right diagonal
        int a = r - 1;
        int b = c + 1;
        while(a>=0 && b< m){
            if(board[a][b] == 1)
                return false;
            a--;
            b++;
        }
        return true;
    }
}
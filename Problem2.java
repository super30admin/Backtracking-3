
//Time Complexity: O(N^N/2)
//Space Complexity: O(N)

class Solution {
    List<List<String>> results = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
         
        int[][] board = new int[n][n];
        backtrack(board,0,n);
        return results;
    }
    
    private boolean backtrack(int[][] board, int r,int n) {
        //base case
        if(r==n)
       {
           List<String> temp= new ArrayList<>();
           for(int i=0;i<n;i++)
           {
               String a =new String();
               for(int j=0;j<n;j++)
               {
                   if(board[i][j]==1)

                       a+='Q';
                   else
                       a+='.';
               }
               temp.add(a);
           }
           results.add(temp);
           return false;

       }
        
        for(int i = 0; i < n; i++) {
            if ( isSafe(board,r,i,n)) {
                board[r][i] = 1;
                if(backtrack(board,r+1,n))
                    return true;
                
            }
            board[r][i] = 0;
        }
        return false;
        
    }
    
    private boolean isSafe(int[][] board, int i, int j, int n) {
        
        //check column
        for(int r = 0; r < i;r++) {
            if(board[r][j] == 1)
                return false;
        }
        
        //check left diagonal
        int row = i -1;
        int column = j - 1;
        while(row >= 0 && column >= 0) {
            if(board[row][column] == 1) {
                return false;
            }
            row--;
            column--;
        }
        //check right diagonal
        row = i - 1;
        column = j + 1;
        while (row >= 0 && column < n)  {
            if(board[row][column] == 1) {
                return false;
            }
            row--;
            column++;
        }
        return true;
    }
}

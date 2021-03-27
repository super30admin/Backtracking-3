//TC: O(n!)
//SC: O(n)
//Executed on leetcode.
class Solution {
    List<List<String>> output = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        int[][] board = new int[n][n];        
        backtracking(board, 0, n);
        return output;
    }
    
    void backtracking(int[][] board, int r, int n)
    {
        if(n==0)
        {
            output.add(new ArrayList<>(addOutput(board)));		//Trying to insert Queen at every column and first row
            return;
        }
        for(int i=0;i<board.length;i++)		//Then checking where we can place queen at the rest of columns using dfs. 
        {
            if(isValid(board,r,i))			//If I can place queen I am changing my grid value to 1. once the rest of rows are checked 
            {								//I am replacing it back to 0. 
                board[r][i] = 1;		
                backtracking(board, r+1,n-1);	//Likewise doing the same to all other rows too.
                board[r][i] = 0;
            }
        }
    }
    
    List<String> addOutput(int[][] board)
    {
        List<String> boardSet = new ArrayList<>();
        for(int i=0;i<board.length;i++)
        {
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]!=1)
                    sb.append('.');
                else
                    sb.append('Q');
            }
            boardSet.add(sb.toString());
        }
        return boardSet;
    }
    
    boolean isValid(int[][] board,int i,int j)
    {
        int r = i;
        int c = j;
        while(r>=0)
        {
            if(board[r][c]==1)
                return false;
            r--;
        }
        r = i; c = j;
        while(r>=0 && c>=0)
        {
            if(board[r][c]==1)
                return false;
            r--;
            c--;
        }
        r = i; c = j;
        while(r>=0 && c<board[0].length)
        {
            if(board[r][c]==1)
                return false;
            r--;
            c++;
        }
        
        return true;
    }
}
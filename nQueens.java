//time complexity : O(n!) -> we get this cause we take only 3 directions to look at for the second queen..so options keep reducing for every different setting.

import java.util.*;
class nQueensSolution {
    List<List<String>> output = new ArrayList<>();
    
    public List<List<String>> solveNQueens(int n) {
        char[][] board=new char[n][n];
        
        for(int i=0; i < n; i++)
        {
            for(int j=0; j < n; j++)
            {
                board[i][j]='.';
            }
        }
        
        //backtracking
        backtracking(board, 0, n);
        
        return output;
    }
    
    private void backtracking(char[][] board, int i, int n)
    {
        //base 
        if(n == 0)
        {
            insertOutput(board);
            return;
        }
        
        //recursive
        for(int j = 0; j < board.length; j++)
        {
            if(isSafe(board, i, j))
            {
                board[i][j] = 'Q';
                backtracking(board, i + 1, n - 1);
                board[i][j] = '.';
            }
        }
        
    }
    
    private void insertOutput(char[][] board)
    {
        List<String> tempList = new ArrayList<>();
        for(int i = 0; i < board.length; i++)
        {
            String temp = "";
            for(int j = 0; j < board[0].length; j++)
            {
                temp += board[i][j];
            }
            tempList.add(temp);
        }
        output.add(tempList);
    }
    
    private boolean isSafe(char[][] board, int i, int j) {
        //check col
        
        for(int r = 0; r < i; r++)
        {
            if(board[r][j]=='Q')
                return false;
        }
        
        //check left diag
        
        int x = i-1;
        int y = j-1;
        
        while(x >= 0 && y >=0)
        {
            if(board[x][y]=='Q')
                return false;
            x -= 1;
            y -= 1;
        }
        
        //check right diag
        x = i - 1;
        y = j + 1;
        while(x >= 0 && y < board.length)
        {
            if(board[x][y]=='Q')
                return false;
            x -= 1;
            y += 1;
        }
       return true; 
    }
}
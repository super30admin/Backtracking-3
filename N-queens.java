import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<String>> result;
    boolean[][]board;
    public List<List<String>> solveNQueens(int n) {
         board = new boolean[n][n];
        result=new ArrayList<>();
       backtrack(0);
       return result;
    }
    private void backtrack( int row)
    {
        if(row==board.length)
        {
            List<String> ans= new ArrayList<>();
            for(int i=0;i<board.length; i++)
            {
                StringBuilder sb= new StringBuilder();
                for(int j=0; j<board.length; j++)
                {
                    if(board[i][j]==true)
                    {
                        sb.append('Q');
                    }
                    else
                    {
                        sb.append('.');
                    }
                }
                ans.add(sb.toString());
            }
            result.add(ans);
            return;  // return is neccessary as it will terminate the loop
        }
        for(int i=0; i<board.length; i++)
        {
            if(isSafe(row,i))
            {
                board[row][i]=true;
                //recurse
                backtrack(row+1);
                //backtrack
                board[row][i]=false;
            }
        }
    }
    private boolean isSafe(int row, int col)
    {
        //check upper direction
        for (int i = row; i >=0; i--) {
            if(board[i][col] == true) {
                return false;
            }
        }
        //check left diagonal
        int i=row; int j=col;
        while(i>=0 && j>=0)
        {
            if(board[i][j]==true)
            {
                return false;
            }
            i--;
            j--;
        }
        //check right diagonal
         i=row; 
         j=col;
        while(i>=0 && j<board.length)
        {
            if(board[i][j]==true)
            {
                return false;
            }
            i--;
            j++;
            if (j >= board.length) {  // Prevent j from going out of bounds
        break;
    }
        }
        return true;
    }
}

// Time Complexity : O(n xn!)
// Space Complexity : O(1)- Since the search is in place
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : Confused about the backtracking step


// Your code here along with comments explaining your approach
import java.util.*;
class Solution {
    List<List<String>> output = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0 ; i <n;i++)
        {
            for(int j = 0 ; j <n;j++)
            {
                board[i][j] ='.';
            }
        }
        //backtracking
        backtracking(board,n,0);
        return output;
        
    }
    private void backtracking(char[][] board,int n,int i)
    {
        if(n==0)
        {
            //add to the output
            output.add(insert_char_to_output(board));
            return; 
        }
        for(int j = 0; j <board.length;j++)
        {
            if(isSafe(board,i,j))
            {
                board[i][j]= 'Q';
                backtracking(board,n-1,i+1);
                board[i][j]='.';
            }
        }
        
    }
    private List<String> insert_char_to_output(char[][] board)
    {
        List<String> temp = new ArrayList<>();
        for(int i = 0 ;i <board.length;i++)
        {
            String t = "";
            for(int j = 0; j <board.length;j++)
            {
                t+=board[i][j];
            }
            temp.add(t);
        }
        return temp;
    }
    private boolean isSafe(char[][] board,int r , int c)
    {
        //check column
         for(int i = 0 ; i <r;i++)
        {
            if(board[i][c] == 'Q')
                return false;
        }
        
        //check left diagonal
        int x =r-1;
        int y = c-1;
        while(x>=0 && y >=0)
        {
            if(board[x][y]=='Q')
                return false;
            x--;
            y--;
        }
        
        //check right diagnal
        x =r-1;
        y = c+1;
        while(x>=0 && y <board.length)
        {
            if(board[x][y]=='Q')
                return false;
            x--;
            y++;
        }
        
        return true;
        
    }
}

// Time Complexity : O(N!)
// Space Complexity :O(N! x N^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach: We will start by putting the first queen in the first row and first column, then we will try to put the queen in the next row aftter checking if it is safe  to put there. 
//Whenever we complete all the rows this way we will add the combination to the result. If at any point we are not able to put a queen in the current row, then we backtrack, move the previous queen to the next column and then try again. 
//We will backtrack after storing every combination in the result list. 

class Solution {
    List<List<String>> result= new ArrayList<>();
    public List<List<String>> solveNQueens(int n) 
    {
        this.result=new ArrayList<>();
        boolean board[][]=new boolean [n][n]; //creating an empty board
        helper(board,0,n);  // board, row=0 & length of the row 
        return result;      
    }
    private void helper(boolean [][] board,int r,int n)
    {
        //base
        if(r==n) //if it is the last row
        {
            List <String> li=new ArrayList<>();  
            for(int i=0;i<n;i++)
            {
                StringBuilder sb=new StringBuilder();
                for(int j=0;j<n;j++)
            {
                //if we find a queen in a cell, then we put Q in the string, otherwise we put a dot
                if(board[i][j]) 
                {
                    sb.append('Q'); // Add Q when you find a queen
                }
                else
                {
                    sb.append('.'); // Add '.' when you don't find a queen
                }
            }
            li.add(sb.toString()); //Add the string to the inner List
            }
            result.add(li); // Add the inner list to the final list
          
        }

        //logic
        for(int j=0;j<n;j++)    //We will be moving from one row to the other
        {
            //If it is safe to put a queen in a cell
            if(isSafe(board,r,j))
            {  //action
                board[r][j]=true;
            
            //recurse
            helper(board,r+1,n);
            //backtrack
            board[r][j]=false;
            }
        }
        
    } 
   

    private boolean isSafe(boolean [][] board,int r,int c)
    {
        //Column upward
        for(int i=0;i<=r;i++)
        {
            if(board[i][c]) return false;
        }

        //Diagonal upright 
        int i=r,j=c;
        while(i>=0 && j<board.length)
        {
            if(board[i][j]) 
            {
                return false;
            }
            i--;
            j++;
        }

        //Diagonal upleft
        i=r;j=c;
        while(i>=0 && j>=0)
        {
            if(board[i][j]) 
            {
                return false;
            }
            i--;
            j--;
        }

        return true;
    }

}
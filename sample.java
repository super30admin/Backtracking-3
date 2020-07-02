//https://leetcode.com/problems/n-queens/
// Time Complexity : O(n!) as at each row there are n choice then n-2 then n-4
// Space Complexity : O(n^2) board 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


class Solution {
    List<List<String>> result; //global result
     int board[][]; //board to store where queens are placed
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        board = new int[n][n]; //initilaized to n*n
        
        if(n==0)
            return result; //edge case
        
        backtrack(0,n); //calling backtracking func on 0th row
        
        return result;
    }
    
    private void backtrack(int r, int n)
    {
        //base
        if(r == n) // if we crossed the last row
        {
            List<String> list = new ArrayList<>(); // create a list
            for(int i=0 ;i<n;i++) //iterate through the board
            {  
                StringBuilder sb = new StringBuilder(); // a string builder for each row
                for(int j=0;j<n;j++)
                {
                    if(board[i][j] == 0) // if 0 found
                        sb.append('.');
                    else
                        sb.append('Q'); // if queen found
                }
                list.add(sb.toString());      //add the string to list
            }
            result.add(list); // add the list to final result...multiple lists possible
        }


        //logic
        for(int c=0; c<n; c++) // going through each column for the row
        {
            //action
            if(isSafe(r,c,n)) //checking if it is safe to place queen there
            {
            board[r][c] = 1; // if its safe, place the queen
            //recurse
            backtrack(r+1,n); // go to next row
            //backtrack
            board[r][c] = 0; // invalid path so backtrack the move of putting the queen
            }
        }
    }
    
    private boolean isSafe(int r, int c, int n)
    {
        //upper column
        for(int i=0; i<r; i++) // going from top to the row
        {
            if(board[i][c]==1) // checking for the column if queen is already present it will block
                return false;
        }
        
        //left diagnol
        int i = r-1;
        int j = c-1;
        while(i>=0 && j>=0) 
        {
            if(board[i][j] == 1) // checking for the column if queen is already present it will block
                return false;
            
            i--;
            j--;
        }
        
        //right diagnol
         i = r-1;
         j = c+1;
        while(i>=0 && j<n)
        {
            if(board[i][j] == 1) // checking for the column if queen is already present it will block
                return false;
            
            i--;
            j++;
        }
        
        return true;
    }
}

//https://leetcode.com/problems/word-search
// Time Complexity : O(m*n * 3^l)
// Space Complexity : O(m*n) recursion stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


class Solution {
    int m, n;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        
        //edge case
        if(board == null || board.length == 0)
            return false;
        
        for(int i=0;i<m;i++) // going over the board
        {
            for(int j=0;j<n;j++)
            {
                if(backtrack(board, i,j, word, 0)) // calling function at each point without checking
                    return true;
            }
        }
       return false; 
    }
    
    private boolean backtrack(char[][] board, int i, int j, String word, int index)
    {
        //base
        if(index == word.length()) // if we reached the end of word
            return true; 
        
        if(i<0 || j<0 || i==m || j==n || board[i][j] == '#') // if out of bounds
            return false;
        
        
        //logic
        int dirs[][] = {{-1,0},{0,-1},{1,0},{0,1}}; // to traverse all four directions
        if(board[i][j] == word.charAt(index)) // checking if the value is what is at word's index
        {
            //action
            char temp = board[i][j]; // store it in local temp
            board[i][j] = '#'; //mark it vistied
            
            //recurse
            for(int dir[]: dirs) // traverse all 3 directions
            {
                int r = i + dir[0];
                int c = j + dir[1];
                
               if(backtrack(board, r, c, word, index+1)) return true; // if the string is found return true at this point only
            }
            
            //backtrack
             board[i][j] = temp; // reset value to local temp
        }
        
        return false; 
    }
}
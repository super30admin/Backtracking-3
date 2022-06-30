//****N-QUEENS - BACKTRACKING FOR LOOP BASED RECURSION****
//Time complexity-n!;
//Space complexity: n^2
//For time complexity: we are goind in each row like n options then n-1 options then n-2 options which is n!
class Solution {
    List<List<String>> result;
    
    public List<List<String>> solveNQueens(int n) {
        result=new ArrayList<>();
        boolean[][] board=new boolean[n][n];
        backtrack(board, 0, n);
        return result;
    }
    
    private void backtrack(boolean[][] board, int r, int n)
    {
        //Base
        if(r==n)
        {
            //Convert boolean to string and add it to the result
            List<String> li=new ArrayList<>();
            
            for(int i=0;i<n;i++)
            {
                StringBuilder sb=new StringBuilder();
                for(int j=0;j<n;j++)
                {
                    if(board[i][j])
                    {
                        sb.append('Q');
                    }
                    else
                    {
                        sb.append('.');   
                    }
                    
                }
                li.add(sb.toString());
            }
            result.add(li);
            return;
        }
        
        //logic
        //Iterating in the each col in the row 0,1,2,3;
        for(int j=0;j<n;j++)
        {
            //If the board[][] position is safe, place the queen
            if(issafe(board, r, j, n))
            {
                //action
                board[r][j]=true;
                //recurse
                //-Going to the next row
                backtrack(board, r+1, n);
                //backtrack
                board[r][j]=false;
                
            }
        }
        
    }
    
    private boolean issafe(boolean[][] board, int r, int c, int n)
    {
        //check for the upper column
        for(int i=0;i<r;i++)
        {
            if(board[i][c])
            {
                return false;
            }
            
        }
        
        //Check for upper left diagonal
        //r--, c--
        //But if we play with r and c, we will loose the pivot, Instead create a copy!
        int i=r;
        int j=c;
        while(i>=0 && j>=0)
        {
            if(board[i][j])
            {
                return false;
            }
            i--;
            j--;
        }
        
        //check for upper right diagonal 
        //For that resetting the i & j;
        i=r;
        j=c;
        while(i>=0 && j<n)
        {
            if(board[i][j])
            {
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
}


//****WORD SEARCH****
//Time complexity:3^L
//Space complexity: 0(m*n);

class Solution {
    int m;
    int n;
    int [][] dirs;
    public boolean exist(char[][] board, String word) {
        dirs=new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
        //Null case
        if(board.length==0)
        {
            return false;
        }
        m=board.length;
        n=board[0].length;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(word.charAt(0)==board[i][j])
                {
                    if(dfs(board, word, i, j , 0 ))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
        
    }
    
    private boolean dfs(char[][] board, String word,int i, int j, int index)
    {
        //Base
        if(index==word.length()) return true;
        
        if(i<0 || j<0 || i==m ||j==n || board[i][j]=='#')
        {
            return false;
        }
        
        //Logic
        if(board[i][j]==word.charAt(index))
        {
            for(int[] dir: dirs)
            {
                int r=dir[0]+i;
                int c=dir[1]+j;
                //action
                board[i][j]='#';
                //recurse
                if(dfs(board, word, r, c, index+1)) return true;
                //backtrack
                board[i][j]=word.charAt(index);
            }
            
        }
        return false;
        
        
        
    }
}

//If I have found the first letter 
//Use the directions array and go for the next letter
//Backtrack if we dont find any letter further

// TC:O(M*N*4^L)
// SC:O(K) recursion stack 
// APPROACH:
// Start by iterating over each cell in the board and check if it matches the first character of the word.
// If a matching character is found, perform a depth-first search (DFS) from that cell, considering neighboring cells in four directions.
// During the DFS, mark visited cells with a special character and recursively explore valid neighboring cells until the entire word is formed or no further valid paths are available.
// If the entire word is formed during the DFS, set the result flag to true, otherwise backtrack by restoring the original character at each visited cell. Finally, return the result flag indicating whether the word can be formed on the board
class Solution {
    String word;
    char[][] board;
    boolean ans;
    int[][] dirs={{-1,0},{1,0},{0,-1},{0,1}};

    public boolean exist(char[][] board, String word) {
    this.word=word;
    this.board=board;
    ans=false;
    if(board.length==1 && board[0].length==1 && word.length()==1 && board[0][0]==word.charAt(0))
    return true;
    for(int i=0;i<board.length;i++)
    {
        for(int j=0;j<board[0].length;j++)
        {
            if(board[i][j]==word.charAt(0))
            {
                dfs(i,j,0);
                if(ans)
                return true;
            }
        }
    } 
    // printMatrix(board); 
    return ans;
    }


    public void dfs(int row,int col, int si)
    {
        
        //base
        if(si==word.length())
        {
            ans=true;
            return;
        }
        //logic
        if(board[row][col]==word.charAt(si))
        {
            char temp=board[row][col];
            // ACTION
            board[row][col]='#';
            // RECURSE
            for(int i=0;i<dirs.length;i++)
            {
                int nr=row+dirs[i][0];
                int nc=col+dirs[i][1];
            
                if(nr>=0 && nc>=0 && nr<board.length && nc<board[0].length)
                {
                        // System.out.println(nr+ " "+ nc);
                        dfs(nr,nc,si+1); 

                        // Optimisation step for Depth First Search 
                        if (ans) { return; }            
                }
            } 
            // BACKTRACK
            board[row][col]=temp;
        }
        else
        {
            return;
        }
    
    }
}

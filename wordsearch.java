class Solution {
    //tc - (m*n) 3 l(l is length of the word)
    //sc- l(length of thewrod, height of the tree)
    private int[][]dirs;
    int m;
    int n;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        dirs = new int [][]{{0,1},{1,0},{0,-1},{-1,0}};
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(backtrack(i,j,word,0,board)) return true;
            }
        }
        return false;
    }
    private boolean backtrack(int i,int j,String word, int index,char[][]board)
    {
        //base case
        if(index == word.length()) return true;
        if(i<0 || j<0 || i==m || j== n|| board[i][j] == '#') return false;
        //logic
        
        if(board[i][j] == word.charAt(index))
        {
            //char c = board[i][j];
            //action
            board[i][j] = '#';
            
            for(int[] dir : dirs)
            {
                int nr = dir[0]+i;
                int nc = dir[1]+j;
                //recurse
                if(backtrack(nr,nc,word,index+1,board)) return true;
            }
            //backtrack
            board[i][j] = word.charAt(index);
              
        }
        return false;
    }
}
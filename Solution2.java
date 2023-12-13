//Word Search
//TC: m*n*3^k where k is length of word to search
//SC : O(1)
class Solution2 {
    boolean flag;
    int[][] dirs;
    int m;
    int n;
    public boolean exist(char[][] board, String word) {

       m=board.length;
       n=board[0].length;
       dirs=new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
       for(int i=0;i<m;i++)
       {
           for(int j=0;j<n;j++)
           {
               if(!flag)//word not found
               {
                   backtrack(board,word,i,j,0);
               }
           }
       }
       return flag;
    }
    //idx is to track index of char in word
    private void backtrack(char[][] board,String word,int i,int j,int idx)
{
    //base
    if(idx==word.length())
    {
        flag=true;
        return;
    }
    if(i<0 || i>=m || j<0 || j>=n || board[i][j]=='#')
    {
        return;
    }

    //logic

    //action
    if(board[i][j]==word.charAt(idx))
    {
        board[i][j]='#'; //mark the word on board as visited
        //recurse...go to its neighbours in dfs order
        for(int[] dir:dirs)
        {
            int r=dir[0]+i;
            int c=dir[1]+j;
            if(!flag)
            {
                backtrack(board,word,r,c,idx+1);
            }  
            if(flag) break;    

        }
        //backtrack
        board[i][j]=word.charAt(idx);
    }
}
}
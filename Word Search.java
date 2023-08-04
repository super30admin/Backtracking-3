
// Time Complexity :O((mxn)3L) L: Length of the string
// Space Complexity : O(m*n*L)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


// We will do DFS here. We will keep a pointer on the given word and then keep searching for it in the matrix from (0,0). 
//We will move in all four directions of the cell and check if the character at the pointer where the word is matches with the character in the cell. 
//If it does then we move the pointer to the next character in the word, and if it doesn't then we backtrack the action of marking the cell as visited and we move to other directions from the previous cell 

class Solution {
    boolean flag;
    private int dirs[][];
    public boolean exist(char[][] board, String word) {
        this.dirs=new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        int m=board.length, n=board[0].length;

        for(int i=0;i<m;i++)
        {
            for (int j=0;j<n;j++)
            {
                if(!flag)
                {
                    backtrack(board,word,i,j,0); // board,word,row,col,index of the character in the word
                }
            }
        }
        return flag;   
    }

    private void backtrack (char[][] board, String word,int i,int j,int idx)
    {
        //base
        if(idx==word.length())
        {
            flag=true;
            return;
        }

        if(i<0 || j<0 || i==board.length || j==board[0].length || board[i][j]=='#') return;

        //logic

        if(word.charAt(idx)==board[i][j]) //if the character of the word matches with the one in the cell
        {
            board[i][j]='#';
            for(int[] dir:dirs)
            {
                int nr=dir[0]+i;
                int nc=dir[1]+j;

                if(!flag) //if the flag is false then we recurse again
                {
                    backtrack(board,word,nr,nc,idx+1);
                }
                if (flag) //if flag is true, we break
                {
                    break;
                }
            }

            

            //backtrack
            board[i][j]=word.charAt(idx);

        }
    }
}
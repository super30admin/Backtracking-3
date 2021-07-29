// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(word.charAt(0)==board[i][j] && searchletter(i,j,board,word,0))
                    return true;
            }
        }
        return false;
    }
    
    public boolean searchletter(int i,int j,char[][] b,String word,int position)
    {
        if(position==word.length())
            return true;
        if(i<0 || j<0 || i>=b.length || j>=b[0].length)//if it is out of boundary then return false
            return false;
        if(word.charAt(position) != b[i][j]){
            return false;
    }
        char t=b[i][j];
        b[i][j]='*';//to keep track of visited ones
        if(searchletter(i+1,j,b,word,position+1) || searchletter(i-1,j,b,word,position+1) || searchletter(i,j+1,b,word,position+1) || searchletter(i,j-1,b,word,position+1)){
            return true;
    }
        b[i][j]=t;//backtrack
        return false;
    }
}
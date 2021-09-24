/* Time Complexity :  O(3^L * m*n)
   Space Complexity :   O(L) where L is length of string and m and n are dimensions of board
   Did this code successfully run on Leetcode : Yes
   Any problem you faced while coding this : No
*/
class Solution {
    int m,n;
    int[][] dirs;
    public boolean exist(char[][] board, String word) {
        m=board.length;
        n=board[0].length;
        dirs =new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(word.charAt(0)==board[i][j]){
                    if(dfs(board,word,i,j,0))
                        return true;
                }
            }
        }
        return false;        
    }
    private boolean dfs(char[][] board, String word, int p,int q,int in){ 
        if(in==word.length())
            return true;
        if(p<0 || p == board.length || q<0 || q==board[0].length || word.charAt(in)!=board[p][q]){
            return false;
        }
        char c = board[p][q];
        board[p][q]='#';
        for(int[] dir :dirs){
            int nr=dir[0]+p;
            int nc=dir[1]+q;
            if(dfs(board,word,nr,nc,in+1))
                return true;    
        }
        board[p][q]=c;
        return false;
    }
}
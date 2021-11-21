// Time Complexity : O(N. 3^L)
// Space Complexity : O(n*m)
// Any problem you faced while coding this : No

class Solution {
    public boolean exist(char[][] board, String word) {
        int index=0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                 if(helper(board,i,j,index,word))return true;
            }
        }
       return false;
    }
    
    public boolean helper(char[][] board, int i, int j, int index, String word){
        if(index==word.length()){
            return true;
        }
        
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j]=='#'){
            return false;
        }
        
        if(board[i][j]==word.charAt(index)){
        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
        
        for(int[] dir:dirs){
            int row=i+dir[0];
            int col=j+dir[1];
            char c=board[i][j];
            board[i][j]='#';
            if(helper(board,row, col,index+1, word)) return true;
            board[i][j]=c;
        }
        }
        
        return false;
    }
}
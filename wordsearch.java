/*
Time Complexity: O(N.3^L)
Space Complexity: O(L)
*/
class Solution {
    public boolean exist(char[][] board, String word) {
        int n=board.length,m=board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(helper(board,word.toCharArray(),i,j,0))return true;
            }
        }
        return false;
    }
    
    public boolean helper(char[][]board,char[] word,int i,int j,int index){
        int n=board.length,m=board[0].length;
        
        if(index==word.length){
            return true;
        }
        
        if(i<0||j<0||i>=n||j>=m||word[index]!=board[i][j])return false;
        
        int[]c={1,0,-1,0,1};
        board[i][j]=' ';
        for(int q=0;q<4;q++){
            if(helper(board,word,i+c[q],j+c[q+1],index+1))return true;
        }
        board[i][j]=word[index];
        
        return false;
    }  
}
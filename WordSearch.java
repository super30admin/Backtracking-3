// Time Complexity : O(4*(m*n)). m is the number of rows in the board. n is the number of columns in the board
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    char savedLetter =' ';
    boolean visited[][];
    public boolean exist(char[][] board, String word) {
        
        if(board==null || board.length==0 || word.length()==0) return false;
        
        visited=new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                
                if(word.charAt(0)==board[i][j] && 
                   backtrack(board,i,j,word,0)) return true;
            }
        }
        return false;
          
    }
    
    private boolean backtrack(char[][] board,int i,int j,String word,int index){
     
        if(word.length()==index) return true;
        
        if(i<0 ||i>=board.length
           || j<0 || j>=board[0].length || word.charAt(index)!=board[i][j]
         || visited[i][j]) return false;
        
        visited[i][j]=true;
        //savedLetter=board[i][j];
       // board[i][j]='.';
        
        if(backtrack(board,i+1,j,word,index+1) ||
        backtrack(board,i-1,j,word,index+1) ||
        backtrack(board,i,j+1,word,index+1) ||
        backtrack(board,i,j-1,word,index+1) ) return true;
        
        visited[i][j]=false;
       // board[i][j]=savedLetter;
        return false;
    }
}

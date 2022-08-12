// Time Complexity : o(m*n) 
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no




// Your code here along with comments explaining your approach

class Solution {
    int m,n;
    String word;
    int[][] dirs;
    boolean isValid;
    public boolean exist(char[][] board, String word) {
        m=board.length;
        n=board[0].length;
        isValid=false;
        dirs= new int[][] {{0,-1},{-1,0},{1,0},{0,1}};
        this.word=word;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                  
                    if(backtracking(board,i,j,0)){
                        //backtracking(board,i,j,0);
                        return true;
                    }
                    
                    }
                
            }
          return false;
        }
  
    
    private boolean backtracking(char[][] board,int r,int c,int strindex){
        // base case
        if(strindex==word.length()){
            //isValid=true;
            return true ;
        }
        
        if(r<0 || c<0 || r>=m || c>=n || board[r][c]!=word.charAt(strindex)){
            return false;
        }
        // logic 
        
        if(board[r][c]==word.charAt(strindex)){
            char o=board[r][c];
            board[r][c]='#';
            for(int[] dir: dirs){
                int nr = dir[0] + r;
                int nc = dir[1] + c;
                if(backtracking(board,nr,nc,strindex+1)){
                    return true;
                }
            }
            board[r][c]=o;
        }
            
    return false;
    }
}
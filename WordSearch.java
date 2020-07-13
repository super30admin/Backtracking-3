// Time Complexity : O(m*n * 4^L) m and n - rows and columns,    L - length of word
// Space Complexity :O(L)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class WordSearch {
    public boolean exist(char[][] board, String word) {
        if(board==null || board.length==0) return false;
        int n = board.length;
        int m = board[0].length;
        int[][] visited = new int[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(helper(board,visited,word,i,j)) return true;
            }
        }
        return false;
    }
    
    private boolean helper(char[][] board, int[][] visited,String word, int row, int col){
        
        if(visited[row][col]==1) return false;
        
        
                if(board[row][col]==word.charAt(0))
                {
                    visited[row][col] = 1;
                    if(word.length()==1) return true;
                    //right
                    if((col+1)<board[0].length){
                    if(helper(board, visited,word.substring(1),row,col+1)) return true;
                    }
                    
                    //down
                    if((row+1)<board.length){
                    if(helper(board, visited,word.substring(1),row+1,col)) return true;
                    }
                    
                    //left
                    if((col-1)>=0){
                    if(helper(board, visited,word.substring(1),row,col-1)) return true;
                    }
                    
                    //up
                    if((row-1)>=0){
                    if(helper(board, visited,word.substring(1),row-1,col)) return true;
                    }
                    
                    visited[row][col] = 0;
        }
        
        return false;
        
    }
}
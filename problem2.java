// 79 Word Search
// sovled on leetcode
// Time complexity: m*n*3^n
// space complexity: O(m)

class Solution {
    
    int [][] dirs;
    int n,m;
    public boolean exist(char[][] board, String word) {
        
        dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(isThere(i,j,board,word,0)) return true;
            }
        }
        
        return false;
    }
    
    
    private boolean isThere(int row,int col,char[][] board, String word, int index){
        // base
        
        if(index==word.length()){
            return true;
        }
        
        if(row<0 || col<0 || row == board.length || col == board[0].length || board[row][col]== '@'){
            return false;
        }
        
        // logic
        if(board[row][col]==word.charAt(index)){
            
            // action 
            char ch = word.charAt(index);
            board[row][col]= '@';
            
            // recurse
            for(int [] x: dirs){
                int i = row + x[0];
                int j = col + x[1];
                
                if(isThere(i,j,board,word,index+1)) return true;
            }
            
            // backtrack
            board[row][col]= ch;
            
            
        }
        
        return false;
    }
    
    
}
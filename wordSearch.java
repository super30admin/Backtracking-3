//TC: O(n)
//SC: O(1)
class Solution {
    private int[][] dirs; 
    int m;
    int n;
    public boolean exist(char[][] board, String word) {
        
        //null check
        if(board == null || board.length == 0) return false;
        
        
         m = board.length; //row
         n = board[0].length; //col
        dirs = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}}; //direction array to move in matrix
        for(int i=0; i < m; i++){
            for(int j=0; j < n; j++){
                if(backtracking(board,i,j,0,word)) return true; //calling backtracking func & return true if all letters are found in the word
            }
        }
        return false;
    }
    
    private boolean backtracking(char[][] board, int i, int j , int index, String word ){
        
        //base
        if(index == word.length()) return true;
        if(i < 0 || j < 0 || i == m || j == n || board[i][j] == '#') return false;
         
        //logic
        if(board[i][j] == word.charAt(index)){
            char ch = board[i][j];
            
            //action
            board[i][j] = '#';
            for(int[] dir : dirs){
                int r = dir[0] + i;
                int c = dir[1] + j;
                
                //recurse
               if(backtracking(board, r, c, index+1, word)) return true;
            }
            
            //backtrack
            board[i][j] = ch;
        }
        return false;
        
    }
    
}

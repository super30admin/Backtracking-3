//word search
//tc N⋅3 power L  // L is word length
//sc mn

class Solution {
    private int[][] dirs;
    int m, n;
    
    public boolean exist(char[][] board, String word) {
       //null
        if(board==null || board.length==0 || board[0]==null || board[0].length==0){
           return false;
       }
        m = board.length;
        n = board[0].length;
        dirs = new int[][] {{0,1}, {1,0}, {-1,0}, {0,-1}};
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(backtrack(board, word, 0, i, j)) return true;
            }
        }
        return false;
    }
    
    private boolean backtrack(char[][] board, String word, int index, int i, int j){
        //base
        
        if(index==word.length()) return true;
        
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j]=='#') return false;
        
        
        //logic
        
        if(board[i][j]==word.charAt(index)){
            //action
            char c = word.charAt(index);
            
            board[i][j]='#';
            
            //recurse for
            //{{0,1}, {1,0}, {-1,0}, {0,-1}}
            for(int[] dir:dirs){
                int nr = i + dir[0];
                int nc = j + dir[1];
                if(backtrack(board, word, index+1, nr, nc)) return true;
            }
            
            //backtrack
            
            board[i][j] = c;
            
            
        }
        return false;
    }
}

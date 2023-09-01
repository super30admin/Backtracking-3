//O(m*n * 3^word.length())
//SC: O(length of the word)
//when we have connected components use bfs/dfs
//backtracking always with dfs

class Solution {
    int[][] dirs;
    int m;
    int n;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        dirs = new int[][] {{0,1}, {1,0}, {-1,0}, {0,-1}};
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(helper(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }
    
    private boolean helper(char[][] board, String word, int i, int j, int index){
        //base
        if(index == word.length()) return true;
        if(i < 0 || j < 0 || i==m || j== n || board[i][j] == '#') return false;
        //logic
        if(board[i][j] == word.charAt(index)){
                    //action -> mark cell visited if word matches the character at that cell
        char c = board[i][j]; //store the character so after backtracking u know which char was     replaced/marked as visited
        board[i][j] = '#';
        
        for(int[] dir: dirs){
            int nr = i + dir[0];
            int nc = j + dir[1];
            //recurse
            if(helper(board, word, nr, nc, index+1)) return true; 
            }
         //backtrack
         board[i][j] = c;
        }
        return false;
    }
}

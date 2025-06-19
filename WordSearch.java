// DFS recurse with backtracking
// Time Complexity = O (m*n*3^L), L is length of the word
// Space Complexity = O (L)
class Solution {
    int [][] dirs;
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        this.dirs=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        for(int i =0; i<m; i++){
            for(int j =0; j<n; j++){
                if(helper(board, i,j,word,0)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean helper(char[][]board,int r, int c, String word, int idx){
        //base
        if(idx == word.length()){
            return true;
        }
        if(r<0 || c<0 || r ==board.length || c == board[0].length){
            return false;
        }
        
        //logic
        if(board[r][c] == word.charAt(idx)){
            //action
            board[r][c] = '#';
            //recurse
            for(int [] dir: dirs){
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (helper(board,nr,nc,word,idx+1)){
                    return true;
                }
            }
            //backtrack
            board[r][c] = word.charAt(idx);
        }
        return false;
    }
}
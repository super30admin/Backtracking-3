// Time Complexity = O(m*n*3^l)
// Space Complexity = O(n)

class Solution {
    private int [][] dirs;
    public boolean exist(char[][] board, String word) {
        if(board == null) return false;
        dirs = new int [][] {{-1,0}, {1,0}, {0, 1}, {0,-1}};
        int m = board.length;
        int n = board[0].length;
        for(int i = 0;i<m;i++){
            for(int j =0;j<n;j++){
                if(backtrack(i,j,board,word,0,m,n)){
                    return true;
                }
            }
            
        }
        return false;
    }
    private boolean backtrack(int i, int j, char[][] board, String word, int idx, int m, int n){
        //base
        if(idx == word.length()) return true;
        if(i < 0 || j < 0 || i ==m || j == n || board[i][j] == '#') return false;
        
        if(board[i][j] != word.charAt(idx)) return false;
        
        //logic
        board[i][j] = '#';
        
        for(int [] dir: dirs){
            //action
            int r = dir[0] + i;
            int c = dir[1] + j;

            if(backtrack(r,c, board, word, idx+1, m, n)) return true;
        }
        board[i][j] = word.charAt(idx);
        return false;
    }
}
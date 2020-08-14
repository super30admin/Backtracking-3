//TC: O(3^(n*l))
//SC: O(l), n: length of board, l: length of word
class Solution {
    int m; int n;
    public boolean exist(char[][] board, String word) {
        m = board.length; n = board[0].length;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(dfs(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int i, int j, int index){
        if(index == word.length()) return true;
        if(i<0 || j < 0 || i>=m || j >= n || board[i][j]=='#') return false;
        
        int[][] dirs = {{-1,0}, {1,0},{0,-1},{0,1}};
        if(word.charAt(index) == board[i][j]){
            //action
            char temp = board[i][j];
            board[i][j] = '#';
            //recurse
            for(int[] dir : dirs){
                int r = i+dir[0];
                int c = j+dir[1];
                if(dfs(board, word, r, c, index+1)) return true;
            }
            //backtrack
            board[i][j] = temp;
        }
        return false;
    }
}

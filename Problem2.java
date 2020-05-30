//time o(mn) * (4 pow L), L - length of the word, m - rows, n - cols
//space o(L) => recursive stack
class Solution {
    int m, n;
    int[][] dirs={{0,1},{-1,0},{0,-1},{1,0}};
    public boolean exist(char[][] board, String word) {
        
        if(board == null || board.length == 0)
            return false;
        m = board.length;
        n= board[0].length;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(backtrack(board, word, i, j))
                    return true;
            } 
        }
        return false;
    }
    
    private boolean backtrack(char[][] board, String word, int i, int j) {
        //base case
        if(word.length() == 0)
            return true;
        if(i< 0 || i >=m || j<0 || j>=n || board[i][j] == '#')
            return false;
        //logic
        if(board[i][j] == word.charAt(0))
        {
            char prev = board[i][j];
             //action
            board[i][j] = '#';
            for(int[] dir: dirs) {
                int r = i + dir[0];
                int c = j + dir[1];
                // recurse
                if(backtrack(board, word.substring(1), r, c))
                    return true;
            }
            //backtrack
            board[i][j] = prev; 
        }
        return false;
    }
}
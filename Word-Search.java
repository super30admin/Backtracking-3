//time - O(4^n)
//space - O(n)
class Solution {
    int[][] dirs;
    int[][] visited;
    int n,m;
    public boolean exist(char[][] board, String word) {
        if(board==null || board.length==0) return false;
        n = board.length; m = board[0].length;
        visited = new int[n][m];
        dirs = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j]==word.charAt(0)){
                    boolean result = helper(i, j, 0, word, board);
                    if(result) return true;
                }
            }
        }
        return false;
    }
    private boolean helper(int row, int col, int index, String word, char[][] board){
        //base
        if(index==word.length()) return true;

        if(row < 0 || col < 0 || row==n || col==m || board[row][col]=='#') return false;

        if(board[row][col]==word.charAt(index)){
            //action
            char ch = board[row][col];
            board[row][col] = '#';

            //recurse
            for(int[] dir : dirs){
                int nr = row + dir[0];
                int nc = col + dir[1];
                if(helper(nr, nc, index+1, word, board)==true) return true;
            }

            //backtrack
            board[row][col] = ch;
        }

        return false;
    }
}

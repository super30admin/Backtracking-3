//Time: O(M*N)*3^(Length of the string- no of possibilities for each character in the word)
// Space: O(M*N) for the visited array + O(Length of word) for the recursive call stack

class Solution {
    boolean[][] visited; // O(M*N)
    int n, m;
    boolean result;
    int[][] dirs = {{0,-1},{-1,0},{0,1},{1,0}};
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        result = false;
        for(int i=0;i<m && !result;i++) {
            // we are also additionally checking for the result condition
            // if we found the path once we will not proceed anymore
            for(int j=0;j<n && !result;j++) {
                // we start the dfs from the first character we catch in the matrix
                if(board[i][j] == word.charAt(0)) {
                    dfs(board, i, j, 0, word);
                }
            }
        }
        return result;
    }
    private void dfs(char[][] board, int row, int col, int count, String word) {
        // we put this in front because if the matrix has only one element,
        // in the first visit here, we would go down to the dirs-for loop
        // mark visited[row][col] to true
        // so if this is placed after the normal base condition,
        // we will never capture the result at all
        if(count == word.length()) {
            result = true;
            return;
        }
        if(row <0 || col<0 || row == m || col == n || visited[row][col] || result) return;
        // only if there's a match between curr row col and character at which count is right now in word
        if(board[row][col] == word.charAt(count)) {
            // action
            visited[row][col] = true;
            //recurse
            for(int[] dir: dirs) {
                int nRow = dir[0]+row;
                int nCol = dir[1]+col;
                dfs(board,nRow,nCol,count+1, word);
            }
            // backtrack
            // only if we complete finding the worrd,
            // we will come here
            visited[row][col] = false;
        }
    }
}

//Space Optimised Soln
// Time: No change | Space: O(L)
class Solution {
    int n, m;
    boolean result;
    int[][] dirs = {{0,-1},{-1,0},{0,1},{1,0}};
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        result = false;
        for(int i=0;i<m && !result;i++) {
            for(int j=0;j<n && !result;j++) {
                if(board[i][j] == word.charAt(0)) {
                    dfs(board, i, j, 0, word);

                }
            }
        }
        return result;
    }
    private void dfs(char[][] board, int row, int col, int count, String word) {
        if(count == word.length()) {
            result = true;
            return;
        }
        if(row <0 || col<0 || row == m || col == n || board[row][col] == '*' || result) return;
        if(board[row][col] == word.charAt(count)) {
            // instead of having a visited array
            // just doing in-place or state change operation at every character match
            board[row][col] = '*';
            for(int[] dir: dirs) {
                int nRow = dir[0]+row;
                int nCol = dir[1]+col;
                dfs(board,nRow,nCol,count+1, word);
            }
            // backtrack it back to original character
            // retrieval through count stored in the respective recursive call stack
            board[row][col] = word.charAt(count);
        }
    }
}

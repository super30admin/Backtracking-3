// Time Complexity: O(m * n * (3^L)) L -> length of the word
// Space Complexity: O(L) L -> length of the word

class Solution {
    int m ; int n;
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0) return false;
        m = board.length;
        n = board[0].length;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(dfs(board, i, j, 0, word)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i , int j , int index, String word){
        //base case
        if(i < 0 || j < 0 || i == m || j == n || board[i][j] == '#' || board[i][j] != word.charAt(index)) return false;

        if(index == word.length() - 1)return true;

        // logic
        char temp = board[i][j];
        // action
        // marking the cell as visited
        board[i][j] = '#';
        int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
        for(int[] dir : dirs){
            int r = i + dir[0];
            int c = j + dir[1];
            // recurse
            if(dfs(board, r, c, index + 1, word)) return true;
        }
        //backtrack
        board[i][j] = temp;
        return false;
    }
}

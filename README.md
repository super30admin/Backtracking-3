# Backtracking-3

## Problem1 
N Queens(https://leetcode.com/problems/n-queens/)
TC : O(N!)
SC : O(N*N)

Approach:-
1. We will place the Queen in a particular row and col and call isValid 
2. If the isValid returns true we will go for placing queen in the next row else we will place the queen in the same row but different col
3. If we reach end of the row we will add the valid nqueen combination


class Solution {

    List<List<String>> result;

    public List<List<String>> solveNQueens(int n) {
        
        if(n == 0){
            return new ArrayList<>();
        }

        result = new ArrayList<>();
        
        char[][] board = new char[n][n];

        for(int i = 0; i < n; i++){
            Arrays.fill(board[i], '.');
        }

        nQueen(board, 0);

        return result;
    }

    private void nQueen(char[][] board, int r){
        //base case
        if (r == board.length) { 
            List<String> temp = new ArrayList<>();
            for (char[] row : board) {
                temp.add(new String(row));
            }
            result.add(temp);
            return;
        }

        for(int i = 0; i < board.length; i++){
            board[r][i] = 'Q';

            //check if the queen placement is correct
            if(isValid(board, r, i)){
                nQueen(board, r+1);
            }

            board[r][i] = '.';
        }
    }

    private boolean isValid(char[][] board, int r, int c){
        
        // Check column 
        for(int i = 0; i < r; i++){
            if(board[i][c] == 'Q'){
                return false;
            }
        }

        // Check Top-Left diagonal
        int row = r - 1;
        int col = c - 1;
        while(row >= 0 && col >= 0){
            if(board[row][col] == 'Q'){
                return false;
            }
            row--;
            col--;
        }

        // Check Top-Right diagonal
        row = r - 1;
        col = c + 1;
        while(row >= 0 && col < board.length){
            if(board[row][col] == 'Q'){
                return false;
            }
            row--;
            col++;
        }

        return true;
    }
}

## Problem2
Word Search(https://leetcode.com/problems/word-search/)

TC : O(M*N)
SC : O(K) : k = length of the word

Approach:-
1. We will find the first letter of the word in the board and perform dfs on it
2. We will mark the cell visited and check if the word at the correct index matches the word in the current cell
3. Once we reach the end of the letter that means we found our string and we will return true

class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (backtrack(board, i, j, word, 0)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean backtrack(char[][] board, int row, int col, String word, int ind) {
        // Check if full word is found
        if (ind == word.length()) {
            return true;
        }

        // Boundary and character checks
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length ||
            board[row][col] == '#' || word.charAt(ind) != board[row][col]) {
            return false;
        }

        // Mark as visited
        char visited = board[row][col];
        board[row][col] = '#';

        // Explore all 4 directions
        int[][] dir = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };
        for (int[] d : dir) {
            int r = row + d[0];
            int c = col + d[1];
            if (backtrack(board, r, c, word, ind + 1)) {
                return true;
            }
        }

        // Backtrack (unmark visited)
        board[row][col] = visited;

        return false;
    }
}
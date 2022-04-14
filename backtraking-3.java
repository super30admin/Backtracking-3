# Backtracking-3

## Problem1 
N Queens(https://leetcode.com/problems/n-queens/)

class Solution {
    List<List<String>> result;
    boolean[][] board;
    int m;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        m = n;
        board = new boolean[m][m];
        if(n == 0) return result;
        backtrack(0);
        return result;
    }
    private void backtrack(int r) {
        //base
        if(r == m) {
            List<String> li = new ArrayList<>();
            for(int i = 0; i< m; i++) {
                StringBuilder sb = new StringBuilder();
                for(int j=0; j< m; j++) {
                    if(board[i][j])
                        sb.append('Q');
                    else sb.append('.');
                }
                li.add(sb.toString());
            }
            result.add(li);
            return;
        }
        //logic
        for(int j=0; j<m; j++) {
            if(isSafe(r, j)) {
                //action
                board[r][j] = true;
                //recurse
                backtrack(r+1);
                //backtrack
                board[r][j] = false;
            }
        }
    }
    private boolean isSafe(int r, int c) {
        for(int i=0; i<r; i++) {
            if(board[i][c]) return false;
        }
        int i = r; int j = c;
        while(i >= 0 && j < m ) {
            if(board[i][j]) return false;
            i--; j++;
        }
        i = r; j = c;
        while(i >= 0 && j>= 0) {
            if(board[i][j]) return false;
            i--; j--;
        }
        return true;
    }
}

## Problem2
Word Search(https://leetcode.com/problems/word-search/)

class Solution {
    int m, n;
    int[][] dirs;
    public boolean exist(char[][] board, String word) {
        m = board.length; n = board[0].length;
        dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(backtrack(board, i, j, word, 0)) return true;
            }
        }
        return false;
    }
    private boolean backtrack(char[][] board, int r, int c, String word, int index) {
        //base
        if(index == word.length()) return true;
        if(r < 0 || r == m || c < 0 || c == n || board[r][c] == '#') return false;
        //logic
        if(board[r][c] == word.charAt(index)) {
            //action
            char ch = board[r][c];
            board[r][c] = '#';
            for(int[] dir: dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                //recurse
                if(backtrack(board, nr, nc, word, index+1)) return true;
            }
            //backtrack
            board[r][c] = ch;
        }
        return false;
    }
}
# Backtracking-3

## Problem1

N Queens(https://leetcode.com/problems/n-queens/)

//Time complexity = exponential
//Space complexity = n\*n

class Solution {
List<List<String>> result;
boolean[][] board;
public List<List<String>> solveNQueens(int n) {
result = new ArrayList();
if(n == 2 || n == 3) {
return result;
}
board = new boolean[n][n];
helper(n, 0);
return result;
}

    private void helper(int n, int r) {
        //base
        if(r == n) {
            List<String> temp = new ArrayList();

            for(int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < n; j++) {
                    if(board[i][j]) {
                       sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                temp.add(sb.toString());
            }
            result.add(temp);
        }
        //logic
        for(int j = 0; j < n; j++) {
            if(isSafe(r, j, n)) {
                board[r][j] = true;
                helper(n,r+1);
                board[r][j] = false;
            }
        }
    }
    private boolean isSafe(int r,int c, int n) {
        //column
        for(int i = 0; i < r; i++) {
            if(board[i][c]) {
                return false;
            }
        }
        //diagonal left
        int i = r;
        int j = c;
        while(i >= 0 && j >= 0) {
            if(board[i][j]) {
                return false;
            }
            i--;
            j--;
        }

        //diagonal right
        i = r;
        j = c;
        while(i >= 0 && j < n) {
            if(board[i][j]) {
                return false;
            }
            i--;
            j++;
        }
        return true;
    }

}

## Problem2

Word Search(https://leetcode.com/problems/word-search/)

//Time complexity = exponential
//Space complexity = n\*n

class Solution {
int[][] dirs;
int m;
int n;
public boolean exist(char[][] board, String word) {
if(word.length() == 0) {
return true;
}
if(board.length == 0 || board == null) {
return false;
}
dirs = new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
m = board.length;
n = board[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == word.charAt(0)) {
                   if(helper(board, i, j, word,0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean helper(char[][] board,int r,int c, String word, int index) {
        //base
        if(index == word.length()) {
            return true;
        }

        if(r < 0 || c < 0 || r >= m || c >= n  || board[r][c] != word.charAt(index)) {
            return false;
        }
        //logic
        char temp = board[r][c];
        board[r][c] = '#';

        for(int[] dir : dirs) {
            int nR = r + dir[0];
            int nC = c + dir[1];
            if(helper(board, nR, nC, word, index+1)) {
                return true;
            }
        }
        board[r][c] = temp;
        return false;
    }

}

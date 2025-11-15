// Time Complexity :O(n*n!) n: checking isValid, n!: to place n queens in n rows
// Space Complexity :O(n^2)+O(n)
// Did this code successfully run on Leetcode :yes
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> answer = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        helper(board,0,n,answer);
        return answer;
    }
    private void helper(boolean[][] board, int row, int n,List<List<String>> answer) {
        if (row == n) {//there is a queen in each row
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();//build a string for each row
                for (int j = 0; j < n; j++) {
                    if (board[i][j]) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                list.add(sb.toString());//add row to list
            }
            answer.add(list);//add list to answer
            return;
        }
        for (int j = 0; j < n; j++) {
            if (isValid(board, row, j, n)) {
                //action
                board[row][j] = true;
                //recurse
                helper(board, row + 1, n,answer);
                //backtrack
                board[row][j] = false;
            }
        }
    }
    private boolean isValid(boolean[][] board, int i, int j, int n) {
        int r = i, c = j;
        while (r >= 0) {//up
            if (board[r][c])
                return false;
            r--;
        }
        r = i;
        c = j;
        while (r >= 0 && c >= 0) {//upper left diagonal
            if (board[r][c])
                return false;
            r--;
            c--;
        }
        r = i;
        c = j;
        while (r >= 0 && c < n) {//upper right diagonal
            if (board[r][c])
                return false;
            r--;
            c++;
        }
        return true;
    }
}

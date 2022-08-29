// Time Complexity : O(n!) // possible options left decreases
// Space Complexity : O(n*n) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

import java.util.*;

class Solution {
    List<List<String>> result;
    boolean[][] grid;
    int N;

    public List<List<String>> solveNQueens(int n) {
        grid = new boolean[n][n];
        result = new ArrayList<>();
        // null check
        if (n == 0)
            return result;
        N = n;
        helper(0);
        return result;
    }

    private void helper(int i) {
        // base
        if (i == N) { // when all queens are placed.
            List<String> solution = new ArrayList(); // arraylist for each ccombination
            for (int r = 0; r < N; r++) {
                StringBuilder temp = new StringBuilder(); // strings for each row to show posiitons.
                for (int c = 0; c < N; c++) {
                    if (grid[r][c] == true)
                        temp.append('Q');
                    if (grid[r][c] == false)
                        temp.append('.');
                }
                solution.add(temp.toString());
            }
            result.add(solution); // add all the possible combinations
        }
        // logic
        for (int j = 0; j < N; j++) {
            // check if it is safe to place queen in that position
            if (isSafe(i, j)) {
                // action make it true
                grid[i][j] = true;
                // recurse go to the next row.
                helper(i + 1);
                // backtrack;
                grid[i][j] = false;
            }
        }
    }

    private boolean isSafe(int r, int c) { // check if there is a queen in the same column and diagnol up, neednot check
                                           // row as we are placing one in a row and we will be placing from row 0.
        // column up
        for (int i = 0; i <= r; i++) {
            if (grid[i][c])
                return false;
        }
        // diagnol left up
        int i = r, j = c;
        while (i >= 0 && j >= 0) {
            if (grid[i][j])
                return false;
            i--;
            j--;
        }
        // diagnol right up
        i = r;
        j = c;
        while (i >= 0 && j < N) {
            if (grid[i][j])
                return false;
            i--;
            j++;
        }
        return true;
    }
}
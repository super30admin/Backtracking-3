// Time Complexity :O(n!)
// Space Complexity :O(n^2)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

//we are at each position, checking if the position is valid then,put queen there. if that position is not valid
//we go to next column,if we are out of columns, we rearrange our previous row Queens using backtracking
//and at the end we add valid positions in result
class Solution {
    private List<List<String>> result;
    private int sizeQ;

    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        if (n == 0)
            return result;
        sizeQ = n;
        boolean[][] arr = new boolean[n][n];

        helper(0, arr);

        return result;
    }

    private void helper(int r, boolean[][] arr) {
        // edge case
        if (r == sizeQ) {
            List<String> ls = new ArrayList<>();
            for (int i = 0; i < sizeQ; i++) {
                StringBuilder s = new StringBuilder();

                for (int j = 0; j < sizeQ; j++) {
                    if (arr[i][j] == true) {
                        s.append('Q');
                    } else {
                        s.append('.');
                    }
                }
                ls.add(s.toString());
            }
            result.add(ls);
            return;
        }
        // logic
        for (int i = 0; i < sizeQ; i++) {
            if (checkPos(r, i, arr)) {
                arr[r][i] = true;
                // action
                helper(r + 1, arr);
                // backtrack
                arr[r][i] = false;
            }

        }

    }

    private boolean checkPos(int i, int j, boolean[][] arr) {
        int row = i;
        int col = j;
        // System.out.println("row and col are "+row+" "+col);
        // check upper left
        while (row >= 0 && col >= 0) {
            if (arr[row][col] == true) {
                return false;
            }
            row--;
            col--;
        }
        row = i;
        col = j;
        // upper right
        while (row >= 0 && col < sizeQ) {
            if (arr[row][col] == true) {
                return false;
            }
            row--;
            col++;
        }
        row = i;
        col = j;
        // straight row
        while (row >= 0) {
            if (arr[row][col] == true) {
                return false;
            }
            row--;
        }
        return true;
    }
}
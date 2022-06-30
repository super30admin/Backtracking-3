// Time Complexity : O(n!)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;

class Main {
    private static List<List<String>> result;

    public static List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        // null case
        if (n == 0)
            return result;
        // to place queen at particular index I am using boolean matrix of n*n
        boolean[][] box = new boolean[n][n];
        // calling backTrack function
        backTrack(box, 0, n);
        return result;

    }

    private static void backTrack(boolean[][] box, int r, int n) {
        // base case
        if (r == n) {
            // make a list of queen location at each row
            List<String> li = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                // using string builder because string is immutable structure
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    // when there is a queen at particular index I add Q to the
                    // StringBuilder or add '.'
                    if (box[i][j]) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                li.add(sb.toString());
            }
            result.add(li);

        }
        // main logic

        for (int i = 0; i < n; i++) {
            // check is this place is safe to put queen there
            if (isSafe(box, r, i, n)) {
                // if yes I will make this index true
                // action
                box[r][i] = true;
                // recurse
                backTrack(box, r + 1, n);
                // backTrack
                box[r][i] = false;
            }
        }
    }

    private static boolean isSafe(boolean[][] box, int r, int c, int n) {
        // check column that is it any queen there in same column.
        for (int i = 0; i < r; i++) {
            if (box[i][c]) {
                return false;
            }
        }
        // check diagonally
        // to preserve original index
        int i = r;
        int j = c;
        while (i >= 0 && j >= 0) {
            if (box[i--][j--]) {
                return false;
            }
        }
        i = r;
        j = c;
        while (i >= 0 && j < n) {
            if (box[i--][j++]) {
                return false;
            }
        }
        // if queen is safe to place return true
        return true;

    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(solveNQueens(n));
    }
}
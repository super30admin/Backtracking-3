// Time Complexity : O(n!)
// Space Complexity : O(n^2) for the board and O(n) for recursive stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
Initialize a board first of boolean matrix where we can construct the expected output as 'Q' and '.' whenever
cell has true & false values respectively.But, to identify if we can place a queen in a cell and mark it as true
or not, we need to check if its valid position or not.So, we maintain 3 boolean arrays to check the rules for same
column, diagonal, and anti-diagonal violations. We do a row recursion checking each column iteratively to identify
any violations and marking the cell as true.For diagonal violation, the sum of row and column value are same and
for anti diagonal violation, the difference row and column are same, we add an offset of n value for easy check.
 */
class Solution {
    List<List<String>> result;
    boolean[][] board;
    boolean[] colSet;
    boolean[] diagSet;
    boolean[] antiDiagSet;
    public List<List<String>> solveNQueens(int n) {
        this.result = new ArrayList<>();
        this.board = new boolean[n][n];
        this.colSet = new boolean[2*n];
        this.diagSet = new boolean[2*n];
        this.antiDiagSet = new boolean[2*n];
        helper(0, n);
        return result;
    }

    private void helper(int row, int n) {
        if(row == n) {
            List<String> temp = new ArrayList<>();
            for(int i = 0 ; i < n ; i++) {
                StringBuilder sb = new StringBuilder();
                for(int j = 0 ; j < n ; j++) {
                    if(board[i][j]) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                temp.add(sb.toString());
            }
            result.add(temp);
        }

        for(int col = 0 ; col < n ; col++) {
            int diagIndex = row + col;
            int antiDiagIndex = row - col + n;
            if(!colSet[col] && !diagSet[diagIndex] && !antiDiagSet[antiDiagIndex]) {
                colSet[col] = true;
                diagSet[diagIndex] = true;
                antiDiagSet[antiDiagIndex] = true;

                board[row][col] = true;
                helper(row + 1, n);
                board[row][col] = false;

                colSet[col] = false;
                diagSet[diagIndex] = false;
                antiDiagSet[antiDiagIndex] = false;

            }
        }
    }
}
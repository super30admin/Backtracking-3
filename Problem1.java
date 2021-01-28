// https://leetcode.com/problems/n-queens/
// Time complexity : O(N!) 
// Space complexity : O(N*N)

class Solution {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        int queenPosition[][] = new int[n][n];
        helper(0, n, queenPosition);
        return res;
    }

    public void helper(int row, int n, int queenPosition[][]) {
        if (row == n) {
            generateBoard(queenPosition);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(row, col, queenPosition)) {
                queenPosition[row][col] = 1;
                helper(row + 1, n, queenPosition);
                queenPosition[row][col] = 0;
            }
        }
    }

    public boolean isValid(int row, int col, int queenPosition[][]) {
        for (int i = 0; i < row; i++) {
            if (queenPosition[i][col] == 1) {
                return false;
            }
        }

        int i = row;
        int j = col;
        while (i >= 0 && j >= 0) {
            if (queenPosition[i--][j--] == 1) {
                return false;
            }
        }

        i = row;
        j = col;
        while (i >= 0 && j < queenPosition[0].length) {
            if (queenPosition[i--][j++] == 1) {
                return false;
            }
        }

        return true;
    }

    public void generateBoard(int queenPosition[][]) {
        List<String> rowList = new ArrayList<>();
        for (int row[] : queenPosition) {
            StringBuilder s = new StringBuilder();
            for (int cell : row) {
                if (cell == 1) {
                    s.append('Q');
                } else {
                    s.append('.');
                }

            }
            rowList.add(s.toString());
        }
        res.add(rowList);
    }

}
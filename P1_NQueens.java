// TC: n!
// SC: n^2
class Solution {
    private boolean isSafe(int row, int col, boolean[][] mat) {
        //col
        for(int i=0 ; i<row ; i++) {
            if(mat[i][col])
                return false;
        }
        //left up
        int i=row;
        int j=col;
        while(i >= 0 && j >= 0) {
            if(mat[i][j])
                return false;
            i--;
            j--;
        }
        //right up
        i=row;
        j=col;
        while(i>=0 && i <mat.length && j <mat.length) {
            if(mat[i][j])
                return false;
            i--;
            j++;
        }
        return true;
    }
    private void helper(int n, int row, boolean[][] mat, List<List<String>> result) {

        if(row == mat.length) {
            List<String> path = new ArrayList<>();
            for(int i=0 ; i<mat.length ; i++) {
                String temp = "";
                for(int j=0 ; j<mat.length ; j++) {
                    if(mat[i][j]) {
                        temp+="Q";
                    } else {
                        temp+=".";
                    }
                }
                path.add(temp);

            }
            result.add(path);
        }

        for(int i=0 ; i<mat.length ; i++) {
            if(isSafe(row, i, mat)) {
                mat[row][i] = true;
                helper(n, row+1, mat, result);
                mat[row][i] = false;
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        boolean[][] mat = new boolean[n][n];
        helper(n, 0, mat, result);
        return result;
    }
}

// Time Complexity: O(n!)
// Space Complexity: O(n^2)
class Solution {

    List<List<String>>  result;
    boolean mat[][];

    public List<List<String>> solveNQueens(int n) {
        this.result = new ArrayList<>();
        this.mat = new boolean[n][n];

        helper(n, 0);

        return result;
    }

    private void helper(int n, int row){

        // base
        if(row == n){
            List<String> li = new ArrayList<>();
            for(int i=0; i<n; i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0;j <n; j++){
                    if(mat[i][j]){
                        sb.append('Q');
                    }else{
                        sb.append('.');
                    }
                }
                li.add(sb.toString());
            }
            result.add(li);
            return;
        }


        // logic

        for(int i=0; i<n; i++){
            if(isSafe(row, i, n)){
                mat[row][i] = true;
                helper(n, row +1);
                mat[row][i] = false;
            }
        }
    }

    private boolean isSafe(int i, int j, int n){
        // column check
        int r =i, c = j;
        while(r >= 0){
            if(mat[r][c]) return false;
            r--;
        }

        // Top left diagonal
        r = i; c = j;
        while(r>=0 && c>=0){
            if(mat[r][c]) return false;
            r--;
            c--;
        }

        // top right diagonal
        r = i; c = j;
        while(r>=0 && c < n){
            if(mat[r][c]) return false;
            r--;
            c++;
        }
        return true;
    }
}
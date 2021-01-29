class Solution {
    List<List<String>> res = new ArrayList<>();
    int m = 0;
    public List<List<String>> solveNQueens(int n) {
        int[][] mat = new int[n][n];
        m = n;
        for(int i=0;i<m;i++)
            helper(mat, 0, i);
        return res;
    }
    
    private void helper(int[][] mat, int r, int c){
        if(r==m){
            //add it to result
            List<String> res1 = new ArrayList<>(); 
            StringBuilder sb;
            for(int i=0;i<m;i++){
                sb = new StringBuilder();
                for(int j=0;j<m;j++){
                    if(mat[i][j]==1){
                        sb.append('Q');
                    }else{
                        sb.append('.');
                    }
                }
                res1.add(sb.toString());
            }
            res.add(res1);
            return;
        }
        else if(r<0 || c<0 || r>=m || c>=m)
            return;
        if(isSafe(mat, r, c)){
            mat[r][c] = 1;
            for(int i=0;i<m;i++){
                if(!(r==m-1 && i>0)){
                helper(mat, r+1, i);
                }
            }
            mat[r][c] = 0;
        }
    }
    
    private boolean isSafe(int[][] mat, int r, int c){
        //check column
        for(int i=0;i<r;i++){
            if(mat[i][c] == 1)
                return false;
        }
        int i = r-1;
        int j = c-1;
        //check left-up
        while(i>=0 && j>=0){
            if(mat[i][j]==1){
                return false;
            }
            i--;
            j--;
        }
        //check right-up
        i = r-1;
        j = c+1;
        while(i>=0 && j<m){
            if(mat[i][j]==1){
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
}


//Time complexity - O(N!)  where N is the number of queens/rows/columns
//Space complexity - O(N)

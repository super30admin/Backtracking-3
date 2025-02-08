public class Problem1 {
    class Solution {
        //t.c- >O(n!) -> as no places dec as we move further
        //s.c ->O(n^2) +O(n)
        boolean[][] grid;
        List<List<String>> result;
        public List<List<String>> solveNQueens(int n) {
            if(n ==0){
                return new ArrayList<>();
            }
            result = new ArrayList<>();
            grid = new boolean[n][n];
            backtrack(0,n);
            return result;
        }
        private void backtrack(int row, int n){
            //base
            if(row == n){
                List<String> ans = new ArrayList<>();
                for(int i =0;i<n;i++){
                    StringBuilder sb = new StringBuilder();
                    for(int j = 0;j<n;j++){
                        if(grid[i][j]== true){
                            sb.append('Q');
                        }else{
                            sb.append('.');
                        }
                    }
                    ans.add(sb.toString());
                }
                result.add(ans);
                return;
            }


            //logic
            //for each box check if we're safe to put the queen if yess then do backtrack
            for(int i = 0;i<n;i++){
                if(isSafe(row,i,n)){
                    //action
                    grid[row][i] = true;
                    //recurse
                    backtrack(row+1,n);
                    //backtrack
                    grid[row][i] = false;
                }
            }
        }
        private boolean isSafe(int row, int col,int n){
            //check above the curr cell
            for(int i = row;i >=0 ;i--){
                if(grid[i][col] ==true){
                    return false;
                }
            }
            //check upper left diagonal from the curr cell
            int i = row;
            int j = col;
            while(i>=0 && j >=0 ){
                if(grid[i][j] ==true){
                    return false;
                }
                i--;
                j--;
            }

            //check upper right diagonal from the curr cell
            i = row;
            j = col;
            while(i>=0 && j <n){
                if(grid[i][j] ==true){
                    return false;
                }
                i--;
                j++;
            }
            return true;
        }
    }
}

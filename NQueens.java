/**Leetcode Question 51 - N Queens */
/**Algorithm - Backtracking */
/**TC - O(N^N)
 * SC - O(N^2)
 */
public class NQueens {
    class Solution {
        List<List<String>> result;
        int[][] board;
        int m;
        public List<List<String>> solveNQueens(int n) {
            result = new ArrayList<>();
            if(n == 0){
                return result;
            }
            m = n;
            board = new int[m][m];
            backtrack(0);
            return result;
        }
        private void backtrack(int r){
            //base
            if(r == m){
                List<String> path = new ArrayList<>();
                for(int i =0; i<m; i++){
                    StringBuilder s = new StringBuilder();
                    for(int j =0; j<m; j++){
                        if(board[i][j] == 1){
                            s.append('Q');
                        }
                        else{
                            s.append('.');
                        }
                    }
                    path.add(s.toString());
                }
                result.add(path);
                return;
            }
            //logic
            for(int c = 0; c < m; c++){
                if(isSafe(r,c)){
                    board[r][c] = 1;
                    backtrack(r+1);
                    board[r][c] =0;
                }
            }
        }
        private boolean isSafe(int r, int c){
            //column
            for(int i =0; i<r; i++){
                if(board[i][c] == 1){
                    return false;
                }
            }
            //upper left diagonal = row-col
            int k =r-1, l = c-1;
            while(k>=0 && l>=0){
                if(board[k][l]==1){
                    return false;
                }
                k--;
                l--;
            }
            //upper right diagonal = row + col
            k =r-1; l = c+1;
            while(k>=0 && l<m){
                if(board[k][l]==1){
                    return false;
                }
                k--;
                l++;
            }
            return true;
        }
    }
}

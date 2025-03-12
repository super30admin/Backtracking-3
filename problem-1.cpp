// https://leetcode.com/problems/n-queens/
// Time Complexity : O(n!) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class Solution {
    public:
        bool isSafe(int row, int col, vector<string> &res, int n){
            for(int i=row; i>=0; i--){
                if(res[i][col] == 'Q') return false;
            }
            for(int i=row, j=col; i>=0 && j>=0; i--,j--){
                if(res[i][j] == 'Q') return false;
            }
            for(int i=row, j=col; i>=0 && j<n; i--,j++){
                if(res[i][j] == 'Q') return false;
            }
            return true;
        }
        void helper(int n, int row, vector<vector<string>> &ans, vector<string> &res){
            if(row == n){
                ans.push_back(res);
                return;
            }
            for(int col=0; col<n; col++){
                if(isSafe(row, col, res, n)){
                    res[row][col] = 'Q';
                    helper(n, row+1, ans, res);
                    res[row][col] = '.';
                }
            }
        }
        vector<vector<string>> solveNQueens(int n) {
            vector<vector<string>> ans;
            vector<string> res(n, string(n,'.'));
            helper(n, 0, ans, res);
            return ans;
        }
    };
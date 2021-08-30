// Time Complexity : exponential (n^n) or (n!)
// Space Complexity :O(N*N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
public:
    vector<vector<bool>> grid;
    vector<vector<string>> result;
    vector<vector<string>> solveNQueens(int n) {
        if(n == 0)
            return result;
        grid.resize(n,vector<bool> (n));
        backtrack(n, 0);
        return result;
    }
    void backtrack(int n, int row){
        //base
        if(n==row){
            vector<string> li;
            for(int i=0; i<n; i++){
                string val;
                for(int j=0; j<n; j++){
                    if(grid[i][j])
                        val += 'Q';
                    else
                        val += '.';
                }
                li.push_back(val);
            }
            result.push_back(li);
            return;
        }
        //logic
        for(int i=0; i<n; i++){
            if(isSafe(n, row, i)){
                //action
                grid[row][i] = true;
                //recurse
                backtrack(n, row+1);
                //backtrack
                grid[row][i] = false;
            }
        }
    }
    
    bool isSafe(int n, int row, int col){
        //upper rows
        for(int i=0; i<row; i++){
            if(grid[i][col])
                return false;
        }
        //upper left diagonal
        int i=row, j=col;
        while(i>=0 && j>=0){
            if(grid[i][j])
                return false;
            i--;
            j--;
        }
        //upper right diagonal
        i=row;
        j=col;
        while(i>=0 && j<n){
            if(grid[i][j])
                return false;
            i--;
            j++;
        }
        return true;
    }
};

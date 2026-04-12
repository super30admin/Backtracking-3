// Time Complexity : O(n!)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Start with row 1 and go upto nth row
// For each cell, try placing a queen after checking there are no queens in the same col or the diagonals
// Backtrack after placing the queen to check other valid configurations

class Solution {
private:
    bool isValid(int row, int col, int n, vector<string>& currState) {
        // check column
        for(int i=row-1; i>=0; i--) {
            if(currState[i][col] == 'Q') return false;
        }

        // check diag - up - right
        int i = row-1; int j = col+1;
        while(i >=0 && j < n) {
            if(currState[i][j] == 'Q') return false;
            i--;
            j++;
        }
        // check diag - up - left
        i = row-1; j = col-1;
        while(i >= 0 && j >= 0) {
            if(currState[i][j] == 'Q') return false;
            i--;
            j--;
        }

        return true;
    }
    void helper(int row, int n, vector<string>& currState, vector<vector<string>>& valid) {
        if(row == n) {
            valid.push_back(currState);
            return;
        }
        string currRow(n, '.');
        for(int i=0; i<n; i++){
            if(isValid(row, i, n, currState)) {
                currRow[i]='Q';
                currState.push_back(currRow);
                helper(row+1, n, currState, valid);
                currRow[i] = '.';
                currState.pop_back();
            }
        }
    }
public:
    vector<vector<string>> solveNQueens(int n) {
        vector<string> currState;
        vector<vector<string>> valid;
        helper(0, n, currState, valid);
        return valid;
    }
};
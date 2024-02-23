// TC = O(n!) at each level, the choice of pur=tting Q becomes, n -> n-2 -> n-4 ... ie eqvlnt to n!
// SC = O(n^2) size of boolean board
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// for loop based recursive
class Solution {
public:
    vector<vector<string>> result;
    vector<vector<string>> solveNQueens(int n) {
        // null
        if(n == 0) return result;
        vector<vector<bool>> board(n, vector<bool>(n)); // SC=O(n2), boolean as its most efficient DS
        backtrack(board, 0, n); // SC = O(N) ie of Height but N2 above is the relevant term
        return result;
    }
    void backtrack(vector<vector<bool>>& board, int r, int n) {
        // base
        if(r == n) {
            vector<string> li; // convert boolean to string for result
            for(int i = 0; i < n; i++) {
                string s;
                for(int j = 0; j < n; j++) {
                    if(board[i][j]) s += 'Q';
                    else s +='.';
                }
                li.push_back(s);
            }
            result.push_back(li);
            return;
        }
        // logic
        for(int j = 0; j < n; j++) { // checking every cell (column) in each row
            if(isSafe(board, r, j, n)) {
                board[r][j] = true; // action
                backtrack(board, r + 1, n); // recurse
                board[r][j] = false; // backtrack
            }
        }
    }
    bool isSafe(vector<vector<bool>>& board, int r, int c, int n) {
        // up col
        for(int i = 0; i < r; i++) {
            if(board[i][c]) return false; // Queen found, cant place
        }
        // up left diag, r--, c--
        int i = r, j = c; // dont modify r & c
        while(i >= 0 && j >= 0) {
            if(board[i--][j--]) return false; // Queen found, cant place
        } 
        // up right diag, r--, c++
        i = r; j = c; // resetting i & j
        while(i >= 0 && j < n) {
            if(board[i--][j++]) return false; // Queen found, cant place
            }
        return true;
    }
};
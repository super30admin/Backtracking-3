// Time complexity is O(n!) - n decisions in row 0, n-2 decisions in row 1, n-4 decisions in row 2 and so on.
// Space complexity is O(n^2) - size of board 2D vector
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
public:
    vector<vector<string>> res;
    int m;
    
    vector<vector<string>> solveNQueens(int n) {
        m = n;
        vector<vector<int>> board(n,vector<int> (n, 0));
        backtrack(0, board);
        return res;
    }
private:
    void backtrack(int r, vector<vector<int>>& board) {
        //base
        if(r == m) {
            vector<string> temp;
            for(int i = 0; i < m; i++) {
                string str = "";
                for(int j = 0; j < m; j++) {
                    if(board[i][j] == 0)
                        str += ".";
                    else
                        str += "Q";
                }
                temp.push_back(str);
            }
            res.push_back(temp);
        }
        //logic
        for(int j = 0; j < m; j++) {
            if(isSafe(r, j, board)) {
                //action
                board[r][j] = 1;
                //recurse
                backtrack(r+1, board);
                //backtrack
                board[r][j] = 0;
            }
        }
    }
    
    bool isSafe(int r, int c, vector<vector<int>>& board) {
        // column up
        for(int i = 0; i <= r; i++) {
            if(board[i][c] == 1) return false; 
        }
        int i = r; int j = c;
        // diagonal up left
        while(i >= 0 && j >= 0) {
            if(board[i][j] == 1) return false;
            i--; 
            j--;
        }
        
        i = r; j = c;
        // diagonal up right
        while(i >= 0 && j < m) {
            if(board[i][j] == 1) return false;
            i--;
            j++;
        } 
        return true;
    }
};

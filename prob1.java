// Time Complexity : O(n^2)
// Space Complexity : O(n!*n^2)
// Did this code successfully run on Leetcode : Yes


class Solution {
public:
    bool isSafe(int row, int col, vector<string>& board, int n)
    {
        //check for same row
        int x = row;
        int y = col;

        while(y >= 0)
        {
            if(board[x][y] == 'Q')
            {
                return false;
            }
            y--;
        }

        //check for upper diagonals

        x = row;
        y = col;

        while(x >= 0 && y >= 0)
        {
            if(board[x][y] == 'Q')
            {
                return false;
            }
            x--;
            y--;
        }

        x = row;
        y = col;

        while(x < n && y >= 0)
        {
            if(board[x][y] == 'Q')
            {
                return false;
            }
            x++;
            y--;
        }
        return true;
    }
    void solve(int col, vector<vector<string>>& ans, vector<string>& board, int n)
    {
        if(col == n)
        {
            ans.push_back(board);
            return;
        }

        //solve 1 case and rest Recursion will take care
        for(int row = 0; row < n; row++)
        {
            if(isSafe(row, col, board, n))
            {
                board[row][col] = 'Q';
                solve(col + 1, ans, board, n);
                //backtrack
                board[row][col] = '.';
            }
        }
    }
    vector<vector<string>> solveNQueens(int n) {
          vector<string> board(n, string(n, '.'));
          vector<vector<string>> ans;

          solve(0, ans, board, n);

          return ans;
    }
};
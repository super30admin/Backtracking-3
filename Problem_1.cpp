// Author: Subhed Chavan
// Batch: December 24
// Problem Statement: N-Queens
// Approach: Backtracking
// TC: O(N!)
// SC: O(N^2)

class Solution
{
public:
    vector<vector<string>> result;
    vector<vector<bool>> grid;

    vector<vector<string>> solveNQueens(int n)
    {
        if (n == 0)
        {
            return result;
        }
        result.clear();
        grid = vector<vector<bool>>(n, vector<bool>(n, false));
        backtrack(0, n);
        return result;
    }

    void backtrack(int row, int n)
    {
        // Base case
        if (row == n)
        {
            vector<string> answer;
            for (int i = 0; i < n; i++)
            {
                string rowString;
                for (int j = 0; j < n; j++)
                {
                    rowString += (grid[i][j] ? 'Q' : '.');
                }
                answer.push_back(rowString);
            }
            result.push_back(answer);
            return;
        }

        // Recursive case
        for (int i = 0; i < n; i++)
        {
            if (isSafe(row, i, n))
            {
                grid[row][i] = true;
                backtrack(row + 1, n);
                grid[row][i] = false;
            }
        }
    }

    bool isSafe(int row, int col, int n)
    {
        for (int i = row; i >= 0; i--)
        {
            if (grid[i][col])
            {
                return false;
            }
        }
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
        {
            if (grid[i][j])
            {
                return false;
            }
        }
        for (int i = row, j = col; i >= 0 && j < n; i--, j++)
        {
            if (grid[i][j])
            {
                return false;
            }
        }
        return true;
    }
};

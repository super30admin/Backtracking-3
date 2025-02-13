// Author: Subhed Chavan
// Batch: December 24
// Problem Statement: Word Search
// Approach: Backtracking
// TC : O(m×n×3^k)
// SC : O(k)

class Solution
{
public:
    vector<vector<int>> dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    bool exist(vector<vector<char>> &board, string word)
    {

        if (board.size() == 0)
        {
            return false;
        }

        int m = board.size();
        int n = board[0].size();

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (board[i][j] == word[0])
                {
                    if (backtrack(board, i, j, word, 0))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    bool backtrack(vector<vector<char>> &board, int row, int col, string word,
                   int index)
    {
        // Base Case
        if (index == word.length())
        {
            return true;
        }

        if (row < 0 || row == board.size() || col < 0 ||
            col == board[0].size() || board[row][col] == '#')
        {
            return false;
        }

        // Logic
        if (board[row][col] == word[index])
        {
            // Action
            char temp = board[row][col];
            board[row][col] = '#';

            // Recurse
            for (int i = 0; i < dirs.size(); i++)
            {
                int nr = row + dirs[i][0];
                int nc = col + dirs[i][1];
                if (backtrack(board, nr, nc, word, index + 1))
                {
                    return true;
                }
            }

            // Backtrack
            board[row][col] = temp;
        }

        return false;
    }
};
// 79. Word Search
// Time Complexity : O(3^n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

// 
class Solution {
public:
    bool exist(vector<vector<char>>& board, string word) {
        int m = board.size(), n = board[0].size();
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(board[i][j] == word[0])
                {
                    if(helper(board, word, "", i, j)) return true;
                } 
            }
        }
        return false;
    }
    bool helper(vector<vector<char>>& board, string word, string curr, int row, int col)
    {  
        if(curr == word)
            return true;

        if (row < 0 || col < 0 || row >= board.size() || col >= board[0].size() ||  board[row][col] == '#' || curr.size() >= word.size() || board[row][col] != word[curr.size()])
            return false;

        board[row][col] = '#';
        bool found = (helper(board, word, curr + word[curr.size()], row + 1, col) ||
        helper(board, word, curr + word[curr.size()], row - 1, col) ||
        helper(board, word, curr + word[curr.size()], row, col + 1) ||
        helper(board, word, curr + word[curr.size()], row, col - 1));
        board[row][col] = word[curr.size()];

        return found;
    }
};

        

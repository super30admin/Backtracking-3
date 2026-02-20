class Solution {
public:
    bool dfs(vector<vector<char>>& board, int i, int j, string& word, int index) {
        if (index == word.length()) {
            return true;
        }

        if (i >= 0 && j >= 0 && i < board.size() && j <board[0].size() && board[i][j] == word[index]) {

            char ch = board[i][j];
            board[i][j] = ' ';

            bool status = dfs(board, i+1, j, word, index+1) ||
            dfs(board, i, j+1, word, index+1) ||
            dfs(board, i-1, j, word, index+1) ||
            dfs(board, i, j-1, word, index+1);

            board[i][j] = ch;
            return status;
        } 
        return false;
    }
    bool exist(vector<vector<char>>& board, string word) {
        for (int i=0;i<board.size();i++) {
            for (int j=0;j<board[0].size();j++) {
                if (board[i][j] == word[0] && dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
};

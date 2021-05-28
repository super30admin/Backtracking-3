/*
Intuition: We need to perform dfs for every character in the word and then mark it visited.
If the entire word is not found, we need to unmark it as visited and perform dfs on the next character.

//////////////////////////////////////////////
Time Complexity: O(3^N), N = number of cells
Space Complexity: O(L), Length of word
//////////////////////////////////////////////
*/
class Solution {
public:
    bool res;
    int rows, cols;
    vector<vector<int>> dirs;
    bool exist(vector<vector<char>>& board, string word) {
        if (word == "") return true;
        if (board.size() == 0 || board[0].size() == 0) return false;
        res = false;
        rows = board.size(), cols = board[0].size();
        dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        for (int i = 0; i < rows; ++i){
            for (int j = 0; j < cols; ++j){
                backtrack(board, i, j, word, 0);
                if (res){
                    return res;
                }
            }
        }
        return res;
    }
private:
    void backtrack(vector<vector<char>> &board, int i, int j, string &word, int idx){
        //base
        if (idx == word.length()) {
            res = true; return;
        }
        if (i < 0 || j < 0 || i >= rows || j >= cols || board[i][j] != word[idx]) return;
        //logic
        //action
        char temp = board[i][j];
        board[i][j] = '.'; 
        //recurse

        backtrack(board, i + 1, j, word, idx + 1);
        backtrack(board, i , j + 1, word, idx + 1);
        backtrack(board, i - 1, j, word, idx + 1);
        backtrack(board, i, j - 1, word, idx + 1);
        //backtrack
        board[i][j] = temp;
    }
};
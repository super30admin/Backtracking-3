// Using BackTracking
// Time complexity is O(m*n* 3^L) = O(3^L) where m*n is size of the board and L is the length of the word
// Space complexity is O(L)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
public:
    int row, col;
    vector<vector<int>> directions;
    bool backtrack(vector<vector<char>>& board, string word, int index, int i, int j) {
        //base
        if(index == word.size()) return true;
        if(i < 0 || i == row || j < 0 || j == col || board[i][j] == '#') return false;
        //logic
        //action
        char temp;
        if(board[i][j] == word[index]) {
            temp = board[i][j];
            board[i][j] = '#';
            
            //recurse
            for(auto dir : directions) {
                int nRow = i + dir[0]; // nRow = neighbor row index
                int nCol = j + dir[1]; // nCol = neighbor column index
                if(backtrack(board, word, index+1, nRow, nCol)) return true;
            }
            
            //backtrack
            board[i][j] = temp;
        }
        return false;
    }
    
    bool exist(vector<vector<char>>& board, string word) {
        //edge
        if(board.size() == 0) return false;
        row = board.size();
        col = board[0].size();
        directions = {{0,1},{0,-1},{1,0},{-1,0}};
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(backtrack(board, word, 0, i, j)) return true;
            }
        }
        return false;
    }
};

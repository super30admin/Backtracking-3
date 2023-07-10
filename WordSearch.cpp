//Time Complexity: 
//Space Complexity: 

class Solution {
public:
    bool exist(vector<vector<char>>& board, string word) {
        char firstLetter = word[0];
        vector<vector<bool>> visited(board.size(), vector<bool>(board[0].size(), false));
        for(int i = 0; i < board.size(); i++) {
            for(int j = 0; j < board[0].size(); j++) {
                if(board[i][j] == firstLetter) {
                    if(wordExists(i, j, board, visited, word, 0)) return true;  
                }
            }
        }
        return false;     
    }

    bool wordExists(int row, int col, vector<vector<char>>& board, vector<vector<bool>>& visited, string word, int wordIndex) {
        if(wordIndex >= (int)word.size()) return true; 
        
        if(row < 0 || row >= board.size() || col < 0 || col >= board[0].size()) return false; 

        if(board[row][col] == word[wordIndex] && !visited[row][col]) {
            visited[row][col] = true; 
            if(wordExists(row+1, col, board, visited, word, wordIndex+1)) return true; 
            if(wordExists(row-1, col, board, visited, word, wordIndex+1)) return true; 
            if(wordExists(row, col+1, board, visited, word, wordIndex+1)) return true;
            if(wordExists(row, col-1, board, visited, word, wordIndex+1)) return true;   
            visited[row][col] = false;                       
        }
        return false; 
    }
};